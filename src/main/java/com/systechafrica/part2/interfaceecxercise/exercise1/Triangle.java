package com.systechafrica.part2.interfaceecxercise.exercise1;

public class Triangle implements Shape{

    private int base;
    private int height;
    public Triangle(int base, int height){
        this.base=base;
        this.height=height;
    }
    @Override
    public int getArea() {
        // TODO Auto-generated method stub
        return (int)(0.5*base*height);
    }
    
}
