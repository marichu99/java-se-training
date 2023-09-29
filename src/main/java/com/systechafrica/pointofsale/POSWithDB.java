package com.systechafrica.pointofsale;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import com.systechafrica.part3.exceptionhandling.MyCustomExpception;
import com.systechafrica.part3.logging.CustomFormatter;
import com.systechafrica.util.ValidateInput;

public class POSWithDB {

    // private final String PASSWORD="Admin123";
    private final int NO_TRIALS=3;
    private double totalPrice=0.0;
    private double pricePerItem=0.0;
    private double change=0.0;
    private List<Item> thisItems=null; 
    private int noItems=0;
    private double customerAmount=0.0;
    private String dbPassword;
    private Scanner myScanner = new Scanner(System.in);


    private static final Logger LOGGER = Logger.getLogger(POSWithDB.class.getName());
    // function to login the user
    public void userLogin() throws MyCustomExpception{   
        // we will use the userDBPractice because it implements an interface that has outlined most of the DB methods
        UserDBPractice db = new UserDBPractice();   
        // this functionality below is used to add a new user to the database
        System.out.print("Enter your user name: ");
        String inputUserName = myScanner.nextLine();
        // request for the credentials           
        System.out.print("Enter your password: ");
        String inputPass=myScanner.nextLine();        
        // push this data to the db
        String insertQuery = "INSERT INTO users(user_name,password) VALUES('"+inputUserName+"','"+inputPass+"');";
        int noInsertedRecords = db.executeUpdate(insertQuery);  
        // if we have inserted the record then we can now login
        if(noInsertedRecords >0){
            System.out.println("*************************************");
            LOGGER.severe("You have successfully made an account");
            System.out.println("*************************************");
            System.out.println("Kindly enter your password "+inputUserName);
            // let us retrieve the password of the username
            String selectPassQuery = "SELECT password FROM users WHERE user_name = '"+inputUserName+"'";
            ResultSet passResult = db.exequteQuery(selectPassQuery);
            try {
                if(passResult.next()){                    
                    dbPassword = passResult.getString("password");
                }
            } catch (SQLException e) {
                LOGGER.severe("The SQL Exception is "+e.getMessage());
            }
            for(int i=0;i<=NO_TRIALS+1;i++){        
                if(i<=3){                    
                    // lets ask the user for the password
                    System.out.print("Enter your password: ");
                    String inputPassword = myScanner.nextLine();
                    if(ValidateInput.validate(inputPassword).equals(dbPassword)){
                        System.out.println("Welcome to the System");
                        showMenu();
                        break;
                    }else{
                        LOGGER.severe("Invalid Login please try again, you have "+(NO_TRIALS-i)+" trials left");
                    }
                }else{
                    throw new MyCustomExpception("You have maxed out your trials");
                }
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
        System.out.println("4. Get purchases");
        System.out.print("Choose an option [1-4] :");

        int chosenInput= myScanner.nextInt();
        try {
            takeInput(chosenInput);
        } catch (MyCustomExpception e) {
            // TODO Auto-generated catch block
            LOGGER.severe("The Exception is "+e.getMessage());
        }

    }
    private void displayReceipt() {
        
        if(thisItems == null){
            // if someone wants to show receipt without selecting any items, the thisItems object would be null
            System.out.println("******************************");
            System.out.println("Kindly add an item first");
            System.out.println("******************************");
            showMenu();
        // if someine wants to show a receipt without paying, the customerAmount variable would ideally be zero as specified in the makePayment() function 
        }else if(!(customerAmount>0)){
            System.out.println("******************************");
            System.out.println("Kindly make payment first");
            System.out.println("******************************");
            showMenu();
        }else{
            System.out.println("Item Code   Quantity   Unit Price   TotalValue");
            // I set noItems as a global variable and thi_items too, which tracks the items that were set during the adding of an item
            for(int i=0;i<noItems;i++){
                System.out.println(thisItems.get(i).getItemCode()+"              "+thisItems.get(i).getQuantity()+"           "+thisItems.get(i).getUnitPrice()+"                 "+thisItems.get(i).getTotalPrices());
            }
            System.out.println("*******************************************************************");
            System.out.println("Total:      "+totalPrice);
            System.out.println("*******************************************************************");
            System.out.println("Enter the total Amount given by the customer: "+customerAmount);
            System.out.println("Change:     "+change);
            System.out.println("*******************************************************************");
            System.out.println("THANK YOU FOR SHOPPING WITH US");
            System.out.println("*******************************************************************");     
            showMenu();       
        }
    }
    public void displayPurchases(){
        ItemDB db = new ItemDB();
        String query = "SELECT * FROM items";
        ResultSet resultSet = db.exequteQuery(query);
        try {
            while(resultSet.next()){
                System.out.println(resultSet.getString("item_name")+"=>"+resultSet.getString("item_price")+"=>"+resultSet.getString("item_quantity"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            LOGGER.severe("The SQL Exception is "+e.getMessage());
        }
    }

    private void takeInput(int chosenInput) throws MyCustomExpception{
        try{
            if(ValidateInput.validateInt(chosenInput) == 1){
                addItem();
            }else if(ValidateInput.validateInt(chosenInput) ==2){
                makePayment(false,null,0);
            }else if(ValidateInput.validateInt(chosenInput) == 3){
                displayReceipt();
            }else if(ValidateInput.validateInt(chosenInput) == 4){
                displayPurchases();       
            }else{
                System.out.println("*************************************");
                System.out.println("Invalid choice, choose another option");
                showMenu();
            }
        }catch(InputMismatchException e){
            LOGGER.severe("Kindly enter a numerical value");
        }
    }
    // }
    private void makePayment(boolean fromAddItem,List<Item> items,int nItems) {
        // set the total price variable
        if(nItems>0 && fromAddItem == true){            
            // get the length of the array
            for(int i=0;i<nItems;i++){
                pricePerItem=(items.get(i).getUnitPrice()*items.get(i).getQuantity());
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
        ItemDB db = new ItemDB();
        // lets come up with a prepared statement that will take in user multi-input
        String insertQuery = "INSERT INTO items(item_name,item_price,item_quantity) VALUES(?,?,?);";
        int affectedRows =db.prepare(insertQuery,myScanner);

        // lets get all the items through the global variable madeItems in the ItemDB class
        List<Item> madeItems = db.getMadeItems();

        // set the item object
        thisItems=madeItems;
        // set the number of items
        noItems=affectedRows;
        System.out.println("******************************");
        System.out.println("Item has been added successfuly");
        System.out.println("******************************");
        // close the scanner
        makePayment(true,thisItems,affectedRows);        
        showMenu();   
        
           
        
             
    }
    // method to get the added item from another class
    public Item getItem(Item item){
        return item;
    }
    public static void main(String[] args) {
        // Scanner myscanner= new Scanner(System.in);
        POSWithDB pos = new POSWithDB();
        FileHandler fileHandler;
        try {
            fileHandler = new FileHandler("log.txt");
            CustomFormatter formatter = new CustomFormatter();
            LOGGER.addHandler(fileHandler);
            fileHandler.setFormatter(formatter);
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            LOGGER.severe("The Security Exception is "+e.getMessage());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            LOGGER.severe("The IOException is "+e.getMessage());
        }
        
        try {
            pos.userLogin();
        } catch (MyCustomExpception e) {
            LOGGER.severe    ("The custom exception is "+e.getMessage());
        }

        // myscanner.close();
        /* 
         * 1. Create a reviewed ammendment of your POS system
         * 2. Handle exceptions of your user Input using custom exceptions classes
         * 3. Connect to the database
         * 4. Log to the file(log.txt) using date time |level|method|message|exception
         * 
         */
        
    }
 
 
   
    
    
}
