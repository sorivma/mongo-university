package com.example.mongouniversity.controller;

import com.example.mongouniversity.model.Group;
import com.example.mongouniversity.model.GroupSummary;
import com.example.mongouniversity.service.GroupService;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    Group getById(@PathVariable String id) {
        return groupService.getGroup(new ObjectId(id));
    }

    @PostMapping
    Group save(Group group) {
        return groupService.createGroup(group);
    }

    @GetMapping("/summary")
    Iterable<GroupSummary> getSummary() {
        return groupService.getSummary();
    }

    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable String id) {
        groupService.deleteGroup(new ObjectId(id));
    }
}
