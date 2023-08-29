package com.systechafrica.stringsandstringbuilders;

public class Student {

    private String firstname;
    private String lastname;
    private String email;
    private String registration;
    
    public String getFullDetails(){
        StringBuilder sb = new StringBuilder(100);
        sb.append(firstname);
        sb.append(""+lastname);
        sb.append(""+email);
        sb.append(""+registration);

        return sb.toString();

    }
    public static void main(String[] args){

    }
    
}
