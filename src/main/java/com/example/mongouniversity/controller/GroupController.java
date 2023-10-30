package com.example.mongouniversity.controller;

import com.example.mongouniversity.model.Group;
import com.example.mongouniversity.model.GroupSummary;
import com.example.mongouniversity.service.GroupService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }


    @GetMapping("/all")
    Iterable<Group> getAll() {
        return groupService.getAllGroups();
    }

    @GetMapping
    Page<Group> getAllPageable(Pageable pageable) {
        return groupService.getGroups(pageable);
    }

    @PostMapping
    Group save(Group group) {
        return groupService.createGroup(group);
    }

    @GetMapping("/summary")
    Iterable<GroupSummary> getSummary() {
        return groupService.getSummary();
    }
}
