package org.example.day3;

import java.util.Arrays;

public class GenerticsTest {
    /*
    *   1. always need to pass class because data erase. When the java compile code, it will compile into Object data type. Integer, String, ... can cast into Object type. int, double cannot be object type
    *   2. <?>,<A extends B>, <B super A> can put into generics
    *   3. int[] is from Object class, so int[][] would work
    *
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

