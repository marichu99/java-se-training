package com.systechafrica.part2.interfaces;

public class Book {
    private String id;
    private String isbn;
    private String bookName;
    private String bookAuthor;
    
    public Book(String id, String isbn, String bookName, String bookAuthor) {
        this.id = id;
        this.isbn = isbn;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getBookAuthor() {
        return bookAuthor;
    }
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
    
}
