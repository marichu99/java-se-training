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
        try {
            calculator.sum(12,12);
        } catch (MyCustomExpception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("processing .......");

    }    
}
