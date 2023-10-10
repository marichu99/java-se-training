package com.systechafrica.test;

public class Test2 {

    int x;
    int y;

    public void doStuffy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void display () {
        System.out.print(x + " " + y + " : ");
    }

    public static void main(String[] args) {

        Test2 m1 = new Test2 ();
        m1.x = 100;
        m1.y = 200;
        Test2 m2 = new Test2();
        m2.doStuffy(100, 200);
        m1.display();
        m2.display();

    }
}

