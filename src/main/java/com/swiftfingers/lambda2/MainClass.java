package com.swiftfingers.lambda2;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import static java.util.stream.Collectors.toList;

public class MainClass {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "New York");
        Trader brian = new Trader("Brian", "Cambridge");
        Trader david = new Trader("David", "Lagos");

        List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
                new Transaction(david, 2014, 450), new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));

        List<String> names = Arrays.asList("Mario", "Turan", "David", "Paul", "Andrew");

        List<Transaction> x = transactions.stream().filter(t -> names.contains(t.getTrader().getName())).distinct()
                .collect(toList());
        System.out.println(x);
        System.out.println("*************");

        // 1. Find all transactions in the year 2011 and sort them by value (small to
        // high).
        StreamOperations.findAllTransactionsInAParticularYearAndSortByValue(transactions, 2012);

        // 2. What are all the unique cities where the traders work?
        StreamOperations.getAllUniqueCities(transactions);

        // 3. Find all traders from Cambridge and sort them by name.
        StreamOperations.findAllTradersFromACityAndSortByName(transactions, "Cambridge");

        // 4. Return a string of all traders’ names sorted alphabetically
        StreamOperations.findAllTradersNamesSortedByAlphabets(transactions);

        // 5. Are any traders based in Milan?
        StreamOperations.checkIfTradersAreInACity(transactions, "milan");

        // 6. Print all transactions’ values from the traders living in Cambridge.
        StreamOperations.printAllTransactionValuesForTradersInACity(transactions, "Cambridge");

        // 7. What’s the highest value of all the transactions?
        StreamOperations.highestValueOfAllTransations(transactions);

        // 8. Find the transaction with the smallest value
        StreamOperations.lowestValueOfAllTransations(transactions);

        StreamOperations.getTheNumberOfCaloriesInAStream(transactions);

        // add a couple of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        BinaryOperator<Integer> ops = (a, b) -> a + b;

        StreamOperations.convertMapToList();

        StreamOperations.printResult();

    }

}
