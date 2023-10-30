package com.example.mongouniversity.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "group")
@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class Group {
    @Id
    private String id;
    private String name;
    private String number;
    private List<Student> students;
    private String facultyId;
}
