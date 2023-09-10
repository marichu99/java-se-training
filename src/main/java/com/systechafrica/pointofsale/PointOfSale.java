package com.systechafrica.pointofsale;

import java.util.Scanner;

public class PointOfSale {

    private final String PASSWORD="Admin123";
    private final int noTrials=3;
    private double totalPrice=0.0;
    private double pricePerItem=0.0;
    private double change=0.0;
    private Items[] this_items=null; 
    private int no_items=0;
    private double customerAmount=0.0;
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
        System.out.println("******************************");
        System.out.println("Systech POS System");
        System.out.println("******************************");
        System.out.println("");
        System.out.println("1. Add item");
        System.out.println("2. Make payment");
        System.out.println("3. Display receipt");
        System.out.print("Choose an option [1-3] :");

        int chosenInput= myScanner.nextInt();
        takeInput(chosenInput);

    }
    private void displayReceipt() {
        
        if(this_items == null){
            System.out.println("******************************");
            System.out.println("Kindly add an item first");
            System.out.println("******************************");
            showMenu();
        }else if((customerAmount>0) == false){
            System.out.println("******************************");
            System.out.println("Kindly make payment first");
            System.out.println("******************************");
            showMenu();
        }else{
            System.out.println("Item Code   Quantity   Unit Price   TotalValue");
            // I set no_items as a global variable and thi_items too, which tracks the items that were set during the adding of an item
            for(int i=0;i<no_items;i++){
                System.out.println(this_items[i].getItemCode()+"              "+this_items[i].getQuantity()+"           "+this_items[i].getUnitPrice()+"                 "+this_items[i].getTotalPrices());
            }
            System.out.println("*******************************************************************");
            System.out.println("Total:      "+totalPrice);
            System.out.println("*******************************************************************");
            System.out.println("Enter the total Amount given by the customer: "+customerAmount);
            System.out.println("Change:     "+change);
            System.out.println("*******************************************************************");
            System.out.println("THANK YOU FOR SHOPPING WITH US");
            System.out.println("*******************************************************************");            
        }
    }

    private void takeInput(int chosenInput) {
        if(chosenInput == 1){
            addItem();
        }else if(chosenInput ==2){
            makePayment(false,null,0);
        }else if(chosenInput == 3){
            displayReceipt();
        }else{
            System.out.println("******************************");
            System.out.println("Invalid choice, choose another option");
            showMenu();
        }
    }
    // }
    private void makePayment(boolean fromAddItem,Items[] items,int n_items) {
        // set the total price variable
        if(n_items>0 && fromAddItem == true){            
            // get the length of the array
            for(int i=0;i<n_items;i++){
                pricePerItem=(items[i].getUnitPrice()*items[i].getQuantity());
                totalPrice+=pricePerItem;
            }
        }else if(fromAddItem ==false && totalPrice>0){
            System.out.println("The Total price payable is KSHS: "+totalPrice+"");
            System.out.print("Enter the amount paid: ");
            double amountPaid = myScanner.nextDouble();
            if(amountPaid > totalPrice){
                change = amountPaid-totalPrice;
                // customerAmount=amountPaid;
            }else{
                // prompt the user to enter the full amount perpetually
                while(amountPaid<totalPrice){
                    System.out.print("Kindly enter pay a value equal to KSHS: "+totalPrice);
                    amountPaid=myScanner.nextDouble();
                }
            }
            showMenu();
        }else{            
            System.out.println("******************************");
            System.out.println("Kindly add an item first");
            System.out.println("******************************");
            showMenu();
        }
        
        
        // showMenu();
    }
    private void addItem() {
        System.out.print("How many items do you want to enter: ");
        int n_items=myScanner.nextInt();
        myScanner.nextLine();
        Items[] items= new Items[n_items];
        for(int i=0;i<n_items;i++){
            System.out.print("Enter the item Name "+(i+1)+": ");
            String itemName=myScanner.nextLine();
            System.out.print("Enter the item Code "+(i+1)+": ");
            int itemCode=myScanner.nextInt();
            System.out.print("Enter the item Quantity "+(i+1)+": ");
            int quantity=myScanner.nextInt();
            System.out.print("Enter the item Price "+(i+1)+": ");
            int unitPrice=myScanner.nextInt();
            myScanner.nextLine();
            double totalPrice=(double)quantity*(double)unitPrice;
            Items item = new Items(itemName,itemCode, quantity, unitPrice,totalPrice);
            items[i]=item;
        }
        
        // set the item object
        this_items=items;
        // set the number of items
        no_items=n_items;
        System.out.println("******************************");
        System.out.println("Item has been added successfuly");
        System.out.println("******************************");
        // close the scanner
        makePayment(true,items,n_items);        
        showMenu();        
        
           
        
             
    }
    public static void main(String[] args) {
        // Scanner myscanner= new Scanner(System.in);
        PointOfSale pos = new PointOfSale();
        pos.userLogin();

        // myscanner.close();
        
    }
}
