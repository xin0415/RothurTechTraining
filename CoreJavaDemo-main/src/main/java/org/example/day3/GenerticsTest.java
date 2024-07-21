package org.example.day3;

import java.util.*;

public class GenerticsTest {
    /*
    *   1. always need to pass class because type erase. When the java compile code, it will compile into Object data type. Integer, String, ... can cast into Object type. int, double cannot be object type
    *   2. <?>,<A extends B>, <B super A> can put into generics
    *   3. int[] is from Object class, so int[][] would work
    *   4. <?> unbounded wildcard. it represents an unknown type and is often used when you want to work with a collection of objects of different type
    *   5. <A extends B> is upper-bounded wildcards. A can be any type that is a subclass of B. This is useful when you want to ensure that a type parameter is a subtype of a particular class
    *   6. <B super A> is lower-bounded wildcards. B can be any type that is superclass of A. This is useful when you want to ensure that a type parameter is a supertype of a particular class
    * */
    public static <E> E getFirstElement(E[] array) {
        return array[0];
    }

    public static void main(String[] args) {
        Node<Integer,String> node1=new Node<>(1,"Bob");
        // Node<Object, Object>
        Node<Double,Character> node2=new Node<>(1.0,'a');
        Integer[] array=new Integer[]{1,2,3};
        Integer a=getFirstElement(array);
        System.out.println(a);
        int[] array2=new int[]{1,2,3};
//        System.out.println(getFirstElement(array2));          // would not work because it cannot cast to object type
        int[][] array3=new int[][]{{1,2},{3,4}};
        System.out.println(getFirstElement(array3));            // printout address because int[] is from Object class
        // int not inherited from Object
        System.out.println(Arrays.toString(getFirstElement(array3)));   // use Arrays.toString to get the result

        System.out.println("-------------use <?>----------------");
        List<String> stringList = List.of("one", "two", "three");
        List<Integer> intList = List.of(1, 2, 3);

        printList(stringList);
        printList(intList);
        //<A extends B>
        System.out.println("-------------use <? extends Number>---------------");
        // the printNumbers method can accept a List of any type that extends Number (including Number itself).
        List<Integer> intList2 = List.of(1, 2, 3);
        List<Double> doubleList = List.of(1.1, 2.2, 3.3);

        printNumbers(intList2);
        printNumbers(doubleList);
        // <B super A>
        System.out.println("-------------use <? super Integer>---------------");
        List<Number> numberList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();

        addNumbers(numberList);
        addNumbers(objectList);

        System.out.println(numberList); // Output: [1, 2, 3]
        System.out.println(objectList); // Output: [1, 2, 3]
    }

    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
    public static void printNumbers(List<? extends Number> list) {
        for (Number number : list) {
            System.out.println(number);
        }
    }
    public static void addNumbers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
    }

}
class Node <K, V> {
    K key;
    V value;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

}

