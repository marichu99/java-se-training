package com.systechafrica.part2.interfaces;

public class Square implements CalculateArea, CalculatePerimeter{

    @Override
    public double calculateArea(double x, double y) {
        System.out.println(name);
        return x*y;
    }

    @Override
    public double perimeter(double x, double y) {
        System.out.println(nams);
        return 2*(x+y);
    }
    
}
