package com.swiftfingers.lamda1;

import com.swiftfingers.lambda3.Employee;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toList;

public class DishOperation {

    public enum CaloricLevel {
        DIET, NORMAL, FAT
    }


    public static void isVegitarianDish(List<Dish> menu) {
        List<Dish> vegDish = menu.stream() //
                .filter(Dish::isVegetarian) //
                .collect(toList()); //

        List<Dish> vegDish2 = menu.stream().filter(Dish::isVegetarian).collect(toCollection(ArrayList::new));
        System.out.println("VEGETARIAN DISHES ---- " + vegDish2);
    }

    public static void getFirstNDishesWithCaloriesGreaterThanAValue(List<Dish> menu, Integer num) {
        System.out.println("FIRST " + num + " DISHES WITH CALORIES GREATER THAN 300 ---- " + menu.stream() //
                .filter(d -> d.getCalories() > 300) //
                .limit(num) //
                .collect(toList()));
    }

    public static void skipFirstNDishesWithCaloriesGreaterThan(List<Dish> menu, Integer num) {
        System.out.println("SKIP " + num + " DISHES WITH CALORIES GREATER THAN 300 ---- " + menu.stream() //
                .filter(d -> d.getCalories() > 300) //
                .skip(num) //
                .collect(toList()));
    }

    public static void findTheFirstNMeatDishes(List<Dish> menu, int n) {
        System.out.println(menu.stream() //
                .filter(e -> e.getType() == Dish.Type.MEAT) //
                .limit(n) //
                .collect(toList()));
    }

    public static void printDishesByTheCountOfTheirNames(List<Dish> menu) {

        Map<String, Integer> nameCount = menu.stream().collect( //
                Collectors.toMap(Dish::getName, s -> s.getName().replace(" ", "").length()));
        System.out.println("NAMES COUNT ---- " + nameCount);

//        Map<String, Integer> nameCount = menu.stream()
//                .filter(Objects::nonNull)
//                .filter(dish -> dish.getName() != null)
//                .collect(Collectors.toMap(
//                        Dish::getName,
//                        dish -> dish.getName().replace(" ", "").length(),
//                        (oldValue, newValue) -> oldValue
//                ));
        System.out.println("NAMES COUNT: " + nameCount);
    }

    public static void printDishesByTheirNames(List<Dish> menu) {
        menu.stream().map(Dish::getName).forEach(System.out::println);
    }

    // you can also use noneMatch,anyMatch, allMatch - they all return a boolean
    // type
    public static void checkIfMenuHasAParticularOptionType(List<Dish> menu, Dish.Type type) {
        System.out.println(menu.stream().anyMatch(dish -> dish.getType() == type));
    }

    // you can also use findFirst, findAny
    public static void findVegetarianAnyDish(List<Dish> menu) {
        Optional<Dish> dish = menu.stream().filter(Dish::isVegetarian).findAny();
        if (dish.isPresent())
            System.out.println("VEGETARIAN DISH --- " + dish.get()); /// print the dish

    }

    public static void findFirstDishWithCalorieGreaterThanAValue(List<Dish> menu, int n) {
        Optional<Dish> dish = menu.stream().filter(e -> e.getCalories() > n).findFirst();
        System.out.println(dish.isPresent());
    }

    public static void filterMapExample() {
        List<String> teamIndia = Arrays.asList("Virat", "Dhoni", "Jadeja");
        List<String> teamAustralia = Arrays.asList("Warner", "Watson", "Smith");
        List<String> teamEngland = Arrays.asList("Alex", "Bell", "Broad");
        List<String> teamNewZeland = Arrays.asList("Kane", "Nathan", "Vettori");

        List<String> playerList = Stream.of(teamIndia,teamAustralia,teamEngland,teamNewZeland)
                .flatMap(l -> l.stream()).collect(toList());
        System.out.println(playerList);
    }

    public static void filterDistinctNumbers(List<Integer> numbers) {
        System.out.println(numbers.stream().filter(i -> i % 2 == 0).distinct().collect(toList()));
    }

    public static void getMaxCalories(List<Dish> menu) {
        OptionalInt max = menu.stream().mapToInt(Dish::getCalories).max();
        System.out.println(max);

        Optional<Integer> maxCalorie = menu
                .stream()
                .collect(Collectors.mapping((dish) ->dish.getCalories(), Collectors.maxBy(Integer::compareTo)));

        System.out.println("Max Calorie: " + maxCalorie.get());
    }

    public static void getTotalCalories(List<Dish> menu) {
        int total = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(total);
    }

