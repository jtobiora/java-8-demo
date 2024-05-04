package com.swiftfingers.lambda6;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Java8Lessons {
	public static void main(String[] args) throws ParseException{
		Java8Lessons lessons = new Java8Lessons();
		lessons.processApp();
		
		getMaxDate();
		
		doWork();
	}
	
	public static void getMaxDate() {
		System.out.println("Get max date =====>>>>>>>>>>>>>>>>>>");
	    try {
	    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    	Date one = format.parse("2019-10-12");
	    	List<Person> personList = Arrays.asList( 
	    			new Person(12,"John","Male",format.parse("2019-01-20")),
	    					new	Person(23,"Thomas","Male",format.parse("2019-02-20")),
	    							new	Person(15,"Mike","Male",format.parse("2019-05-23")),
	    							new	Person(19,"Agnes","Male",format.parse("2019-04-11")));
	    	
	    Optional<Person> person = personList.stream().max(Comparator.comparing(Person::getDateCreated));
	    	   
	    System.out.println(person);
	    }catch(ParseException e) {
	    	e.printStackTrace();
	    }
	}
	
	public static Date addDays(Date date, int days) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.add(Calendar.DATE, days); // minus number would decrement the days
	    return cal.getTime();
	}
	
	public void processApp() {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
		List<String> chars = Arrays.asList("adhf","abed","poc","dlsd","asle","psdf");
		
		list.forEach(System.out::print);
		
		System.out.println();
		
		System.out.print(
		   chars.stream()
		       .filter(f -> f.startsWith("a"))
		       .collect(Collectors.joining(","))
		);
		
		
		System.out.println();
		
		//Filter out all the even numbers. Multiply them by 2 and sum them 
		System.out.println(
		   list.stream()
		   .filter(e -> e % 2 == 0)
		   .map(e -> e *  2)
		   .reduce(0, Integer::sum)
		);
		
		System.out.println(
				   list.stream()
				   .filter(e -> e % 2 == 0)
				   .mapToInt(e -> e *  2)
				   .sum()
				);
		
		List<Double> doubleEvenList  =
			     list.stream()
			         .filter(e -> e % 2 == 0)
			         .map(x -> x * 2.0)
			         .collect(toList());
		
		System.out.println(doubleEvenList);
		
		
		
		//Double the first number that is even and greater than 3 from the list above
		System.out.println(
				list.stream()
				    .filter(x -> x % 2 == 0)
				    .filter(x -> x > 3)
				    .map(e -> e * 2)
				    .findFirst()
				);
		
		//print even numbers from 1 to 100 inclusive	
				 IntStream.rangeClosed(1,100).filter(e -> e % 2 == 0).forEach(System.out::println);
				 

	    //print even numbers from 1 to 100 exclusive	
				 IntStream.range(1,100).filter(e -> e % 2 == 0).forEach(System.out::println);
		
//Given a number k and a count n, find the total of double n even numbers starting with k where 
		//square root of each number is greater than 20
		compute(2,5);
		
		
		//sortOperation();
	}
	
	public static void compute(int k, int n) {	
		Stream.iterate(k, e -> e + 1)
	      .filter(e -> e % 2 == 0)
	      .filter(e -> Math.sqrt(e) > 20)
          .mapToInt(e -> e * 2)
          .limit(n)
	      .sum();
	
	}
	
	
	public static void sortOperation() {
		List<String> list = Arrays.asList("ddd2", "aaa2","bbb1", "aaa1", "bbb3", "ccc", "bbb2", "add1");
		
		list.stream()
		    .filter(e -> e.startsWith("a"))
		    .map(String::toUpperCase)	    
		    .sorted((a,b) -> a.compareTo(b))
		    .forEach(System.out::println);
	}
	
	public static void doWork() throws ParseException {
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	    List<Person> employees = new ArrayList<>();
	    
	    employees.add(new Person(11, "name1", addDays(new Date(), 1)));
	    employees.add(new Person(22, "name2", addDays(new Date(), 3)));
	    employees.add(new Person(32, "name3", addDays(new Date(), 6)));
	    employees.add(new Person(52, "name5", addDays(new Date(), 4)));
	    employees.add(new Person(62, "name6", addDays(new Date(), 5)));
	    
	    System.out.println(employees);
	    
	    Date maxDate = employees.stream().filter(emp -> emp.getDateCreated() != null).map(Person::getDateCreated).max(Date::compareTo).get();
	    
	    System.out.println(format.format(maxDate));
	    
	    Comparator<Person> comparator = Comparator.comparing(Person::getDateCreated);
	    
	    Person maxDatedEmploye = employees.stream().filter(emp -> emp.getDateCreated() != null).max(comparator).get();
	    System.out.println(" maxDatedEmploye : " + maxDatedEmploye);

	    Person minDatedEmployee = employees.stream().filter(emp -> emp.getDateCreated() != null).min(comparator).get();
	    System.out.println(" minDatedEmployee : " + minDatedEmployee);

	}
	
}
