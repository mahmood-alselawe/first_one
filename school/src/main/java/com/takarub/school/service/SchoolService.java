package com.takarub.school.service;

import com.takarub.school.adapter.repo.SchoolRepository;
import com.takarub.school.adapter.repo.entity.School;
import com.takarub.school.adapter.rest.out.FullSchoolResponse;
import com.takarub.school.adapter.rest.out.Student;
import com.takarub.school.adapter.rest.out.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository repository;

    private final StudentClient client;

    public void saveSchool(School school){
        repository.save(school);
    }

    public List<School> findAllSchool(){
        return repository.findAll();
    }

    public FullSchoolResponse findAllSchoolWithStudents(Integer schoolId) {

        var school = repository.findById(schoolId).orElse(
                School
                        .builder()
                        .name("Not_found")
                        .email("Not_found")
                        .build()

        );

        var students = client.findAllStudentBySchool(schoolId); // find all the students from students micro-service

        return FullSchoolResponse
                .builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
