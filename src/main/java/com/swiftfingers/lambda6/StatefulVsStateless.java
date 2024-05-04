package com.swiftfingers.lambda6;

import java.util.Arrays;
import java.util.List;

public class StatefulVsStateless {
  public static void main(String[] args) {
	  List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,12,2,3,34,56,34,54,23,54,6,5754,76,43,56,76,54,56,89,86,54,56,78,98,76,43,21);
     
	  //stateful streams because the List is ordered - reduces performance
	  list.stream().filter(f -> f > 2).forEach(System.out::println);
	  
	  //still stateful streams because the List is ordered - reduces performance
	  list.stream().parallel().filter(f -> f > 2).forEach(System.out::println);
	  
	  //stateless stream because the stream has been unordered - increases performance
	  list.stream().parallel().unordered().filter(f -> f > 2).forEach(System.out::println);
  
  }
}
