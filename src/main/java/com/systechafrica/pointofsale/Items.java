package com.systechafrica.pointofsale;

public class Items {
    private int itemCode;
    private int quantity;
    private double unitPrice;
    private String itemName;
    private Object[] items;
    public Items(){

    }
    public Items(int itemCode, int quantity, int unitPrice){
        this.itemCode=itemCode;
        this.quantity=quantity;
        this.unitPrice=unitPrice;
    }
    public void setItemCode(int itemCode){
        this.itemCode=itemCode;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    public void setUnitPrice(double unitPrice){
        this.unitPrice=unitPrice;
    }
    public void setItemName(String itemName){
        this.itemName=itemName;
    }
    public void setItemObject(Object[] items){
        this.items=items;
    }

    public int getItemCode(){
        return itemCode;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getUnitPrice(){
        return unitPrice;
    }
    public String getItemName(){
        return itemName;
    }
    public Object[] getItemObjects(){
        return items;
    }
    
}
