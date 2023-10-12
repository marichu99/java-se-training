package com.systechafrica.part4.utildates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
public class ListDemo {
    public static void main(String[] args) {
        // List<Integer> numbers = List.of(12,23,34,45,56);

        // Stream<> numberStream = numbers.stream()
        //                         .filter(number -> number %2==0)
        //                         .map(number -> number*number)

        List<String> listVal =Arrays.asList("John","Mabera","Lena","Joy");
       double thisStream = listVal.stream().filter(x->x.length()>3).count();
    //    listVal.stream().filter()
    List<Integer> list = Arrays.asList(10,4,-1,5);
    Collections.sort(list);
    Integer array[]= list.toArray(new Integer[4]);
    System.out.println(array[0]);
    }
}
