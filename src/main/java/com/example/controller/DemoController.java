package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/qr")
public class DemoController {

    @Resource
    DemoService demoService;

    @RequestMapping("/c")
    public String getString(){
        System.out.println("cccccccc");
       return "home.html";
    }
	
	
	
	
}
