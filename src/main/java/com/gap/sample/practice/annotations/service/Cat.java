package com.gap.sample.practice.annotations.service;


import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class Cat implements Animal{
    @Override
    public String characterstics() {
        return "This is Cat meow....";
    }


    public static void main(String[] args) {
        //Strings.padStart()

        String ss = Strings.padStart("1234567895", 9, '0');
        System.out.println(ss);

        System.out.println(!StringUtils.isEmpty(null));
    }
}
