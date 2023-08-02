package com.gap.sample.practice.annotations.controller;

import com.gap.sample.practice.annotations.service.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkAnnotations")
public class AnnotationsTestingController {

    @Autowired
    Animal animal;


    @GetMapping
    public String getAnimal(){
        return animal.characterstics();
    }

}

