package com.systechafrica.atmmachine;



import com.systechafrica.part3.exceptionhandling.MyCustomExpception;
import  com.systechafrica.util.ValidateInput;
import java.util.Scanner;
import java.util.logging.Logger;

public class ATMMachine {

    public static final Logger LOGGER= Logger.getLogger(ATMMachine.class.getName());
    final String DB_PASSWORD="Admin123";
    final String DB_USERNAME="MABERA";
    int BALANCE=1000;
        public void runprogram(){
            Scanner myScanner = new Scanner(System.in);         
          
            // authenticate the credentials
            for(int counter =0;counter<3;counter++){
                // login funtion
                // get the username
                System.out.print("Enter your username: ");
                String username= myScanner.nextLine();
                // get the password
                System.out.print("Enter your password: ");
                String password=myScanner.nextLine();
                try {
                    if(ValidateInput.validate(password).equals("valid")){
                        if((username.equals(DB_USERNAME) && password.equals(DB_PASSWORD)) && counter <3){
                            showMenu();
                            break;
                        }else if((username.equals(DB_USERNAME) && password.equals(DB_PASSWORD)) == false && counter<3){
                            System.out.println("You have used "+(counter+1)+" of 3 attempts");
                        }else{
                            System.out.println("You have exhausted your attempts");
                            System.exit(0);
                        }
                        }else{
                            System.err.println("Invalid input");
                        }
                } catch (MyCustomExpception e) {
                    // TODO Auto-generated catch block
                    System.out.println("The Custom Exception is "+e.getMessage());
                }
            }
            myScanner.close();
        }
    public int takeInput(int chosenInput) {
        Scanner userSelection = new Scanner(System.in);

        if(chosenInput == 1){
            System.out.println("You have a balance of "+BALANCE);
            // Thread.sleep(100);
            showMenu();
        }else if(chosenInput == 2){
            System.out.print("Kindly enter the amount you would want to deposit: ");
            int depositedAmount = userSelection.nextInt();
            BALANCE=BALANCE+depositedAmount;
            System.out.println("Your Current balance is KSHS "+BALANCE+" thank you for banking with us");
            // Thread.sleep(100);
            showMenu();
        }else if(chosenInput == 3){
            System.out.print("Kindly enter the amount to be withdrawn: ");
            int withdrawnAmount= userSelection.nextInt();
            // calculate amount to deduct from the account (amount + withdrawing cost)
            double amount_toDeduct=withdrawnAmount+(0.02*withdrawnAmount);
            // check if the deduction is greater than the balance
            if(BALANCE<amount_toDeduct){
                System.out.println("You have insufficient balance, kindly select a figure lower than "+BALANCE);
            }else{
                BALANCE=BALANCE-(int)amount_toDeduct;
                System.out.println("You have successfully withdrawn KSHS "+withdrawnAmount+" your current balance is KSHS "+BALANCE+", Transaction Cost KSHS "+(0.02*withdrawnAmount));
            }
            // Thread.sleep(100);
            showMenu();
        }else if(chosenInput == 4){
            System.out.println("You have a balance of "+BALANCE);
            // Thread.sleep(100);
            showMenu();
        }else if(chosenInput == 5){
            System.out.println("Thank you for banking with us");
            // Thread.sleep(100);
            System.exit(0);
        }else{
            System.out.println("Please select another option");
            
            showMenu();
            
        }
        userSelection.close();
        return (0);
        
    }
    public void showMenu() {
        System.out.println("****************************");
        System.out.println("");
        System.out.println("ATM SIMULATOR");
        System.out.println("****************************");
        System.out.println("");
        System.out.println("ATM SERVICES");
        System.out.println("");
        System.out.println("___________________________________");
        System.out.println("");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer Cash");
        System.out.println("5. Quit");
        System.out.println("****************************");
        System.out.println("");
        System.out.print("Choose your option: ");

        Scanner inputOption= new Scanner(System.in);
        int chosenInput =inputOption.nextInt();
        takeInput(chosenInput);
        inputOption.close();
    }
     
    public static void main(String[] args){
        ATMMachine app = new ATMMachine();
        app.runprogram();
    }
}
