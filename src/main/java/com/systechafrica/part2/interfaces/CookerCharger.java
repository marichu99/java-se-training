package com.systechafrica.part2.interfaces;

public class CookerCharger implements ThreePinPlug{

    @Override
    public boolean plugIn() {
        System.out.println("Cooker PLugged in ");
        return false;
    }

    @Override
    public boolean plugOut() {
        System.out.println("Cooker not plugged");
        return false;
    }
    
}
