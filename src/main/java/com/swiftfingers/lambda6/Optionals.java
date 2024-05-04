package com.swiftfingers.lambda6;

import java.util.Optional;

public class Optionals {
public static void main(String[] args) {
	System.out.println(getSquareRoot(-36.0));
	
	System.out.println(getinverse(13d));
	
}
public static Optional<Double> getSquareRoot(Double number){
	return number > 0d  ? Optional.of(Math.sqrt(number)) : Optional.empty();
}

public static Optional<Double> getinverse(Double number){
	if(number == null) return Optional.empty();
	
	return (number != 0d) ? Optional.of(1d/number) : Optional.empty();
}
}
