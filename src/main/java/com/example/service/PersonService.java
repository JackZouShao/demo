package com.example.service;


import com.example.pojo.Person;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PersonService {

    @Resource
    CoderService coderService;
    public String showName(String name){
        System.out.println("person show name : " + name);
        return name;
    }

    public int showAge(int age) {
        System.out.println("person show age : " + age);
        return age;
    }

    public int s (){
        return coderService.showSalary(100);
    }
}

