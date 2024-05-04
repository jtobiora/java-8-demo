package com.swiftfingers.lambda3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MainApp {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, 23, "M", "Rick", "Beethovan");
        Employee e2 = new Employee(2, 13, "F", "Martina", "Hengis");
        Employee e3 = new Employee(3, 43, "M", "Ricky", "Martin");
        Employee e4 = new Employee(4, 26, "M", "Jon", "Lowman");
        Employee e5 = new Employee(5, 19, "F", "Cristine", "Maria");
        Employee e6 = new Employee(6, 15, "M", "David", "Feezor");
        Employee e7 = new Employee(7, 68, "F", "Melissa", "Roy");
        Employee e8 = new Employee(8, 79, "M", "Alex", "Gussin");
        Employee e9 = new Employee(9, 15, "F", "Neetu", "Singh");
        Employee e10 = new Employee(10, 45, "M", "Naveen", "Jain");

        List<Employee> employees = new ArrayList<Employee>();

        employees.addAll(Arrays.asList(new Employee[] { e1, e2, e3, e4, e5, e6, e7, e8, e9, e10 }));

        System.out.println(EmployeePredicate.filterEmployees(employees, EmployeePredicate.isAdultMale()));

        System.out.println(EmployeePredicate.filterEmployees(employees, EmployeePredicate.isAdultFemale()));

        System.out.println(EmployeePredicate.filterEmployees(employees, EmployeePredicate.isAgeMoreThan(35)));

        // Employees other than above collection of "isAgeMoreThan(35)" can be gotten
        // using negate()
        System.out.println(EmployeePredicate.filterEmployees(employees, EmployeePredicate.isAgeMoreThan(35).negate()));

        Predicate<Employee> adultMalesAndFemales = EmployeePredicate.isAdultFemale()
                .and(EmployeePredicate.isAdultMale());

        System.out.println(EmployeePredicate.filterEmployees(employees, adultMalesAndFemales));

        Predicate<Employee> isMaleOrIdGreaterThanFour = EmployeePredicate.isAdultMale()
                .or(EmployeePredicate.isIDMoreThan(4));
        //
        System.out.println(EmployeePredicate.filterEmployees(employees, isMaleOrIdGreaterThanFour));


        System.out.println(EmployeePredicate.filter(employees, e -> e.getAge() < 25) );

        System.out.println(EmployeePredicate.filter(
                Arrays.asList(new String[] {"Anambra","Lagos","Ogun","Osun","Ondo"}), s -> s.startsWith("O")));

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(5, 6, 7, 8);

        List<List<Integer>> listCombined = Arrays.asList(list1, list2);
        listCombined.stream().flatMap(l -> l.stream()).forEach(System.out::println);


    }
}