package com.systechafrica.part3.inputoutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkingWithFIles {
    public static void main(String[] args) throws IOException{
        workingWithFileStreams();
    }
    private static void workingWithFileStreams() throws IOException{
        String fileSeparator = System.getProperty("file.separator");

        File quoteFile = new File("java-se-traing"+fileSeparator+"quotes.txt");
        if(quoteFile.exists() && quoteFile.isFile()){
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(quoteFile))){
                Scanner myScanner = new Scanner(System.in);
                String line;
                List<String> lines = new ArrayList<>();
                while((line=bufferedReader.readLine())!=null){
                    lines.add(line);
                }
                myScanner.close();
                System.out.print("Enter a number between (1-10): ");
                int quoteIndex = myScanner.nextInt();
                System.out.println(lines.get(quoteIndex-1));

            }catch(IOException e){
                System.out.println(e.getMessage());
            }
            
            

        }
        
    }
}
