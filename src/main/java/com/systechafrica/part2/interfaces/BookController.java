package com.systechafrica.part2.interfaces;

public interface BookController {
    Book createBook(Book book);
    Book findBook(Book book);
    Book updateBook(Book book);
    void deleteBook(String isbn);
}
