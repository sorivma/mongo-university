package com.example.mongouniversity;

import com.example.mongouniversity.repo.FacultyRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = {FacultyRepository.class})
@EnableAspectJAutoProxy
public class MongoUniversityApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoUniversityApplication.class, args);
    }

}
