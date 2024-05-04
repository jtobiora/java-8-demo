package com.swiftfingers.lamda1;

import java.util.Arrays;
import java.util.List;

public class DishTest {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 200, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));

        DishOperation.isVegitarianDish(menu);

        DishOperation.getFirstNDishesWithCaloriesGreaterThanAValue(menu, 2);

        DishOperation.skipFirstNDishesWithCaloriesGreaterThan(menu, 3);

        DishOperation.findTheFirstNMeatDishes(menu, 2);

        DishOperation.printDishesByTheCountOfTheirNames(menu);

        DishOperation.printDishesByTheirNames(menu);

        DishOperation.filterMapExample();

        DishOperation.checkIfMenuHasAParticularOptionType(menu, Dish.Type.MEAT);

        DishOperation.findFirstDishWithCalorieGreaterThanAValue(menu, 300);

        DishOperation.findVegetarianAnyDish(menu);
        // filterDistinctNumbers(Arrays.asList(1, 2, 1, 3, 3, 2, 4));

        DishOperation.getMaxCalories(menu);

        DishOperation.getNamesOfAllDishesAsAString(menu);

        DishOperation.groupDishesAccordingToType(menu);

        DishOperation.classifyDishByCalories(menu);

        DishOperation.findTheHighestCalorieDishInASubgroup(menu);

        DishOperation.sumTheCaloriesInEachTypeOfDiet(menu);

        DishOperation.groupByDishAndThenByVegetarian(menu);

        DishOperation.getCaloricLevelsinEachDishType(menu);

        DishOperation.partitionVegetarianDishesAndGroupByType(menu);

        DishOperation.getMostCaloricPartitionedByVegetarian(menu);

        DishOperation.sumAllCalories(menu);

        DishOperation.countNumberOfDishesInAMenu(menu);

        DishOperation.getHighestCalorieDish(menu);
    }

}
