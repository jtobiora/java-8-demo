package com.swiftfingers.lambda3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeePredicate {
    public static Predicate<Employee> isAdultMale() {
        return p -> p.getAge() > 21 && p.getGender().equalsIgnoreCase("M");
    }

    public static Predicate<Employee> isAdultFemale(){
        return e -> e.getAge() > 18 && e.getGender().equalsIgnoreCase("F");
    }

    public static Predicate<Employee> isAgeMoreThan(Integer age){
        return i -> i.getAge() > age;
    }

    public static Predicate<Employee> isIDMoreThan(Integer id){
        return p -> p.getId() > id;
    }

    public static <T> List<T> filterEmployees(List<T> employees, Predicate<T> pre){
        return employees.stream().filter(pre).collect(Collectors.<T>toList());
    }

    public static <T> List<T> filter(List<T> objList,Predicate<T> p) {
        List<T> list = new ArrayList<>();
        for(T t : objList) {
            if(p.test(t)) {
                list.add(t);
            }
        }
        return list;
    }
}
