package com.systechafrica.part3.generics;

public class MaizeFlour {
    private int quantity;    
    private int code;
    private String name;
    
    public MaizeFlour(int quantity, int code, String name) {
        this.quantity = quantity;
        this.code = code;
        this.name = name;
    }
    
    public MaizeFlour() {
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
}
