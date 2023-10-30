package com.example.mongouniversity.init.factory.impl;

import com.example.mongouniversity.init.factory.EntityFactory;
import com.example.mongouniversity.model.Faculty;
import com.example.mongouniversity.model.Group;
import com.example.mongouniversity.model.Student;
import com.example.mongouniversity.service.FacultyService;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class GroupFactory implements EntityFactory<Group> {
    private final Faker faker;
    private final FacultyService facultyService;
    List<Faculty> faculties;

    public GroupFactory(Faker faker, FacultyService facultyService) {
        this.faker = faker;
        this.facultyService = facultyService;
    }

    private final String[] names = {"УВП", "УВВ", "УИБ", "УИС", "УМЛ", "УТИ"};

    private String name() {
        return names[(int) (Math.random() * names.length)];
    }

    private String number() {
        int firstDigit = faker.number().numberBetween(1, 5);
        int lastDigit = faker.number().numberBetween(1, 5);
        return String.format("%d1%d", firstDigit, lastDigit);
    }

    private List<Student> students() {
        int quantity = faker.number().numberBetween(9, 30);
        return IntStream.range(0, quantity)
                .mapToObj(i -> new Student(faker.name().firstName(),
                        faker.name().lastName(),
                        faker.name().lastName()))
                .collect(Collectors.toList());
    }

    private String facultyId() {
        if (faculties == null) {
            this.faculties = facultyService.getAllFaculties();
        }

        return faculties.get((int) (Math.random() * faculties.size())).getId();
    }


    @Override
    public Group createEntity() {
        return Group.builder()
                .number(number())
                .name(name())
                .students(students())
                .facultyId(facultyId())
                .build();
    }

    @Override
    public List<Group> createEntities(int number) {
        return IntStream.range(0, number).mapToObj(i -> createEntity()).collect(Collectors.toList());
    }
}
