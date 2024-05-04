package com.swiftfingers.lambda6;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class ListToMapDemo {
  public static void main(String[] args) {
	  ZoneId zoneId = ZoneId.systemDefault();
	  List<User> users = Arrays.asList(
			  new User(1,"Benson",LocalDate.parse("2017-03-17").atStartOfDay(zoneId).toEpochSecond()),
			  new User(2,"Donald",LocalDate.parse("2017-03-18").atStartOfDay(zoneId).toEpochSecond()),
			  new User(3,"Tim",LocalDate.parse("2017-03-24").atStartOfDay(zoneId).toEpochSecond()),
			  new User(4,"Paul",LocalDate.parse("2017-04-02").atStartOfDay(zoneId).toEpochSecond()),
			  new User(5,"Chinedu",LocalDate.parse("2017-04-02").atStartOfDay(zoneId).toEpochSecond()),
			  new User(6,"Rose",LocalDate.parse("2017-04-10").atStartOfDay(zoneId).toEpochSecond())); 
    System.out.println(users);
    long start = 1489791600;
    long end = 1489791600;
    List<User> filtered = users.stream().filter(f -> f.getDobTimestamp() >= start && f.getDobTimestamp() <= end).collect(Collectors.toList());
    System.out.println(filtered);
    
	  
	  Map<Integer,User> map = createHashMap(users);
	  System.out.println(getUserNameWithKey(4, map));
	  
	  for(Integer key : map.keySet()) {
		  System.out.println("ID: " + key + " ---- " + map.get(key).getName());
	  }
  }
  
 
  
  public static Map<Integer, User> createHashMap(List<User> users){
	  Map<Integer, User> createdMap = users.stream().collect(Collectors.toMap(User::getId, Function.identity()));
	  return createdMap;
  }
  
  public static String getUserNameWithKey(Integer key,Map<Integer,User> userMap) {
	   return userMap.get(key).getName();
  }
}

class User {
	private Integer id;
	private String name;
	private long dobTimestamp;
	
	public User(Integer id, String name,long dob) {
		super();
		this.id = id;
		this.name = name;
		this.dobTimestamp = dob;
	}
	
	public long getDobTimestamp() {
		return dobTimestamp;
	}

	public void setDobTimestamp(long dobTimestamp) {
		this.dobTimestamp = dobTimestamp;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "timestamp: " + dobTimestamp;
	}
	
	
	
}
