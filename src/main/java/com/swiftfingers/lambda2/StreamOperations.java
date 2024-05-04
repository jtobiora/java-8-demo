package com.swiftfingers.lambda2;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class StreamOperations {

    public static void findAllTransactionsInAParticularYearAndSortByValue(List<Transaction> transactions, int year) {
        List<Transaction> tr = transactions.stream() // get a stream
                .filter(t -> t.getYear() == year) // filter by year
                .distinct() // find only the distinct one
                .sorted(comparing(Transaction::getValue)) // sort the transactions by values
                .collect(Collectors.toList()); // put it into a collection
        System.out.println(tr); // print
    }

    public static void getAllUniqueCities(List<Transaction> transactions) {
        List<String> uniqueCities = transactions.stream() // stream the data
                .map(e -> e.getTrader().getCity()) // map to city
                .distinct() // find unique values
                .collect(toList()); // collect to List

        System.out.println(uniqueCities);
    }

    public static void findAllTradersFromACityAndSortByName(List<Transaction> transactions, String city) {
        List<Trader> traders = transactions.stream() // get a stream
                .filter(e -> e.getTrader().getCity().equals(city)) // filter by name of city
                .map(t -> t.getTrader()) // map the transaction to return a trader
                .distinct() // get only distinct values
                .sorted(comparing(Trader::getName)) // sort by name
                .collect(Collectors.toList()); // return a list of traders

        System.out.println(traders);
    }

    public static void findAllTradersNamesSortedByAlphabets(List<Transaction> transactions) {
        List<String> names = transactions.stream() // stream the data
                .map(tr -> tr.getTrader().getName()) // get the traders name
                .distinct() // find a distinct value
                .sorted() // sort
                .collect(toList()); // gather into a list

        System.out.println(names);
    }

    public static void checkIfTradersAreInACity(List<Transaction> transactions, String city) {
        boolean check = transactions.stream() // stream data
                .anyMatch(p -> p.getTrader().getCity().equalsIgnoreCase(city)); // check if any match
        System.out.println(check);
    }

    public static void printAllTransactionValuesForTradersInACity(List<Transaction> transactions, String city) {
        List<Integer> trans = transactions.stream().filter(e -> e.getTrader().getCity().equals(city))
                .map(Transaction::getValue).collect(Collectors.toList());

        System.out.println(trans);
    }

    public static void highestValueOfAllTransations(List<Transaction> transactions) {
        Integer max = transactions.stream().map(Transaction::getValue).reduce(0, Integer::max);
        /*
		 * or transactions.stream().max(comparing(Transaction::getValue()))
		 *
		 */

        System.out.println("maximum of all values " + max);
    }

    public static void lowestValueOfAllTransations(List<Transaction> transactions) {

        Optional<Integer> min = transactions.stream().map(Transaction::getValue).reduce((a, b) -> a < b ? a : b);

		/*
		 * or transactions.stream().min(comparing(Transaction::getValue()))
		 *
		 */

        System.out.println("Minimum of all values " + min.get());
    }

    public static void getTheNumberOfCaloriesInAStream(List<Transaction> transactions) {
        int allCalories = transactions.stream() // get a stream
                .mapToInt(Transaction::getValue).sum();

        System.out.println("Sum of all calories: " + allCalories);
    }

    public static void convertMapToList() {
        Map<Integer, Trader> map = new HashMap<>();
        map.put(1, new Trader("Obiora", "Jos"));
        map.put(2, new Trader("Samuel", "Niger"));
        map.put(3, new Trader("Johnson", "Lagos"));
        map.put(4, new Trader("Rita", "Lagos"));
        map.put(5, new Trader("Paul", "Lagos"));
        map.put(6, new Trader("Dan", "Jos"));

        List<String> cities = map.values().stream().map(Trader::getCity).distinct().collect(toList());

        List<String> anotherList = Arrays.asList("Kaduna", "Makurdi", "Awka");
        List<String> allcities = new ArrayList<>();

        allcities.addAll(anotherList);
        allcities.addAll(cities);
        for (String city : allcities) {
            System.out.println(city + " ");
        }
    }

    public static void printResult() {
        List<String> names = Arrays.asList("Kaduna", "Makurdi", "Awka", "awka");

        names = names.stream().map(s -> s.substring(0, 1).toUpperCase().concat(s.substring(1))).distinct()
                .collect(toList());
        names.forEach(name -> {
            System.out.println(name);
        });
    }

}
