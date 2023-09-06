package com.systechafrica.part2;

import com.systechafrica.part2.Person;
import com.systechafrica.part2.lms.Book;
public class AccessModifiersDemo {
    public static void main(String[] args) {
        // Person person= new Person();

        // person.name="Martin";
        // person.email="martinmaati@gmail.com";
        // person.printPersonalDetails();
    }
    public void acessDefault(){
        Book book = new Book();
        // book.isbn="534335454534"; 
        // we can not access the above because the default modifier is paackage private

    }
}
