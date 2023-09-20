package com.systechafrica.part2.interfaceecxercise.exercise1;

public class Rectangle implements Shape{
    private int a;
    private int b;
    public Rectangle(int a, int b){
        this.a=a;
        this.b=b;
    }
    @Override
    public int getArea() {
        // TODO Auto-generated method stub
        return this.a*this.b;
    }
    
}
