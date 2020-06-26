package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Length(min = 3, message = "最小值3")
    @JsonProperty(value = "name")
    private String name;

    @Min(value = 2, message = "密码违规")
    private Integer age;

    List<String> grands;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getGrands() {
        return grands;
    }

    public void setGrands(List<String> grands) {
        this.grands = grands;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grands=" + grands +
                '}';
    }
}
