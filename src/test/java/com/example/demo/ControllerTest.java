package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.pojo.Hunman;
import com.example.pojo.Person;
import mockit.integration.junit4.JMockit;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RunWith(JMockit.class)
public class ControllerTest {

    @Test
    public void test(){
        LocalDate date = LocalDate.of(2020, 9, 1);
//        System.out.println(date.getYear());
//        System.out.println(date.getDayOfMonth());
//        System.out.println(date.getDayOfWeek());
//        System.out.println(date.getDayOfYear());
//        System.out.println(date.get(ChronoField.YEAR));
//        date.get(ChronoField.DAY_OF_MONTH);
//        LocalDate today = LocalDate.now();
//        System.out.println(today);

        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalDate date1 = LocalDate.now();
        System.out.println(date1);
        System.out.println(date);
    }

    @Test
    public void DateTest(){
        // Instant
        Instant instant = Instant.EPOCH;// unix 元年
        instant = Instant.ofEpochSecond(3);// unix 元年后的三秒
        System.out.println(instant);

        // Duration
        Duration d1 = Duration.between(LocalTime.now(), LocalTime.now());
      //  Duration d2 = Duration.between(LocalDate.of(2019, 1, 1), LocalDate.now());
        System.out.println(d1);
        DateTimeFormatter.ofPattern("");
        Period tenDays = Period.between(LocalDate.of(2019, 3, 8), LocalDate.of(2019, 05, 1));
        System.out.println(tenDays.getMonths());
        System.out.println(tenDays.getDays());
    }

    @Test
    public void testTime() throws ParseException {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+'");
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'测试'HH:mm:ss.SSSZ");
        String str = df.format(date);
        String str1 = df1.format(date);
        df.parse("");
        System.out.println(str);
        System.out.println(str1);
    }

    @Test
    public void testJson(){
        Person person = Person.builder().age(12).name("who我").build();
        String json = JSON.toJSONString(person);
        System.out.println(json);
        Hunman hunman =  Hunman.builder().height(15.0).build();
        testFinish(json,hunman);
        System.out.println(hunman);
        System.out.println(person);
    }



    public Hunman testFinish(String str, Hunman h){
        Person person = JSON.parseObject(str, Person.class);
        h .setAge(person.getAge());
        h.setName(person.getName());
        person = null;
        return h;

    }
}
