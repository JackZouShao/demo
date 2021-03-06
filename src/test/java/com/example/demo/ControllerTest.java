package com.example.demo;

import com.example.controller.DemoController;
import com.example.service.DemoService;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
@RunWith(JMockit.class)
public class ControllerTest {

    @Injectable
    DemoService demoService;

    @Tested
    DemoController demoController;

    @Test
    public void test(){
        new Expectations() {
            {
                // demoController.getString("1");
                demoService.getString();
                result = "2";
            }
        };

        String str = demoController.getString();
       // Assert.assertEquals("1", str);
    }

    @After
    public void testFinish(){
        System.out.println("测试完毕");
    }
}
