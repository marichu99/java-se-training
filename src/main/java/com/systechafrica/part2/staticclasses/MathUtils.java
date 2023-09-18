package com.systechafrica.part2.staticclasses;

public class MathUtils {
    public static class Calculator{
        public static int add(int a, int b){
            return a+b;
        }
        public static int multiply(int a, int b){
            return a*b;
        }
    }
    public static class AreaMath extends Calculator{
        public static int areaCalc(int a, int b){
            return multiply(a, b);
        }
    }    
}
