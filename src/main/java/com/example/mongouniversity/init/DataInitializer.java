package com.example.mongouniversity.init;

import com.example.mongouniversity.model.Faculty;
import com.example.mongouniversity.model.Group;
import com.example.mongouniversity.init.factory.impl.FacultyFactory;
import com.example.mongouniversity.init.factory.impl.GroupFactory;
import com.example.mongouniversity.repo.FacultyRepository;
import com.example.mongouniversity.repo.GroupRepository;
import com.example.mongouniversity.service.FacultyService;
import com.example.mongouniversity.service.GroupService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    private  GroupService groupService;
    private  FacultyService facultyService;
    private final FacultyFactory facultyFactory;
    private final GroupFactory groupFactory;

    public DataInitializer(FacultyFactory facultyFactory, GroupFactory groupFactory) {
        this.facultyFactory = facultyFactory;
        this.groupFactory = groupFactory;
    }

    @Autowired
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    @Autowired
    public void setFacultyService(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @Override
    public void run(String... args) throws Exception {
        facultyService.deleteAllFaculties();
        groupService.deleteAllGroups();

        List<Faculty> faculties = facultyFactory.createEntities(50);
        faculties.forEach(System.out::println);
        facultyService.saveAllFaculties(faculties);

        List<Group> groups = groupFactory.createEntities(10_000);
        groupService.saveAllGroups(groups);
    }
}
