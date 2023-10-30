package com.example.mongouniversity.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "faculty")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Faculty {
    @Id
    private String id;
    private String code;
    private String name;
    @Field(name = "contact_phone")
    private String phone;
    private String email;
}
