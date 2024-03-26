package com.takarub.school.adapter.rest;


import com.takarub.school.adapter.repo.entity.School;
import com.takarub.school.adapter.rest.out.FullSchoolResponse;
import com.takarub.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService service;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void save(School school){
        service.saveSchool(school);

    }

    @GetMapping
    public ResponseEntity<List<School>> findAllSchool(){
        return  ResponseEntity.ok(service.findAllSchool());
    }

    @GetMapping("with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> findAllSchool(@PathVariable("school-id") Integer schoolId ){

        return  ResponseEntity.ok(service.findAllSchoolWithStudents(schoolId));
    }
}
