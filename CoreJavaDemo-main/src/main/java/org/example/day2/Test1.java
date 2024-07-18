package org.example.day2;

public class Test1 {
    static int i;       // static field will be initialized in initial phrase during class loading
    public static void main(String[] args) {
        int j;      // it won't be initialized
        System.out.println(i);
//        System.out.println(j);
    }
}
