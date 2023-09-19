package com.systechafrica.part2.interfaces;

public interface CalculatePerimeter {
    double perimeter(double x, double y);

    // in java 1.8+ we can provide default implementation
    default double sum(double x, double y){
        return 0;
    }
}
