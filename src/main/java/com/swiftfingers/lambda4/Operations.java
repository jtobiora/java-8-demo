package com.swiftfingers.lambda4;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class Operations {
    public static void getPersonsAndShowAverageAge(List<Person> persons) {
        Map<String, Double> ageAvg = persons.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge)));
        System.out.println("THE AVERAGE AGE IS ");
        System.out.println(ageAvg);
    }

    public static void getYoungestPersonGreaterThan20Years(List<Person> persons) {
        Optional<Person> ageCompare = persons.stream().filter(p -> p.getAge() >= 20)
                .min(Comparator.comparing(Person::getAge));

        Optional<Person> a = persons.stream().filter(p -> p.getAge() >= 20)
                .sorted(Comparator.comparing(Person::getAge))
                .findFirst();


    }

    public static void groupByAgeAndCountPeopleInEachAgeBracket(List<Person> persons) {
        Map<Integer, Long> map = persons.stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));

//        Map<Integer,Long> map2 =
//        persons.stream().collect(Collectors.toMap(Person::getAge,
//         p -> 1L,Long::sum);

        System.out.println("GROUP BY AGE AND COUNT THE NUMBER OF PEOPLE IN EACH GROUP");
        System.out.println(map);
        // System.out.println(map2);
    }

    public static void groupByAgeAndGetAListOfNames(List<Person> persons) {
        Map<Integer, List<String>> map2 = persons.stream().collect(
                Collectors.groupingBy(Person::getAge,
                        Collectors.mapping(Person::getName, Collectors.toList())));

        System.out.println("GROUP BY AGE AND MAP EACH NAME INTO A LIST");
        System.out.println(map2);
        System.out.println();
    }

    public static void groupByAgeAndGetAListOfPersons(List<Person> persons) {
        Map<Integer, List<Person>> group = persons.stream().collect(Collectors.groupingBy(Person::getAge));

        group.forEach((age, list) -> System.out.println(age + " -> " + list));
        System.out.println();
    }

    public static void filterPersons(List<Person> personsList) {
        Map<String, List<Person>> filteredPersons = personsList
                .stream().filter(persons -> persons.getAge() > 30)
                .collect(Collectors.groupingBy(Person::getName));

        System.out.println("PEOPLE ABOVE 30 YEARS");
        System.out.println(filteredPersons);
        System.out.println();
    }

    public static void groupByAgeAndSortNamesAscending(List<Person> persons) {
        Map<Integer, Set<String>> map3 = persons.stream()
                .collect(Collectors.groupingBy(Person::getAge,
                Collectors.mapping(Person::getName, Collectors.toCollection(TreeSet::new))));

        System.out.println("SORT BY AGE AND NAMES ASCENDING");
        System.out.println(map3);
        System.out.println();
    }

    public static void groupByAgeAndSortAgesAndNamesInAscendingOrder(List<Person> persons) {
        TreeMap<Integer, TreeSet<String>> mapObj =
                persons.stream()
                        .filter(Objects::nonNull)
                        .collect(Collectors.groupingBy(
                                Person::getAge, // group by age
                                TreeMap::new, // sort the ages using a TreeMap
                                Collectors.mapping(
                                        Person::getName, // map the Persons object to names
                                        Collectors.toCollection(
                                                TreeSet::new)))); // collect the names in a TreeSet to sort them

        log.info("Sorting and Grouping");
        log.info("Printing object {} ", mapObj);
    }

    public static TreeMap<? extends Number,TreeSet<String>> sortAndGroupPersons(String nameString)
            throws InterruptedException,ExecutionException{

        log.info("Sort Persons by age and then by name from a list obtained after filtering using a passed param");

        TreeMap<Integer, TreeSet<String>> collect = CompletableFuture
                .completedFuture(FlowStream.getPersonList()
                        .stream()
                        .filter(f -> f.getName().startsWith(nameString))
                        .collect(Collectors.toList()))
                .thenApply(f -> {
                    return f.stream()
                            .limit(2)
                            .collect(Collectors.toList());
                })
                .thenCombine(persons(), (x, y) -> {
                    return x;
                })
                .get()
                .parallelStream()
                .filter(Objects::nonNull)
                .collect(Collectors
                        .groupingBy(
                                Person::getAge,
                                TreeMap::new,
                                Collectors.mapping(
                                        Person::getName,
                                        Collectors.toCollection(
                                                TreeSet::new
                                        ))
                        ));
        log.info("Result collected into a TreeMap ****");
        return collect;
    }

    public static void partitionPersonsByAge(List<Person> persons) {
        Map<Boolean, List<Person>> partitionedMap =
                persons.stream()
                        .collect(
                                Collectors.partitioningBy(p -> p.getAge() > 40));


        log.info("Logging info {} ", partitionedMap);
    }

    public static void sortByNamesAndThenByAge(List<Person> persons) {
        System.out.println("COMPARING BY AGE AND THEN BY NAMES [IF TWO AGES ARE THE SAME]");
        persons.stream().sorted(Comparator.comparing(Person::getName).thenComparing(Person::getAge)).skip(3) // ignore
                // the
                // first
                // 3
                .limit(10) // select the first 5
                .forEach(System.out::println);

    }

    public static void printAllTheProgrammingLanguages(List<Person> persons) {
        System.out.println();
        System.out.println("PRINT ALL DISTINCT PROGRAMMING LANGUAGES");

        // System.out.println(
        // persons.stream()
        // .map(Person::getProgrammingLanguages) //returns a Stream<List<String>>
        // .flatMap(l -> l.stream()) //returns Stream<String>
        // .distinct()
        // .collect(Collectors.toList()));

        TreeSet<String> set = persons.stream().map(Person::getProgrammingLanguages) // returns a Stream<List<String>>
                .flatMap(Collection::stream) // returns Stream<String>
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println(set);
    }

    public static void calculateMaxAge(List<Person> persons) {
        System.out.println("THE MAXIMUM AGE IS ------- ");
        System.out.println(persons.stream().map(p -> p.getAge()).reduce(Integer::max).orElse(0));
    }

    public static void calculateMinAge(List<Person> persons) {
        System.out.println("THE MINIMUM AGE IS ------- ");
        int minAge = persons.stream().mapToInt(Person::getAge).min().orElse(0); // returns 0 if no minimum found
        System.out.println(minAge);
    }

    public static void calculateSumOfAges(List<Person> persons) {
        System.out.println("THE SUM OF THE AGES IS ------- ");
        Optional<Integer> minAge = persons.stream().map(Person::getAge).reduce(Integer::sum);
        System.out.println(minAge.isPresent() ? minAge.get() : null);
    }

    public static void print(List<Person> persons) {
        persons.stream()
                .filter(f -> {
                    String x = "A";
                    return f.getName().startsWith(x);
                })
                .map(p -> {
                    return p.getName();
                })
                .limit(3)
                .forEach(System.out::println);

    }

    public static CompletableFuture<String> persons(){
        return CompletableFuture.completedFuture("Empty String");
    }

    public static void main(String[] args) throws Exception{

    }


}
