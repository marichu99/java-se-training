package com.systechafrica.operators;
import java.util.logging.Logger;


public class OperatorsDemo{
    private static final Logger LOGGER= Logger.getLogger(OperatorsDemo.class.getName());

    private void arithmeticOperator(){
        int s_1age=23;
        int s_2age=24;

        int total_age=s_1age+s_2age;
        LOGGER.info("The total age is"+total_age);
    }
    private void productOperator(){
        int a= 64;
        int b=76;
        int prod_a_b=a*b;

        LOGGER.info("The product is "+prod_a_b);
    }
    private void modulusOPerator(){
        int x =54;
        int remainder=x%2;
        LOGGER.info("The remainder of the value"+remainder);
    }
    private void assignmentOperator(){
        int a =45;
        for (int x=0;x<30;x++){
            a+=30;
            LOGGER.info("The cummulative sum is"+a);
        }
    }
    private void comparisonOperator(){
        int c =45;
        int b=76;
        boolean is_b_equalto_c= c==b;
        LOGGER.info("The statement that c is equal to b is "+is_b_equalto_c);
    }
    public static void main(String[] args){
        OperatorsDemo app = new OperatorsDemo();

        app.arithmeticOperator();
        app.productOperator();
        app.modulusOPerator();
        app.assignmentOperator();
        app.comparisonOperator();
    }
}