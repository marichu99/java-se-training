package com.systechafrica.part3.exceptionhandling;

public class Calculator {
    public double divide (int a, int b)    {
        try{
            return a/b;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }       
    }
    public boolean connect() throws ClassNotFoundException{
        Class.forName("com.mysql.cj.jbdc.Driver");
        return true;
    }
    public int sum(int a , int b) throws MyCustomExpception
    {
        throw new MyCustomExpception("Method not implemented");
    }
}
