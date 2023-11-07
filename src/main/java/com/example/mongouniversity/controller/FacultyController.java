package com.example.mongouniversity.controller;

import com.example.mongouniversity.model.Faculty;
import com.example.mongouniversity.service.FacultyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    Faculty getById(@PathVariable String id) {
        return facultyService.getFaculty(id);
    }

    @GetMapping
    Page<Faculty> getAllPageable(Pageable pageable) {
        return facultyService.getFaculties(pageable);
    }

    @PostMapping
    Faculty save(Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable String id) {
        facultyService.deleteFaculty(id);
    }
}
