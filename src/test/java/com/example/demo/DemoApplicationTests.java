package com.example.demo;

import com.example.test.TmlTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    TmlTest tmlTest;

    @Test
    void contextLoads() {
        System.out.println(tmlTest.getName());
    }

}
