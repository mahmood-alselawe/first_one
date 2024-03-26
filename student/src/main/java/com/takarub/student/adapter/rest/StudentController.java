package com.takarub.student.adapter.rest;


import com.takarub.student.adapter.repo.entity.Student;
import com.takarub.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveStudents(@RequestBody Student student){
        service.save(student);

    }
    @GetMapping
    public ResponseEntity<List<Student>> finaAll(){
        return ResponseEntity.ok( service.findAll());
    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> finaAll(@PathVariable("school-id") Integer schoolId){
        return ResponseEntity.ok( service.findAllBySchool(schoolId));
    }

}
