package com.systechafrica.part3.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class WorkingWithMaps {
    public static void main(String[] args) {
        // Map<KT,VT> map;
        List<String> maberaNickNames = new ArrayList<>();
        maberaNickNames.add("Mhusika");
        maberaNickNames.add("Mabera");
        maberaNickNames.add("Maati");
        maberaNickNames.add("Matooo");
        maberaNickNames.add("Marichu");

        List<String> tashaNickNames = new ArrayList<>();
        tashaNickNames.add("Dasha");
        tashaNickNames.add("Dasha Dasha");
        tashaNickNames.add("rada rada");
        
        // now let us use a map to store an array of key value pairs
        Map<String,String> students = new HashMap<>();
        Map<String,List<String>> studentMap =new HashMap<>();

        studentMap.put("mabera",maberaNickNames);
        studentMap.put("tasha", tashaNickNames);

        // loop throught the hashmap
        Set<Entry<String, List<String>>> entrySet = studentMap.entrySet();
        Set<String> keySet = studentMap.keySet();

        for(Entry<String, List<String>> record:entrySet){
            System.out.println(record.getKey() +" => "+record.getValue());
        }

    }    
}
