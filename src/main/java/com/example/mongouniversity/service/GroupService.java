package com.example.mongouniversity.service;

import com.example.mongouniversity.model.Faculty;
import com.example.mongouniversity.model.Group;
import com.example.mongouniversity.model.GroupSummary;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GroupService {
    Group createGroup(Group group);

    Group getGroup(ObjectId id);

    void deleteGroup(ObjectId id);

    void deleteAllGroups();

    void saveAllGroups(List<Group> groups);

    Page<Group> getGroups(Pageable pageable);

    List<Group> getAllGroups();

    List<GroupSummary> getSummary();
}
