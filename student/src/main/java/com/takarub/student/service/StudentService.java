package com.takarub.student.service;


import com.takarub.student.adapter.repo.StudentRepository;
import com.takarub.student.adapter.repo.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public void save(Student student){
        repository.save(student);

    }

    public List<Student> findAll(){
        return repository.findAll();
    }

    public List<Student> findAllBySchool(Integer schoolId) {

        return repository.findAllBySchoolId(schoolId);
    }
}
