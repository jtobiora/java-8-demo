package com.swiftfingers.lambda6;

import java.util.Arrays;
import java.util.List;
import static java.util.Comparator.comparing;

import java.util.ArrayList;
public class MethodReferences {
	
 public static void main(String[] args) {
	 List<Apple> listOfApples = Arrays.asList(
			 new Apple(12,"Nigeria",240.0),
			 new Apple(13,"South Africa",500.0),
			 new Apple(12,"South Africa",500.0)
			 );
	 compare(listOfApples);
	 

 }
 
 public static void compare(List<Apple> apples) {
	 
	  apples.sort(comparing(Apple::getWeight)
			.reversed()
			.thenComparing(Apple::getCountry));
	
	 System.out.println(apples);
 }

}



class Apple{
	private int weight;
	private String country;
	private double cost;
	
	
	public Apple(int weight, String country, double cost) {
		super();
		this.weight = weight;
		this.country = country;
		this.cost = cost;
	}
	
	public Apple() {
		
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Apple [weight=" + weight + ", country=" + country + ", cost=" + cost + "]";
	}
	
	
}