    public static void getAverageCalories(List<Dish> menu) {
        OptionalDouble avg = menu.stream().mapToDouble(Dish::getCalories).average();
        // /double avg = menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println(avg);
    }

    public static void getNamesOfAllDishesAsAString(List<Dish> menu) {
        String listOfNames = menu.stream().map(Dish::getName).collect(joining(","));
        System.out.println(listOfNames);
    }

    public static void groupDishesAccordingToType(List<Dish> menu) {
        Map<Dish.Type, List<Dish>> groups = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println();
        System.out.println("GROUPING DISHES BY TYPE");
        System.out.println(groups);

        for (Entry<Dish.Type, List<Dish>> entry : groups.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
        System.out.println();
    }

    // classify as “diet” all dishes with 400 calories or fewer, set to
    // “normal” the dishes having between 400 and 700 calories, and set to “fat” the
    // ones with more
    // than 700 calories
    public static void classifyDishByCalories(List<Dish> menu) {
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(groupingBy(dish -> {
            return getCalorificLevel(dish);
        }));

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByCaloricLevelInMultiLevelMap = menu.stream()
                .collect(groupingBy(Dish::getType, groupingBy(dish -> {
                    return getCalorificLevel(dish);
                })));

        System.out.println("CLASSIFY DISHES BY CALORIES");
        System.out.println(dishesByCaloricLevel);
        System.out.println();
        System.out.println(dishesByCaloricLevelInMultiLevelMap);
    }

    public static void findTheHighestCalorieDishInASubgroup(List<Dish> menu) {
        Map<Dish.Type, Dish> dishes = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors
                .collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));

        System.out.println("HIGHEST CALORIE DISH IN A SUBGROUP");
        System.out.println(dishes + "\n");
    }

    public static void sumTheCaloriesInEachTypeOfDiet(List<Dish> menu) {
        Map<Dish.Type, Integer> sumOfDishes = menu.stream()
                .collect(groupingBy(Dish::getType, Collectors.summingInt(Dish::getCalories)));

        System.out.println("SUM OF DISHES CALORIES BY GROUPING");
        System.out.println(sumOfDishes);
    }

    public static void groupByDishAndThenByVegetarian(List<Dish> menu) {
        Map<Dish.Type, Map<Boolean, String>> group = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,  //outer group

                groupingBy(Dish::isVegetarian, // group by Vegetarian - (inner group)
                        Collectors.mapping(Dish::getName, Collectors.joining(",")))));
        System.out.println();
        System.out.println("GROUP BY DISH AND THEN BY VEGETARIAN");
        System.out.println(group);
    }

    public static void getCaloricLevelsinEachDishType(List<Dish> menu) {
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(dish -> {
                    return getCalorificLevel(dish);
                }, toCollection(HashSet::new))));

        System.out.println();
        System.out.println("CALORIC LEVELS BY TYPE");
        System.out.println(caloricLevelsByType);
    }

    public static void partitionVegetarianDishesAndGroupByType(List<Dish> menu) {
        Map<Boolean, Map<Dish.Type, List<Dish>>> partition = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));

        System.out.println("GET PARTITIONED DISHES BY TYPE");
        System.out.println(partition);
    }

    public static void getMostCaloricPartitionedByVegetarian(List<Dish> menu) {
        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menu.stream().collect(partitioningBy(Dish::isVegetarian,
                collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));

        System.out.println();
        System.out.println("MOST CALORIFIC PARTITIONED BY PARTITION");
        System.out.println(mostCaloricPartitionedByVegetarian);

    }

    public static void sumAllCalories(List<Dish> menu) {
        int caloriesSum = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        double caloriesAvg = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));

        // int caloriessum = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println("total Calories sum = " + caloriesSum + "\n");
    }

    public static void countNumberOfDishesInAMenu(List<Dish> menu) {
        Map<Dish.Type, Long> count = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        System.out.println("NUMBER OF DISHES IN A MENU");
        System.out.println(count);
    }

    public static void getHighestCalorieDish(List<Dish> menu) {
        Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream()
                .collect(groupingBy(Dish::getType, maxBy(Comparator.comparingInt(Dish::getCalories))));

        System.out.println("MOST CALORIFIC BY TYPE");
        System.out.println(mostCaloricByType);
    }

    public static CaloricLevel getCalorificLevel(Dish dish) {
        if (dish.getCalories() <= 400)
            return CaloricLevel.DIET;
        else if (dish.getCalories() <= 700)
            return CaloricLevel.NORMAL;
        else
            return CaloricLevel.FAT;
    }
}
