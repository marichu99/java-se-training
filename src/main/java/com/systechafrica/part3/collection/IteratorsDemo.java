package com.systechafrica.part3.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class IteratorsDemo {
    public static void main(String[] args) {
        Set<Student> student = new HashSet<>();
        List<String> maberaNickNames = new ArrayList<>();
        maberaNickNames.add("Mhusika");
        maberaNickNames.add("Mabera");
        maberaNickNames.add("Maati");
        maberaNickNames.add("Matooo");
        maberaNickNames.add("Marichu");

        Iterator<String> iterator = maberaNickNames.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    
}
