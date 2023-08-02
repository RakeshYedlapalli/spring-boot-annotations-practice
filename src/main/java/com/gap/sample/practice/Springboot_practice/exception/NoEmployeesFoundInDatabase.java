package com.gap.sample.practice.Springboot_practice.exception;


public class NoEmployeesFoundInDatabase extends RuntimeException {
    public NoEmployeesFoundInDatabase(String s) {
        super(s);
    }
}
