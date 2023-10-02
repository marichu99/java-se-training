package com.systechafrica.part4.utildates;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class WorkingWithUtilDates {
    public static void main(String[] args) {
        Date todayDate = new Date();
        System.out.println(todayDate);

        // add two days to the date
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 2);

        System.out.println(calendar.getTime());

        try(Scanner scanner = new Scanner(System.in)){
            System.out.print("Enter date ");
            String dateString = scanner.nextLine();

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date tomorrowDate =  df.parse(dateString);
            System.out.println(tomorrowDate.getTime());

            System.out.println(tomorrowDate.before(todayDate));
            System.out.println(todayDate.before(tomorrowDate));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }    
}
