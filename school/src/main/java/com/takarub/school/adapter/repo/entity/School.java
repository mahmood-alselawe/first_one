package com.takarub.school.adapter.repo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class School {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;

}
