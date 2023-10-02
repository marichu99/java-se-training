package com.systechafrica.part4.utildates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class WorkingWithNewDateTime {
    public static void main(String[] args) {
        // workingWithLocalDate();
        // workingWithLocalDateTime();
        workingWithLocalTime();
        
    }

    private static void workingWithLocalTime() {
        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);
        LocalTime startDate = LocalTime.of(8, 0, 0);
        LocalTime endTime= startDate.plusHours(2).plusMinutes(30);
        System.out.println("The end time is "+endTime);
    }

    private static void workingWithLocalDateTime() {
        LocalDateTime currentTime =LocalDateTime.now();
        System.out.println(currentTime);
        // let us format our date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(currentTime));
        LocalDate date1=LocalDate.parse("2023-10-20",DateTimeFormatter.ISO_DATE);
        System.out.println("date1"+date1);
       
        try {
             LocalDateTime thisDate =  LocalDateTime.parse("2023-10-20");
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void workingWithLocalDate() {
        // we can not instantiate a LocalDate Class because it is a final class
        LocalDate todayDate = LocalDate.now();
        System.out.println(todayDate);
        // LocalDate, LocalDateTime and LocalTime are immutable
        LocalDate futureDate = todayDate.plusDays(5);
        System.out.println(futureDate);

        String someString = "some string";
        someString.replaceAll("some", "");

        System.out.println(someString);
        System.out.println(LocalDate.of(2001, 3, 31));
        System.out.println(LocalDate.of(2001, Month.MARCH,0));
    }    
}
