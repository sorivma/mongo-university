package com.example.mongouniversity.repo;

import com.example.mongouniversity.model.Group;
import com.example.mongouniversity.model.GroupSummary;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends MongoRepository<Group, ObjectId> {
    List<Group> findByFacultyId(ObjectId facultyId);
}
