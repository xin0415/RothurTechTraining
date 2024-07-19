package org.example.day2;

public class Test3 {
    public static void main(String[] args) {
        AA obj=new CC();
        obj.method();       // A   = A.method()     don't do this way, method is static method
    }
}
class AA{
    public static void method(){
        System.out.println("A");
    }
}
class BB extends AA{
    public static void method(){
        System.out.println("B");
    }
}
class  CC extends BB{}