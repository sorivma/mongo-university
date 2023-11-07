package com.example.mongouniversity.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "group")
@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class Group extends BaseEntity {
    private String name;
    private String number;
    private List<Student> students;
    private ObjectId facultyId;
}
