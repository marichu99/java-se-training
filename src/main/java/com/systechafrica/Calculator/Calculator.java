package com.systechafrica.Calculator;

import java.util.Scanner;

public class Calculator {

    public int sum(int a,int b,int ...otherNumbers){
        int sum=a+b;
        for(int i=0;i<otherNumbers.length;i++){
            sum+=otherNumbers[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        Calculator calculator= new Calculator();
        Scanner myScanner=new Scanner(System.in);
        System.out.print("Enter a list of space separated numbers: ");
        int a= myScanner.nextInt();
        int b= myScanner.nextInt();
        int c= myScanner.nextInt();
        int d= myScanner.nextInt();
        int e= myScanner.nextInt();

        System.out.println(calculator.sum(a, b, c,d,e));
        myScanner.close();
    }
    
}
