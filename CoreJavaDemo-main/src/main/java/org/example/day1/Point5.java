package org.example.day1;

import java.util.Objects;

class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x && y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
public class Point5 {
    public static void main(String[] args) {
        Node n1 = new Node(1, 1);
        Node n2 = new Node(1, 11);
        System.out.println(n1 == n2);       // false

        /* equals from Object:
             public boolean equals(Object obj) {
                return (this == obj);
            }
        */
        /*
            hashcode from Object:
                @IntrinsicCandidate
                public native int hashCode();
         */

        // false   if not override equals method in Node class, will trigger Object equals method
        // true,   if override
        System.out.println(n1.equals(n2));
    }
}
