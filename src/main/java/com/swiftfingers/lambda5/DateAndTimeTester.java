package com.swiftfingers.lambda5;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class DateAndTimeTester {
    public static void main(String[] args) {

        //The Period class represents a quantity of time in terms of years, months and days and the Duration
        // class represents a quantity of time in terms of seconds and nano seconds.
    }

    //The Period class is widely used to modify values of given a date or to obtain the difference between two dates:
    public static void usePeriod() {
        LocalDate initialDate = LocalDate.parse("2007-05-10");

        LocalDate finalDate = initialDate.plus(Period.ofDays(5));

        int years = Period.between(finalDate, initialDate).getYears();

        long days = ChronoUnit.DAYS.between(finalDate, initialDate);

    }

    // Function to get Zoned Date and Time
    public static void ZonedTimeAndDate() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter format1 =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedCurrentDate = date.format(format1);

        System.out.println("formatted current Date and" +
                " Time : " + formattedCurrentDate);

        // to get the current zone
        ZonedDateTime currentZone = ZonedDateTime.now();
        System.out.println("the current zone is " +
                currentZone.getZone());

        // getting time zone of specific place
        // we use withZoneSameInstant(): it is
        // used to return a copy of this date-time
        // with a different time-zone,
        // retaining the instant.
        ZoneId tokyo = ZoneId.of("Asia/Tokyo");

        ZonedDateTime tokyoZone =
                currentZone.withZoneSameInstant(tokyo);

        System.out.println("tokyo time zone is " +
                tokyoZone);

        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formatedDateTime = tokyoZone.format(format);

        System.out.println("formatted tokyo time zone " +
                formatedDateTime);

    }

    public static void checkingPeriod() {
        LocalDate date1 = LocalDate.now();

        LocalDate date2 =
                LocalDate.of(2014, Month.DECEMBER, 12);

        Period gap = Period.between(date2, date1);
        System.out.println("gap between dates " +
                "is a period of " + gap);
    }

    // Function to check duration
    public static void checkingDuraion() {

        LocalTime time1 = LocalTime.now();
        System.out.println("the current time is " +
                time1);

        Duration fiveHours = Duration.ofHours(5);

        // adding five hours to the current
        // time and storing it in time2
        LocalTime time2 = time1.plus(fiveHours);

        System.out.println("after adding five hours " +
                "of duration " + time2);

        Duration gap = Duration.between(time2, time1);
        System.out.println("duraion gap between time1" +
                " & time2 is " + gap);
    }

    // Function to check ChronoUnit
    public static void checkingChronoEnum() {
        LocalDate date = LocalDate.now();
        System.out.println("current date is :" +
                date);

        // adding 2 years to the current date
        LocalDate year =
                date.plus(2, ChronoUnit.YEARS);

        System.out.println("next to next year is " +
                year);

        // adding 1 month to the current data
        LocalDate nextMonth =
                date.plus(1, ChronoUnit.MONTHS);

        System.out.println("the next month is " +
                nextMonth);

        // adding 1 week to the current date
        LocalDate nextWeek =
                date.plus(1, ChronoUnit.WEEKS);

        System.out.println("next week is " + nextWeek);

        // adding 2 decades to the current date
        LocalDate Decade =
                date.plus(2, ChronoUnit.DECADES);

        System.out.println("20 years after today " +
                Decade);
    }

    // Function to check date and time
    // according to our requirement
    public static void checkingAdjusters() {

        LocalDate date = LocalDate.now();
        System.out.println("the current date is " +
                date);

        // to get the first day of next month
        LocalDate dayOfNextMonth =
                date.with(TemporalAdjusters.
                        firstDayOfNextMonth());

        System.out.println("firstDayOfNextMonth : " +
                dayOfNextMonth);

        // get the next saturday
        LocalDate nextSaturday =
                date.with(TemporalAdjusters.
                        next(DayOfWeek.SATURDAY));

        System.out.println("next satuday from now is " +
                nextSaturday);

        // first day of current month
        LocalDate firstDay =
                date.with(TemporalAdjusters.
                        firstDayOfMonth());

        System.out.println("firstDayOfMonth : " +
                firstDay);

        // last day of current month
        LocalDate lastDay =
                date.with(TemporalAdjusters.
                        lastDayOfMonth());

        System.out.println("lastDayOfMonth : " +
                lastDay);
    }

    public static void LocalDateTimeApi() {

        // the current date
        LocalDate date = LocalDate.now();
        System.out.println("the current date is " +
                date);


        // the current time
        LocalTime time = LocalTime.now();
        System.out.println("the current time is " +
                time);


        // will give us the current time and date
        LocalDateTime current = LocalDateTime.now();
        System.out.println("current date and time : " +
                current);


        // to print in a particular format
        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formatedDateTime = current.format(format);

        System.out.println("in foramatted manner " +
                formatedDateTime);


        // printing months days and seconds
        Month month = current.getMonth();
        int day = current.getDayOfMonth();
        int seconds = current.getSecond();
        System.out.println("Month : " + month + " day : " +
                day + " seconds : " + seconds);

        // printing some specified date
        LocalDate date2 = LocalDate.of(1950, 1, 26);
        System.out.println("the republic day :" + date2);

        // printing date with current time.
        LocalDateTime specificDate =
                current.withDayOfMonth(24).withYear(2016);

        System.out.println("specfic date with " +
                "current time : " + specificDate);
    }

}
