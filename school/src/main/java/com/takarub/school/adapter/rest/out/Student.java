package com.takarub.school.adapter.rest.out;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private String firstName;
    private String lastName;
    private String email;
}
