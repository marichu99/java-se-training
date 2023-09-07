package com.systechafrica.pointofsale;

import java.util.ArrayList;
import java.util.Scanner;

public class PointOfSale {

    private final String PASSWORD="Admin123";
    private final int noTrials=3;

    // function to login the user
    public void userLogin(){
        // request for the credentials
        Scanner passInput= new Scanner(System.in);
        System.out.print("Enter your password: ");
        String inputPass=passInput.nextLine();
        // passInput.nextLine(); // to remove the escape sequence /n
        for(int i=0;i<=noTrials+1;i++){
            if(i<=3){
                if(inputPass.equals(PASSWORD)){
                    System.out.println("Welcome to the System");
                    showMenu();
                    break;
                }else{
                    System.out.println("Invalid Login please try again, you have"+(noTrials-i)+" trials left");
                }
            }else{
                System.out.println("You have maxed out your trials");
                System.exit(0);
            }
        }
        passInput.close();
    }
    private void showMenu() {
        System.out.println("******************************");
        System.out.println("Systech POS System");
        System.out.println("******************************");
        System.out.println("");
        System.out.println("1. Add item");
        System.out.println("2. Make payment");
        System.out.println("3. Display receipt");
        System.out.print("Choose an option [1-3] :");

        Scanner inputOption= new Scanner(System.in);
        int chosenInput= inputOption.nextInt();
        if(chosenInput == 1){
            addItem();
        }else if(chosenInput ==2){
            makePayment();
        }else if(chosenInput == 3){
            // displayReceipt();
        }else{
            System.out.println("******************************");
            System.out.println("Invalid choice, choose another option");
            showMenu();
        }
        inputOption.close();
    }
    private void makePayment() {
        // get the total price but get the items array of objects first
        Items itemObj = new Items();
        Object[] items=itemObj.getItemObjects();
        // set the total price variable
        double totalPrice=0.0;
        // get the length of the array
        for(Object item : items){
            System.out.println(item);
        }
        showMenu();
    }
    private void addItem() {
        Scanner itemAdd= new Scanner(System.in);
        System.out.print("How many items do you want to enter: ");
        int n_items=itemAdd.nextInt();
        itemAdd.nextLine();
        Items[] items= new Items[n_items];
        for(int i=0;i<n_items;i++){
            System.out.println("Enter the item Code");
            int itemCode=itemAdd.nextInt();
            System.out.println("Enter the item Quantity");
            int quantity=itemAdd.nextInt();
            System.out.println("Enter the item Price");
            int unitPrice=itemAdd.nextInt();
            Items item = new Items(itemCode, quantity, unitPrice);
            items[i]=item;
        }
        // set the item object
        Items itemObj=new Items();
        itemObj.setItemObject(items);
        System.out.println("******************************");
        System.out.println("Item has been added successuly");
        System.out.println("******************************");

        showMenu();        
        // close the scanner
        itemAdd.close();        
    }
    public static void main(String[] args) {
        Scanner myscanner= new Scanner(System.in);
        PointOfSale pos = new PointOfSale();
        pos.userLogin();

        // myscanner.close();
        
    }
}
