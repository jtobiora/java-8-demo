package com.swiftfingers.lambda6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Stream;

public class StringJoinerDemo {
  public static void main(String[] args) throws IOException {
	  Stream<String> stream1 = Files.lines(Paths.get("C:\\Load_Panel\\Door\\Projects\\In Eclipse\\Java8Demo\\src\\files\\people.txt"));
	  Stream<String> stream2 = Files.lines(Paths.get("C:\\Load_Panel\\Door\\Projects\\In Eclipse\\Java8Demo\\src\\files\\houses.txt"));
	  
	  //using FlatMap
	  Stream<Stream<String>> streamOfstreams = Stream.of(stream1, stream2);
	  Stream<String> flatStream = streamOfstreams.flatMap(Function.identity());
	  System.out.println(flatStream.count());
	 
	  
	  List<String> list = Arrays.asList("first","second","third");
	  
	  StringJoiner joiner = new StringJoiner(", ","{","}");
	  
	  list.stream().forEach(st -> {
		  joiner.add(st);
	  });
	  
	   //use commas and a prefix and suffix to delimit
	  String fullString = joiner.toString();
	  System.out.println(fullString);
	  
	  //use commas to delimit
	  String concat = String.join(",", list);
	  System.out.println(concat);
  }
}
