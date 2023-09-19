package com.systechafrica.part2.interfaces;

public class InterfcaeDemo {

    public static void main(String[] args) {
        ThreePinPlug mc = new MobileCharger();
        ThreePinPlug lc = new CookerCharger();
        CalculateArea sq = new Square();
        BookController bc = new BookControllerImpl();
        Book thisBook =  new Book("122", "45212", "dostoyevsky", "Mabera");

        Book createdBook = bc.createBook(thisBook);
        System.out.println(createdBook);
        

        lc.plugIn();
        lc.plugOut();

        mc.plugIn();
        mc.plugOut();

        sq.calculateArea(5, 7);
    }    
}
