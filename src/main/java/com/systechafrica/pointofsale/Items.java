package com.systechafrica.pointofsale;


public class Items {
    private int itemCode;
    private int quantity;
    private double unitPrice;
    private String itemName;
    private Object[] items;
    private double prices;
    public Items(){

    }
    public Items(String itemName, int itemCode, int quantity, int unitPrice, double prices){
        this.itemName=itemName;
        this.itemCode=itemCode;
        this.quantity=quantity;
        this.unitPrice=unitPrice;
        this.prices=prices;
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
    public void setPrices(double prices){
        this.prices=prices;
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
    public double getTotalPrices(){
        return prices;
    }
    
}
