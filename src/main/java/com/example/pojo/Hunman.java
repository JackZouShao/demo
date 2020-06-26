package com.example.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Hunman {
    private int age;
    private String name;
    private double height;
}
