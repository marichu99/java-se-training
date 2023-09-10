package com.systechafrica.systechrestaurant;

public class MealDrinks {
    // set the prices of the different dishes
    private double teaPrice=15.0;
    private double andaziPrice=10.0;
    private double tostiPrice=12.0;
    private double ndenguPrice=70.0;
    private double beansPrice=70.0;
    private double pilauPrice=90.0;

    // set the strings for the different kinds of dishes
    private String teaString="1. CHAI--------------------------------15";
    private String andaziString="2. ANDAZI------------------------------10";
    private String tostiString="3. TOSTI-------------------------------12";
    private String ndenguString="4. NDENGU AND ACCOMPLISHMENTS----------70";
    private String beanString="5. BEANS AND ACCOMPLISHMENTS-----------70";
    private String pilauString="6. PILAU VEG---------------------------90";

    public MealDrinks(){

    }
    // get the various prices of different dishes
    public double getTeaPrice(){
        return teaPrice;
    }
    public double getAndaziPrice(){
        return andaziPrice;
    }
    public double getTostiPrice(){
        return tostiPrice;
    }
    public double getNdenguPrice(){
        return ndenguPrice;
    }
    public double getBeansPrice(){
        return beansPrice;
    }
    public double getPilauPrice(){
        return pilauPrice;
    }
    // get the various strings
    public String getTeaString(){
        return teaString;
    }
    public String getAndaziString(){
        return andaziString;
    }
    public String getTostiString(){
        return tostiString;
    }
    public String getNdenguString(){
        return ndenguString;
    }
    public String getBeansString(){
        return beanString;
    }
    public String getPilauString(){
        return pilauString;
    }

}
