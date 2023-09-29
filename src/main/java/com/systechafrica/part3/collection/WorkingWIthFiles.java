package com.systechafrica.part3.collection;

import java.io.File;
import java.time.Instant;

public class WorkingWIthFiles {
    
    public static void main(String[] args) {
        String absoluteath ="C:\\Users\\Martin\\Documents\\Martin's Stuff\\Projects\\SYSTECH\\JAVA TRAINING\\java-se-training";
        String relativePath ="src\\main\\java\\com\\systechafrica\\part3\\collection\\WorkingWIthFiles.java";

        System.out.println("file.separator");
        File logFile = new File("log.txt");
        System.out.println(logFile.exists()); //check if the log file exists
        System.out.println(logFile.isFile());
        System.out.println(logFile.isDirectory());
        System.out.println(Instant.ofEpochMilli(logFile.lastModified()));

        
    }
    
}
