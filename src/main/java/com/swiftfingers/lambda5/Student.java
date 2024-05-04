package com.swiftfingers.lambda5;

import java.time.LocalDate;

public class Student {
    private String name;
    private LocalDate dateOfbirth;

    public Student(String name, LocalDate dateOfbirth) {
        super();
        this.name = name;
        this.dateOfbirth = dateOfbirth;
    }

    public LocalDate getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(LocalDate dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name= " + name;
    }

}
