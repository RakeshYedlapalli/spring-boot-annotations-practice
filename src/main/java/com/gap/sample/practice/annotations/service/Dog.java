package com.gap.sample.practice.annotations.service;

import org.springframework.stereotype.Service;

@Service
public class Dog implements Animal{
    @Override
    public String characterstics() {
        return "This is Dog barking....";
    }
}
