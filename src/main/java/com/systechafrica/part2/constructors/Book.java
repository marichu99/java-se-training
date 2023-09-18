package com.systechafrica.part2.constructors;

public class Book{
    private String isbn;
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    private String title;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private boolean avaiable;

    public boolean isAvaiable() {
        return avaiable;
    }

    public void setAvaiable(boolean avaiable) {
        this.avaiable = avaiable;
    }

    public Book(String isbn, String title, boolean available){
        this.isbn = isbn;
        this.title= title;
        this.avaiable=available;
    }

}