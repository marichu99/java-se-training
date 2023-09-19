package com.systechafrica.part2.interfaces;

public class BookControllerImpl implements BookController {

    @Override
    public Book createBook(Book book) {
        book.setId("12");
        book.setBookAuthor("Mabera");
        book.setBookName("Dostoyevsky");
        book.setIsbn("11224455");
        return book;
    }

    @Override
    public void deleteBook(String isbn) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Book findBook(Book book) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Book updateBook(Book book) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
