package com.systechafrica.part2.interfaceecxercise.exercise1;

import java.util.logging.Logger;

public class CalculateArea {
    public static final  Logger LOGGER= Logger.getLogger(CalculateArea.class.getName());
    public static void main(String[] args) {

        
        Shape circle = new Circle(7.8);
        Shape rectangle= new Rectangle(5,6);
        Shape triangle = new Triangle(12,12);

        LOGGER.info("The area of a circle is "+circle.getArea());
        LOGGER.info("The area of a rectangle is "+rectangle.getArea());
        LOGGER.info("The area of a triangle is "+triangle.getArea());
        
    }    
}
