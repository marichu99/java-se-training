package com.systechafrica.test;

import java.util.ArrayList;

public class Test {

    static int count = 0;
    int i =0;

    public void changeCount(){
        while (i < 5){
            i++;
            count++;
        }
    }
  
   public static void main(String[] args) {
       Test check1=new Test();
       Test check2 = new Test();

       check1.changeCount();
       check2.changeCount();

       

       int x =100;
       int a =x++;
       int b=++x;
       int c=x++;
       int d =(a<b)?(a<c)?a:(b<c)?b:c:x;
       System.out.println(d);

       System.out.println(args[0]);
    } 
}
