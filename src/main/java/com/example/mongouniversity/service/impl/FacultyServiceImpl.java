package com.example.mongouniversity.service.impl;

import com.example.mongouniversity.exception.ClientErrorException;
import com.example.mongouniversity.model.Faculty;
import com.example.mongouniversity.model.Group;
import com.example.mongouniversity.repo.FacultyRepository;
import com.example.mongouniversity.repo.GroupRepository;
import com.example.mongouniversity.service.FacultyService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {
    private FacultyRepository facultyRepository;
    private GroupRepository groupRepository;
    @Autowired
    public void setFacultyRepository(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Autowired
    public void setGroupRepository(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty getFaculty(ObjectId id) {
        return facultyRepository.findById(id).orElseThrow(
                ()->new ClientErrorException
                        .NotFoundException("Faculty with given id: [%s] not found", id)
        );
    }

    @Override
    public void deleteFaculty(ObjectId id) {

        facultyRepository.deleteById(id);

        List<Group> groups = groupRepository.findByFacultyId(id);
        groups.forEach(group -> {
            System.out.println(group);
            groupRepository.deleteById(group.getObjectId());
        });
    }

    @Override
    public void deleteAllFaculties() {
        facultyRepository.deleteAll();
        groupRepository.deleteAll();
    }

    @Override
    public void saveAllFaculties(List<Faculty> faculties) {
        facultyRepository.saveAll(faculties);
    }

    @Override
    public Page<Faculty> getFaculties(Pageable pageable) {
        return facultyRepository.findAll(pageable);
    }

    @Override
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }
}
