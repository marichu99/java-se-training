package com.systechafrica.part2.interfaces;

public class MobileCharger implements ThreePinPlug{

    @Override
    public boolean plugIn() {
        System.out.println("Mobile charger connected");
        return true;
    }

    @Override
    public boolean plugOut() {
        System.out.println("Mobile charger disconnected");
        return false;
    }
    
}
