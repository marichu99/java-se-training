package com.systechafrica.part2;

import java.util.logging.Logger;

public class Car {
    public static final Logger LOGGER=Logger.getLogger(Car.class.getName());
    String make;
    int speed=50;

    void accelerate(){
        LOGGER.info("The Speed has been accelerated to "+speed+"KM/hr");
    }
    
    
}
