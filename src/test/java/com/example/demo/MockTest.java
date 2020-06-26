package com.example.demo;

import com.example.pojo.Person;
import com.example.service.CoderService;
import com.example.service.PersonService;
import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
public class MockTest {

    //@Mocked 修饰，所有实例都会被mock
    @Mocked
    private PersonService personService;

    // @Injectable 修饰，只mock指定的实例。
    @Injectable
    private CoderService coderService;

    @Test
    public void testInstance() {
        new Expectations() {
            {


                coderService.showSalary(100);
                result = 9;
                personService.s();
                result = 1;


            }
        };
            coderService.showSalary(100);
            Assert.assertEquals(1, personService.s());
        //record的方法，按照给定的结果返回
//        Assert.assertTrue(-1 == personService.showAge(11));
//        Assert.assertTrue("java".equals(coderService.showWork("nothing")));
//        Assert.assertTrue(4 == personService.getDefaultPerson().getAge());
//        //没有录制的方法，返回默认值
//        Assert.assertTrue(personService.showName("testName") == null);
//        Assert.assertTrue(coderService.showSalary(100) == 0);

//        //Mock 所有PersonServiceImpl实例
//        PersonService pservice = new PersonService();
//        Assert.assertTrue(-1 == pservice.showAge(11));
//        Assert.assertTrue(pservice.showName("testName") == null);
//
//        //新生成的CoderService实例没有被mock
//        CoderService cservice = new CoderService();
//        Assert.assertTrue("something".equals(cservice.showWork("something")));
//        Assert.assertTrue(cservice.showSalary(100) == 100);
    }
}