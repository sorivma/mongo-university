package com.example.mongouniversity.service;

import com.example.mongouniversity.model.Faculty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FacultyService {
    Faculty createFaculty(Faculty faculty);

    Faculty getFaculty(String id);

    void deleteFaculty(String id);

    void deleteAllFaculties();

    void saveAllFaculties(List<Faculty> faculties);

    Page<Faculty> getFaculties(Pageable pageable);

    List<Faculty> getAllFaculties();
}