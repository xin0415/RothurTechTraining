package org.example.day5;

public class SynchronizedTest {
    /*
    *   1. synchronized method: other thread cannot access the object  -   object level lock
    *   2. synchronized static method will lock the class
    * */
    public static void main(String[] args) {
        MyClass object=new MyClass();
        object.method1();
    }
}
class MyClass {
    public void method() {
        synchronized (MyClass.class) {
            // TODO
        }
    }

    public synchronized void method1() {

    }

    public synchronized static void method2() {

    }

    public void method3(){
        synchronized (this) {

        }
    }
}