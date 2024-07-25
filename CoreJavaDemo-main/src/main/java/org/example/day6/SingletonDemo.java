package org.example.day6;



public class SingletonDemo {
    public static void main(String[] args) {

    }
}

// eager loading
class Singleton1 {
    private static final Singleton1 instnace = new Singleton1();
    private Singleton1() {

    }
    public static Singleton1 getInstance() {
        return instnace;
    }
}

// lazy loading, double check locking
class Singleton2 {
    // volatile to prevent instruction reorder
    private static volatile Singleton2 instance;

    private Singleton2() {}

    public static Singleton2 getInstance() {
        // if doesn't have this if loop, the thread will lock whole object
        if (instance == null) {
            synchronized(Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                    // 1 create instance reference          Singletons instance;
                    // 2 new singleton();
                    // 3 instance reference points to instance object,      point instance reference to new singleton()
                    // 1 -> 2 ->  3
                    // 1 -> 3 ->  2
                    // CPU will do execute reorder. if 1->3->2 happen, instance already got reference, but the object is not created yet, it causes the issue
                    // used volatile to prevent CPU reorder, it must always do 1->2->3
                }
            }
        }
        return instance;
    }
}

