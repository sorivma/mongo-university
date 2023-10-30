package com.example.mongouniversity.init.factory.impl;

import com.example.mongouniversity.init.factory.EntityFactory;
import com.example.mongouniversity.model.Faculty;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class FacultyFactory implements EntityFactory<Faculty> {
    private final Faker faker;

    public FacultyFactory(Faker faker) {
        this.faker = faker;
    }

    private final String[] codes = {"ЦТУТП", "ВССиБ", "ВМ", "ИЯ", "ФКиС", "АВТ", "ВППиПО", "СЭУ", "ИМТК", "МБ",
            "МОиГТ", "МТМиУЦП", "ЭНиТ УРиТС", "МК", "М", "МиТ", "ПВТ", "ПСЖД"};

    private final String[] names = {"Цифровые технологии управления транспортными процессами",
    "Вычислительный системы, сети и информационная безопасность", "Высшая математкика", "Философия", "Академия водного" +
            "транспорта", "Мосты и туннели"};

    private String code() {
        return codes[(int) (Math.random() * codes.length)];
    }

    private String name() {
        return names[(int) (Math.random() * names.length)];
    }

    private String phone() {
        return faker.phoneNumber().phoneNumber();
    }

    private String email() {
        return faker.internet().emailAddress();
    }

    @Override
    public Faculty createEntity() {
        return Faculty.builder()
                .code(code())
                .name(name())
                .phone(phone())
                .email(email())
                .build();
    }

    @Override
    public List<Faculty> createEntities(int number) {
        return IntStream.range(0, number)
                .mapToObj(i -> createEntity())
                .collect(Collectors.toList());
    }
}
