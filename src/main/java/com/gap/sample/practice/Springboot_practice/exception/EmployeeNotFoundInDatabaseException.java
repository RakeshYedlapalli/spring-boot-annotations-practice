package com.gap.sample.practice.Springboot_practice.exception;

public class EmployeeNotFoundInDatabaseException extends RuntimeException{
    public EmployeeNotFoundInDatabaseException(String s) {
        super(s);
    }
}
