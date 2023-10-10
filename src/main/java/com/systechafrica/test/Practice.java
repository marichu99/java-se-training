package com.systechafrica.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        reversingArrays();
    }

    private static void reversingArrays() {
        // get the array elements as input
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Kindly enter the number of elements in the array: ");
        // initialize an array that takes up the number of the input
        int arrSize = myScanner.nextInt();
        myScanner.nextLine();
        List<Integer> newArray = new ArrayList<>(arrSize);
        for(int i =0;i<arrSize;i++){
            System.out.print("Enter element "+i+" ");
            int element = myScanner.nextInt();
            newArray.add(element);
        }
        System.out.println(newArray);
        // the new integer list for the reversed array
        List<Integer> reversedList = new ArrayList<>(arrSize);
        for(int i=(arrSize-1);i>=0;i--){
            reversedList.add(newArray.get(i));
        }
        System.out.println(reversedList);
        myScanner.close();
    }    
}
