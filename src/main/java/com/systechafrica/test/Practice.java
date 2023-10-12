package com.systechafrica.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        // reversingArrays();
        // printArrays();
        // tvResults();
        slicingStrings();
    }

    private static void slicingStrings() {
        String[] names =new String[]{"Thomas","Peter","Joseph"};
        String[] pwd = new String[3];
        int idx=0;
        try {
            for(String s : names){
                String subs = s.substring(2, 6);
                pwd[idx]=subs;
                idx++;
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
        for( String p : pwd){
            System.out.println(p);
        }
    }

    private static void tvResults() {
        String stuff= "TV";
        String res = null;

        res= stuff.equals("TV") ? "WALTER" : stuff.equals("movie") ? "white" : "no result";
        System.out.println(res);
    }

    private static void printArrays() {
        int[][] arr = new int [2][4];
        arr[0]=new int[]{1,3,5,7};
        arr[1]=new int[]{1,3};
        for(int a[]:arr){
            for (int b :a){
                System.out.print(b+" ");
            }
            System.out.println();
        }

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
