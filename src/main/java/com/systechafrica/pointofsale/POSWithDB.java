package com.systechafrica.pointofsale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.systechafrica.part3.exceptionhandling.MyCustomExpception;

public class POSWithDB implements ItemController{

    private final String PASSWORD="Admin123";
    private final int NO_TRIALS=3;
    private double totalPrice=0.0;
    private double pricePerItem=0.0;
    private double change=0.0;
    private Item[] thisItems=null; 
    private int noItems=0;
    private double customerAmount=0.0;
    private Scanner myScanner = new Scanner(System.in);
    // function to login the user
    public void userLogin() throws MyCustomExpception{        
        for(int i=0;i<=NO_TRIALS+1;i++){
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
                    System.out.println("Invalid Login please try again, you have "+(NO_TRIALS-i)+" trials left");
                }
            }else{
                throw new MyCustomExpception("You have maxed out your trials");
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
        
        if(thisItems == null){
            // if someone wants to show receipt without selecting any items, the thisItems object would be null
            System.out.println("******************************");
            System.out.println("Kindly add an item first");
            System.out.println("******************************");
            showMenu();
        // if someine wants to show a receipt without paying, the customerAmount variable would ideally be zero as specified in the makePayment() function 
        }else if((customerAmount>0) == false){
            System.out.println("******************************");
            System.out.println("Kindly make payment first");
            System.out.println("******************************");
            showMenu();
        }else{
            System.out.println("Item Code   Quantity   Unit Price   TotalValue");
            // I set noItems as a global variable and thi_items too, which tracks the items that were set during the adding of an item
            for(int i=0;i<noItems;i++){
                System.out.println(thisItems[i].getItemCode()+"              "+thisItems[i].getQuantity()+"           "+thisItems[i].getUnitPrice()+"                 "+thisItems[i].getTotalPrices());
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
    private void makePayment(boolean fromAddItem,Item[] items,int nItems) {
        // set the total price variable
        if(nItems>0 && fromAddItem == true){            
            // get the length of the array
            for(int i=0;i<nItems;i++){
                pricePerItem=(items[i].getUnitPrice()*items[i].getQuantity());
                totalPrice+=pricePerItem;
            }
        }else if(fromAddItem ==false && totalPrice>0){
            System.out.println("The Total price payable is KSHS: "+totalPrice+"");
            System.out.print("Enter the amount paid: ");
            double amountPaid = myScanner.nextDouble();
            if(amountPaid > totalPrice){
                change = amountPaid-totalPrice;
                customerAmount=amountPaid;
            }else{
                // prompt the user to enter the full amount perpetually
                while(amountPaid<totalPrice){
                    System.out.print("Kindly enter pay a value equal to KSHS: "+totalPrice+": ");
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
        int nItems=myScanner.nextInt();
        myScanner.nextLine();
        Item[] items= new Item[nItems];
        for(int i=0;i<nItems;i++){
            System.out.print("Enter the item Name "+(i+1)+": ");
            String itemName=myScanner.nextLine();
            System.out.print("Enter the item Quantity "+(i+1)+": ");
            int quantity=myScanner.nextInt();
            System.out.print("Enter the item Price "+(i+1)+": ");
            int unitPrice=myScanner.nextInt();
            myScanner.nextLine();
            double totalPrice=(double)quantity*(double)unitPrice;
            // Item item = new Item(itemName, quantity, unitPrice,totalPrice);
            // getItem(item);            
        }
        
        // set the item object
        thisItems=items;
        // set the number of items
        noItems=nItems;
        System.out.println("******************************");
        System.out.println("Item has been added successfuly");
        System.out.println("******************************");
        
        // close the scanner
        makePayment(true,items,nItems);        
        showMenu();    
        
           
        
             
    }
    // method to get the added item from another class
    public Item getItem(Item item){
        return item;
    }
    public static void main(String[] args) {
        // Scanner myscanner= new Scanner(System.in);
        PointOfSale pos = new PointOfSale();
        pos.userLogin();

        // myscanner.close();
        /* 
         * 1. Create a reviewed ammendment of your POS system
         * 2. Handle exceptions of your user Input using custom exceptions classes
         * 3. Connect to the database
         * 4. Log to the file(log.txt) using date time |level|method|message|exception
         * 
         */
        
    }
    @Override
    public void close() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public Connection connect() {
        // TODO Auto-generated method stub
        String url ="jbdc:mysql://localhost:3308/javase";
        String user ="root";
        String password = "root";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("The SQL error is "+e.getMessage());
        }
        return null;        
    }
    @Override
    public Item createItem(Item item) {
        //  we have to look for the scanner to enter the items
        
        // TODO Auto-generated method stub
        return null;
        
    }
    @Override
    public int executeUpdate(String query) {
        try {
            Statement statement = connect().createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
           System.out.println("The SQL exception is "+e.getMessage());
        }
        return 0;
    }
    @Override
    public ResultSet exequteQuery(String query) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public int prepare(String query,Scanner myScanner) {
        // TODO Auto-generated method stub
        try {
            PreparedStatement preparedStatement = connect().prepareStatement(query);
       
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("The SQL exception is: "+e.getMessage());
        }
        return 0;
    }
}
