package com.example.mongouniversity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
public class Student extends BaseEntity {
    private String name;
    private String patron;
    private String surname;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getObjectId() +
                "name='" + name + '\'' +
                ", patron='" + patron + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
