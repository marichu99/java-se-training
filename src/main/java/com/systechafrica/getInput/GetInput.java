package com.systechafrica.getInput;

import java.util.Scanner;
import java.util.logging.Logger;

public class GetInput {
    public static final Logger LOGGER=Logger.getLogger(GetInput.class.getName());

    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);

        final String DB_USERNAME="mabera";
        final String DB_PASSWORD="Admin123";
        System.out.print("Enter your username: ");
        String username= myScanner.nextLine();

        System.out.print("Enter your password: ");
        String password= myScanner.nextLine();

        if(username.equals(DB_USERNAME) && password.equals(DB_PASSWORD)){
            System.out.println("Welcome back Mabera");
        }else{
            System.err.println("incorrect username or password");
        }
        myScanner.close();
    }
    
}
