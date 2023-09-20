package com.systechafrica.part2.interfaceecxercise.exercise1;

public class Circle implements Shape{
    private final double pie = 3.1427;
    private double r;
    public Circle(double r){
        this.r=r;
    }
    @Override
    public int getArea() {
        // TODO Auto-generated method stub
        return (int)(pie*r*r);
    }
    
}
