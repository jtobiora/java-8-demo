package com.swiftfingers.lambda6;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorNullFistLast {

	public static void main(String[] args) {

		Comparator<Employee> comp = Comparator.comparing(Employee::getLastName).thenComparing(Employee::getFirstName);

		// jdk8 way: comparison using last name
		// Some employeeList collection elements hold last name as null value
		Comparator<Employee> empComparatorByLastNameNullFirst = Comparator.comparing(Employee::getLastName,
				Comparator.nullsFirst(String::compareTo));

		List<Employee> employeeList = getEmployeeList();

		Collections.sort(employeeList, empComparatorByLastNameNullFirst);
		System.out.println("Employee list after sorting by last name null first");
		employeeList.forEach(System.out::println);

		Comparator<Employee> empComparatorByLastNameNullLast = Comparator.comparing(Employee::getLastName,
				Comparator.nullsLast(String::compareTo));
		Collections.sort(employeeList, empComparatorByLastNameNullLast);
		System.out.println("\nEmployee list after sorting by last name null last");
		employeeList.forEach(System.out::println);

	}

	static List<Employee> getEmployeeList() {
		List<Employee> employeeList = Arrays.asList(new Employee("Ramesh", null, 21), new Employee("John", "Cena", 27),
				new Employee("Divya", null, 24), new Employee("Donald", "Taylor", 24));
		return employeeList;

	}
}

class Employee {

	private String firstName;
	private String lastName;
	private Integer age;

	public Employee(String firstName, String lastName, Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String toString() {
		return "[" + firstName + " : " + lastName + " : " + age + "]";
	}

};
