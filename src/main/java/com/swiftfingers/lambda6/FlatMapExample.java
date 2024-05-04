package com.swiftfingers.lambda6;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class FlatMapExample {

	public static void main(String[] args) {
		
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		
		List<int[]> pairs =
				numbers1.stream()
				.flatMap(i -> numbers2.stream()
				.map(j -> new int[]{i, j})
				)
				.collect(Collectors.toList());
		
		for(int[] i : pairs) {
			int x = i[0];
			int y = i[1];
			System.out.print("[" + x +  "," + y + "]");
		}

		System.out.println();
		
		List<Student> studentList = new ArrayList<Student>();
		
//		You use Files.lines to return a stream where each element is a line in the given file. You then
//				split each line into words by calling the split method on line. Notice how you use flatMap to
//				produce one flattened stream of words instead of multiple streams of words for each line. Finally,
//				you count each distinct word in the stream by chaining the methods distinct and count.
		
		 long lengthOfUniqueWords = 0;
		  try( Stream<String> lines = 
				  Files.lines(Paths.get("C:\\Users\\Toshiba\\Documents\\EclipseProjects\\Java8Demo\\src\\text.txt"),
						  Charset.defaultCharset())){  
			  lengthOfUniqueWords = lines
					              .flatMap(l -> Arrays.stream(l.split(""))) 
					              .distinct()
					              .count();
			  System.out.println(lengthOfUniqueWords);
		  }catch(Exception ex) {
			  ex.printStackTrace();
		  }
		
		  studentList.add(new Student("Robert","5st grade", Arrays.asList(new String[]{"history","maths","geography"})));
		  studentList.add(new Student("Martin","8st grade", Arrays.asList(new String[]{"economics","biology"})));
		  studentList.add(new Student("Robert","9st grade", Arrays.asList(new String[]{"science","maths"})));

		         //First way of using Flatmap to do the above
		  Set<String> courses = studentList
				  .stream()
				  .flatMap( e -> e.getCourse().stream())
				  .collect(Collectors.toSet());
		  System.out.println(courses);


		         //Another way of doing the above
		  Stream<List<String>> listStream = studentList.stream().map(s -> s.getCourse());

		  Stream<String> stringStream = listStream.flatMap(b -> b.stream());

		  List<String> stringList = stringStream.distinct().collect(Collectors.toList());


		//Another way of doing the above
		 List<String> list = studentList.stream()
				                .map(s -> s.getCourse())  //Stream<List<String>>
				                .flatMap(f -> f.stream())  //Stream<String>
				                .collect(Collectors.toList());  //List<String>
		 
		Stream<List<String>> strStream = Stream.of(Arrays.asList("a", "b","c"), Arrays.asList("c", "d"));
		
		strStream.flatMap(str -> str.stream())
		         .map(String::toUpperCase)
		         .distinct()
		         .forEach(System.out::println);

	}
}


class Student {
	 
	  private String name;
	  private String grade;
	  private List<String> course; 
	 
	  public Student(String name, String grade, List<String> course) {
	    super();
	    this.name = name;
	    this.grade = grade;
	    this.course = course;
	  }
	  public String getName() {
	    return name;
	  }
	  public void setName(String name) {
	    this.name = name;
	  }
	  public String getGrade() {
	    return grade;
	  }
	  public void setGrade(String grade) {
	    this.grade = grade;
	  }
	  public List<String> getCourse() {
	    return course;
	  }
	  public void setCourse(List<String> course) {
	    this.course = course;
	  }
	}
