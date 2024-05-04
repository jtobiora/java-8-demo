package com.swiftfingers.lambda5;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class DateTest {
    public static void main(String[] args) {
        Student student1 = new Student("Chioma",LocalDate.of(1988, Month.APRIL,21));
        Student student2 = new Student("Daniel",LocalDate.of(1989, Month.JANUARY,25));
        Student student3 = new Student("Anthony",LocalDate.of(1990, Month.FEBRUARY,14));
        Student student4 = new Student("Lucy",LocalDate.of(1992, Month.MARCH,23));
        Student student5 = new Student("Hillary",LocalDate.of(1993, Month.MAY,15));
        Student student6 = new Student("Samuel",LocalDate.of(1983, Month.JULY,19));
        Student student7 = new Student("Larry",LocalDate.of(1988, Month.JUNE,18));
        Student student8 = new Student("Stella",LocalDate.of(1998, Month.AUGUST,17));

        List<Student> studentList = Arrays.asList(student1,student2,student3,student4,student5,student6,student7,student8);

        computeWhenBorn(studentList);

        computeTimeZones();
        localTimeDemo();
        miscMethods();
    }

    public static void computeTimeZones() {
        Set<String> zones = ZoneId.getAvailableZoneIds();
        zones.stream().forEach( zone -> {
            ZoneId current = ZoneId.of(zone);
            System.out.println(current);
        });

    }

    public static void localTimeDemo() {
        LocalTime now = LocalTime.now();
        System.out.println(now.plusHours(10)); // add 10 hours after this time

    }

    public static void computeWhenBorn(List<Student> list) {
        LocalDate now = LocalDate.now();
        list.stream()
                .forEach(st -> {
                    //a period is a time between two LocalDates

                    Period timeElapsed = Period.between(st.getDateOfbirth(), now);
                    Long totalNoOfMonthsFromBirth = st.getDateOfbirth().until(now, ChronoUnit.MONTHS);

                    System.out.println(st.getName() + " was born " + timeElapsed.get(ChronoUnit.YEARS) + " years, "
                            + timeElapsed.get(ChronoUnit.MONTHS) + " months, and " + timeElapsed.get(ChronoUnit.DAYS) +
                            " days ago! {" + totalNoOfMonthsFromBirth + " months}");
                });
    }

    public static void miscMethods() {
        Date d = new Date();
        LocalDate date1 = LocalDate.parse("2017-03-17");
        LocalDate date2 = LocalDate.parse("2017-03-18");
        ZoneId zoneId = ZoneId.systemDefault();
        long epoch1 = date1.atStartOfDay(zoneId).toEpochSecond();
        long epoch2 = date2.atStartOfDay(zoneId).toEpochSecond();
        System.out.println(epoch1 + " epoch 1");
        System.out.println(epoch2 + " epoch 2");
        System.out.println("difference in epoch " + (epoch2 - epoch1));
//      LocalDateTime dateTime = LocalDateTime.parse("Fri Jun 02 00:00:00 WAT 2017",
//    		  DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss Z yyyy"));
//
//      Long e = dateTime.atZone(ZoneId.of("Europe/Oslo")).toEpochSecond();
//      System.out.println(e + " seconds from time zone");

        System.out.println(date1.getDayOfYear());
        System.out.println(date1.getDayOfWeek());

        LocalDate dt = LocalDate.parse("2017-09-25");
        LocalDate dt2 = LocalDate.parse("2017-09-30");

        Period from = Period.between(dt, dt2);

        //An Instant is a point on the time line
        Instant now = Instant.now();
        System.out.println(now);

        //A Duration is a period between two Instants


        LocalDate dateNow = LocalDate.now();
        LocalDate nextSunday = dateNow.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(nextSunday);



    }
}

