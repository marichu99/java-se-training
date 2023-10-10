package com.systechafrica.part2.lms;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean available;
    
   public Book() {
   }
   public Book(String isbn, String title, String author, boolean available) {
      this.isbn = isbn;
      this.title = title;
      this.author = author;
      this.available = available;
   }
   public String getIsbn() {
      return isbn;
   }
   public void setIsbn(String isbn) {
      this.isbn = isbn;
   }
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getAuthor() {
      return author;
   }
   public void setAuthor(String author) {
      this.author = author;
   }
   public boolean isAvailable() {
      return available;
   }
   public void setAvailable(boolean available) {
      this.available = available;
   }
         
}
