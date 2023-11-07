package com.example.mongouniversity.service;

import com.example.mongouniversity.model.Faculty;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FacultyService {
    Faculty createFaculty(Faculty faculty);

    Faculty getFaculty(ObjectId id);

    void deleteFaculty(ObjectId id);

    void deleteAllFaculties();

    void saveAllFaculties(List<Faculty> faculties);

    Page<Faculty> getFaculties(Pageable pageable);

    List<Faculty> getAllFaculties();
}