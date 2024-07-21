package org.example.day3;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.Function;

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
    public static void main(String[] args) throws Throwable {
        Workout wk=()->{
            System.out.println("Hello World, working today");
        };
        wk.work();

        Set<Integer> tr = new TreeSet<>((a, b) -> b - a);

        System.out.println("-------------------- Testing Function-------------------");
        BiFunction<Integer, Integer, Integer> myAdd = (a, b) -> a + b;
        System.out.println(myAdd.apply(1, 2));  //3

        Function<Integer, Integer> addOne = a -> a + 1;
        System.out.println(addOne.apply(4));    //5

        System.out.println("--------------------Testing Optional-----------------------");
        String[] array = new String[2];
        String[] array2 = new String[]{"abc", "tyu"};
//        if (array[0] == null) {
//
//            throw new IllegalArgumentException("the value is null");
//        } else {
//            System.out.println(array[0]);
//        }
        Optional opt = Optional.ofNullable(array[0]);
        System.out.println(opt.orElse("the value is null"));
        opt.orElseThrow(() -> new IllegalArgumentException("the value is null"));
        Optional opt2 = Optional.ofNullable(array2[0]);
        System.out.println(opt2.orElse("the value is null"));       // will print out "abc"
    }
    public static int add(int[] array){
//        if(array==null){
//            System.out.println("array is null");
//            throw new IllegalArgumentException("input is not valid");
//        }
        Optional opt= Optional.ofNullable(array);
        int sum=0;
        for(int i=0;i<array.length;i++){
            sum+=array[i];
        }
        return sum;
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