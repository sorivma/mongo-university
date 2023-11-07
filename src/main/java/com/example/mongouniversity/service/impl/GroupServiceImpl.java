package com.example.mongouniversity.service.impl;

import com.example.mongouniversity.exception.ClientErrorException;
import com.example.mongouniversity.model.Group;
import com.example.mongouniversity.model.GroupSummary;
import com.example.mongouniversity.repo.GroupRepository;
import com.example.mongouniversity.service.GroupService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    private GroupRepository groupRepository;
    private final MongoTemplate mongoTemplate;

    public GroupServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Autowired
    public void setGroupRepository(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group createGroup(Group group) {
        group.getStudents().forEach(student -> {
            if (student.getObjectId() == null) {
                ObjectId id = ObjectId.get();
                student.setObjectId(id);
            }
        });
        return groupRepository.save(group);
    }

    @Override
    public Group getGroup(ObjectId id) {
        return groupRepository.findById(id).orElseThrow(
                () -> new ClientErrorException.NotFoundException("Faculty with given id: [%s] not found", id));
    }

    @Override
    public void deleteGroup(ObjectId id) {
        groupRepository.deleteById(id);
    }

    @Override
    public void deleteAllGroups() {
        groupRepository.deleteAll();
    }

    @Override
    public void saveAllGroups(List<Group> groups) {
        groups.forEach(this::createGroup);
    }

    @Override
    public Page<Group> getGroups(Pageable pageable) {
        return groupRepository.findAll(pageable);
    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public List<GroupSummary> getSummary() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("students").exists(true)),
                Aggregation.unwind("students"),
                Aggregation.group("name").count().as("numberOfStudents")
        );

        AggregationResults<GroupSummary> results = mongoTemplate.aggregate(
                aggregation, "group", GroupSummary.class
        );

        System.out.println(results.getRawResults());

        return results.getMappedResults();
    }
}
