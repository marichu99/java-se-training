package com.systechafrica.systechrestaurant;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Arrays;

public class SystechRestaurantSystem {
    private final String PASSWORD="Admin123";
    private final int noTrials=3;
    private String[] foodStrings={};
    private double[] foodPrices={};
    private Scanner myScanner = new Scanner(System.in);
    // function to login the user
    public void userLogin(){        
        for(int i=0;i<=noTrials+1;i++){
            // request for the credentials           
            System.out.print("Enter your password: ");
            String inputPass=myScanner.nextLine();
            // passInput.nextLine(); // to remove the escape sequence /n
            if(i<=3){
                if(inputPass.equals(PASSWORD)){
                    System.out.println("Welcome to the System");
                    showMenu();
                    break;
                }else{
                    System.out.println("Invalid Login please try again, you have "+(noTrials-i)+" trials left");
                }
            }else{
                System.out.println("You have maxed out your trials");
                System.exit(0);
            }
        }
    }
    private void showMenu() {
        System.out.println("*******************");
        System.out.println("Systech Restaurant");
        System.out.println("");
        System.out.println("DRINKS");
        System.out.println("-------------------");
        System.out.println("1. CHAI--------------------------------15");
        System.out.println("2. ANDAZI------------------------------10");
        System.out.println("3. TOSTI-------------------------------12");
        System.out.println("");
        System.out.println("MEALS");
        System.out.println("-------------------");
        System.out.println("4. NDENGU AND ACCOMPLISHMENTS----------70");
        System.out.println("5. BEANS AND ACCOMPLISHMENTS-----------70");
        System.out.println("6. PILAU VEG---------------------------90");
        System.out.println("7. QUIT");
        System.out.print("Enter your Meal/Drink option: ");


        int chosenInput= myScanner.nextInt();
        myScanner.nextLine();
        takeInput(chosenInput);

    }
    private void takeInput(int chosenInput) {
        MealDrinks mealDrink = new MealDrinks();
        if(chosenInput == 1){
            // get the price of tea
            double teaPrice=mealDrink.getTeaPrice();
            String teaString=mealDrink.getTeaString();
            // we create a function to append into the foodStrings and the foodPrices array
            foodPrices= appendInt(foodPrices,teaPrice);
            foodStrings= appendString(foodStrings,teaString);
            askForAnotherDish();            
        }else if(chosenInput == 2){
            // get the price of tea
            double andaziPrice=mealDrink.getAndaziPrice();
            String andaziString=mealDrink.getAndaziString();
            // we create a function to append into the foodStrings and the foodPrices array
            foodPrices= appendInt(foodPrices,andaziPrice);
            foodStrings= appendString(foodStrings,andaziString);
            askForAnotherDish(); 
        
        }else if(chosenInput ==3 ){
            // get the price of tea
            double tostiPrice=mealDrink.getTostiPrice();
            String tostiString=mealDrink.getTostiString();
            // we create a function to append into the foodStrings and the foodPrices array
            foodPrices= appendInt(foodPrices,tostiPrice);
            foodStrings= appendString(foodStrings,tostiString);
            askForAnotherDish();         
        }else if(chosenInput == 4){
            // get the price of tea
            double ndenguPrice=mealDrink.getNdenguPrice();
            String ndenguString=mealDrink.getNdenguString();
            // we create a function to append into the foodStrings and the foodPrices array
            foodPrices= appendInt(foodPrices,ndenguPrice);
            foodStrings= appendString(foodStrings,ndenguString);
            askForAnotherDish(); 
        
        }else if(chosenInput == 5){
            // get the price of tea
            double beansPrice=mealDrink.getBeansPrice();
            String beanString=mealDrink.getBeansString();
            // we create a function to append into the foodStrings and the foodPrices array
            foodPrices= appendInt(foodPrices,beansPrice);
            foodStrings= appendString(foodStrings,beanString);
            askForAnotherDish(); 
        
        }else if(chosenInput ==6 ){
            // get the price of tea
            double pilauPrice=mealDrink.getPilauPrice();
            String pilauString=mealDrink.getPilauString();
            // we create a function to append into the foodStrings and the foodPrices array
            foodPrices= appendInt(foodPrices,pilauPrice);
            foodStrings= appendString(foodStrings,pilauString);
            askForAnotherDish(); 
        
        }else{
            System.out.println("******************************");
            System.out.println("Invalid choice, choose another option");
            showMenu();
        }
    }
    private double[] appendInt(double[] array, double x) {
        array=Arrays.copyOf(array, array.length+1);
        array[array.length-1]=x;
        return array;
    }
    private String[] appendString(String[] array, String x) {
        array=Arrays.copyOf(array, array.length+1);
        array[array.length-1]=x;
        return array;
    }
    private void askForAnotherDish(){
        System.out.print("Do you want to enter another meal/drink option[Y/N]: ");
        String option = myScanner.nextLine();
        if(option.equals("N")){
            makePayment();
        }else if(option.equals("Y")){
            showMenu();
        }else{
            System.out.println("Invalid Choice");
            // make it a recursive function
            askForAnotherDish();
        }
    }
    private void makePayment() {

    }
    public static void main(String[] args) {
        SystechRestaurantSystem restaurantSystem = new SystechRestaurantSystem();
        restaurantSystem.userLogin();
        
    }
}
