package com.systechafrica.part2.interfaces;

public class User {
    private String id;
    public void setId(String id){
        this.id=id;
    }
    public String getId() {
        return id;
    }
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
