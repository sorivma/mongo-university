package com.example.mongouniversity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupSummary {
    @Field(name = "_id")
    private String name;
    private Integer numberOfStudents;
}
