package org.example.day3;

import java.util.Set;
import java.util.TreeSet;

public class Java8Test {
    /*
     *  java.util.function
     *
     *  Supplier <T>    T get();    // return T (generic type)
     *
     *  Consumer <T>    void accept(T t);
     *
     *  Predicate <T>   boolean test(T t);
     *
     *  Function <T, R>     R apply(T t);
     *  // T is for input, R is for output
     */
/*
*   1.  
*   2.
*
* */
    public static void main(String[] args) {
        Workout wk=()->{
            System.out.println("Hello World, working today");
        };
        wk.work();

        Set<Integer> tr = new TreeSet<>((a, b) -> b - a);
    }
}
interface Workout{
    void work();
}
@FunctionalInterface    // optional
interface Drawable{
    public void draw();
    public default void drawCircle(){
        System.out.println("drawing a circle");
    }
    public static void test1(){
        System.out.println("testing");
    }
}