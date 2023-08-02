package com.gap.sample.practice.Springboot_practice.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@ToString
@Getter
@Setter
@Document(collection = "employee")
public class Employee {

    private final String firstName;
    private final String lastName;
    @Id
    private final String empId;
    private final boolean isMarried;


}
