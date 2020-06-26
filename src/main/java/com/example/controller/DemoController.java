package com.example.controller;

import com.example.common.ApplicationEnum;
import com.example.exception.BusinessException;
import com.example.exception.ParamException;
import com.example.pojo.Person;
import com.example.service.DemoService;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;


@RestController
@RequestMapping("/xa")
@Validated
public class DemoController {

    @Resource
    DemoService demoService;

    @RequestMapping("/c")
    public String getString(Person person, @RequestHeader(name = "x-toke") String header){
        System.out.println(person);
        person.getGrands().forEach(str -> System.out.println(str));
        System.out.println(header);
        return "123";
    }
    @RequestMapping("/c1")
    public String getString1(@Length(max = 3, message = "23333") String str, Integer i){
        //throw new BusinessException(ApplicationEnum.NO_LOGIN);
        return "123";
    }
}
