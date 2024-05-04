package com.swiftfingers.lambda4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class FlowStream {
    public static void main(String[] args) {

        Operations.print(getPersonList());

        // filter out the youngest person older than or equal to 20 years
        Operations.getYoungestPersonGreaterThan20Years(getPersonList());

        // group by age and count the persons in each group
        Operations.groupByAgeAndCountPeopleInEachAgeBracket(getPersonList());

        // group by age and the values should be a list of names
        Operations.groupByAgeAndGetAListOfNames(getPersonList());

        // group by age and the values of the map should a list of persons
        Operations.groupByAgeAndGetAListOfPersons(getPersonList());

        // group by age and the values should be a list of persons in sorted order
        Operations.groupByAgeAndSortNamesAscending(getPersonList());

        // filter out all the persons who are above 30 years and group them by their
        // names
        // in descending order
        Operations.filterPersons(getPersonList());

        Operations.groupByAgeAndSortNamesAscending(getPersonList());

        Operations.partitionPersonsByAge(getPersonList());

        // group by age and sort both ages(keys) and names(values) in ascending order
        Operations.groupByAgeAndSortAgesAndNamesInAscendingOrder(getPersonList());

        Operations.sortByNamesAndThenByAge(getPersonList());

        Operations.printAllTheProgrammingLanguages(getPersonList());

        Operations.calculateMaxAge(getPersonList());

        Operations.calculateMinAge(getPersonList());

        Operations.calculateSumOfAges(getPersonList());

        Operations.getPersonsAndShowAverageAge(getPersonList());
    }

    public static List<Person> getPersonList(){
        List<Person> personsList = new ArrayList<>();
        personsList.add(new Person(12, "John", Arrays.asList(new String[] { "PHP", "Java" })));
        personsList.add(new Person(35, "Andrew", Arrays.asList(new String[] { "Java" })));
        personsList.add(new Person(22, "Peter", Arrays.asList(new String[] { "C#" })));
        personsList.add(new Person(25, "Mark", Arrays.asList(new String[] { "C++" })));
        personsList.add(new Person(49, "Silvia", Arrays.asList(new String[] { "Ruby" })));
        personsList.add(new Person(39, "Rose", Arrays.asList(new String[] { "Scala" })));
        personsList.add(new Person(39, "Rose", Arrays.asList(new String[] { "Scala", "Python" })));
        personsList.add(new Person(33, "Thomas", Arrays.asList(new String[] { "React", "PHP" })));
        personsList.add(new Person(27, "Rita", Arrays.asList(new String[] { "Angular", "React" })));
        personsList.add(new Person(48, "Agnes", Arrays.asList(new String[] { "Java", "SQL" })));
        personsList.add(new Person(35, "Sandra", Arrays.asList(new String[] { "C#" })));
        personsList.add(new Person(25, "Patrick", Arrays.asList(new String[] { "Ruby" })));
        personsList.add(new Person(39, "Abraham", Arrays.asList(new String[] { "JavaScript" })));
        personsList.add(new Person(42, "Michael", Arrays.asList(new String[] { "Python" })));
        personsList.add(new Person(27, "James", Arrays.asList(new String[] { "C#", "Java" })));
        personsList.add(new Person(64, "Jones", Arrays.asList(new String[] { "PHP", "React" })));
        personsList.add(new Person(35, "Jimoh", Arrays.asList(new String[] { "C#", "C++" })));
        personsList.add(new Person(74, "Ken", Arrays.asList(new String[] { "PHP" })));

        return personsList;

    }

    public static CompletableFuture<List<Person>> getPersonsByAlphabet(String letter){
        return CompletableFuture.completedFuture(getPersonList().stream().filter(f -> f.getName().startsWith(letter)).collect(Collectors.toList()));
    }


}
