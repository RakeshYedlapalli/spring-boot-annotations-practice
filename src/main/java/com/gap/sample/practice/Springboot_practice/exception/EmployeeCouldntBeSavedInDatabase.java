package com.gap.sample.practice.Springboot_practice.exception;

public class EmployeeCouldntBeSavedInDatabase extends RuntimeException {
    public EmployeeCouldntBeSavedInDatabase(String s) {
        super(s);
    }
}
