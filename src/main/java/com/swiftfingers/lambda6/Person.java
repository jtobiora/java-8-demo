package com.swiftfingers.lambda6;

import java.util.Date;

public class Person {
  private int age;
  private String name;
  private String gender;
  private Date dateCreated;
  
public Person(int age, String name) {
	super();
	this.age = age;
	this.name = name;
}


public Person(int age, String name, String gender) {
	super();
	this.age = age;
	this.name = name;
	this.gender = gender;
}

public Person(int age, String name, Date d) {
	super();
	this.age = age;
	this.name = name;
	this.dateCreated = d;
}

public Person(int age, String name, String gender,Date dc) {
	super();
	this.age = age;
	this.name = name;
	this.gender = gender;
	this.dateCreated = dc;
}



public String getGender() {
	return gender;
}


public void setGender(String gender) {
	this.gender = gender;
}


public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}


public Date getDateCreated() {
	return dateCreated;
}


public void setDateCreated(Date dateCreated) {
	this.dateCreated = dateCreated;
}


@Override
public String toString() {
	return "name= " + name;
}

  
  
}
