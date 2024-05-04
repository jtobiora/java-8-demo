package com.swiftfingers.lambda4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int age;
    private String name;
    private List<String> programmingLanguages;
}