package com.example.mongouniversity.repo;

import com.example.mongouniversity.model.Faculty;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends MongoRepository<Faculty, ObjectId> {
}
