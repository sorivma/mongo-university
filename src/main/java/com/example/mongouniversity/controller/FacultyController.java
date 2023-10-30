package com.example.mongouniversity.controller;

import com.example.mongouniversity.model.Faculty;
import com.example.mongouniversity.service.FacultyService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faculties")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/all")
    Iterable<Faculty> getAll() {
        return facultyService.getAllFaculties();
    }

    @GetMapping
    Page<Faculty> getAllPageable(Pageable pageable) {
        return facultyService.getFaculties(pageable);
    }

    @PostMapping
    Faculty save(Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }
}
