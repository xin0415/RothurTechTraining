package org.example.day2;

public class Test2 {
    public static void main(String[] args) {
        A obj=new C();
        obj.method();       // B
        B o=new C();
        o.method();         // B
        C c=new C();
        c.method();         // B
//        C co=new A();     // error, child cannot convert to parent
    }

}
class A{
    public void method(){
        System.out.println("A");
    }
}
class B extends A{
    @Override
    public void method(){
        System.out.println("B");
    }
}
class  C extends B{}