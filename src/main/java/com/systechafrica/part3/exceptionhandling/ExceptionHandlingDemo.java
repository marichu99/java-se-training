package com.systechafrica.part3.exceptionhandling;

public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        double result = calculator.divide(6, 0);
        System.out.println(result);
        try{
            System.out.println("before connection");
            calculator.connect();
            System.out.println("after connection");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("processing .......");
    }    
}
