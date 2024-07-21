package org.example.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {
    /*
    *   1. intermediate operation returns a stream. It is lazy
    *   2. terminal operation return normal data type. It is eager
    *   3. stream is thread safe. it is function programing, it can apply a lot of logic at once
    *
    * */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 2, 4, 5));  // 2 3 4 5 3 5 6 -> even 2 4 6
        List<Integer> res = list.stream().map(e -> e + 1).filter(e -> e % 2 == 0).collect(Collectors.toList());
        System.out.println(res);        //2,4,6

        Character[] array = new Character[] {'a', 'a', 'b', 'c'};
        Map<Character, Integer> map = Arrays.stream(array).collect(Collectors.toMap(c -> c, c-> 1, (a, b)-> a+b));
        System.out.println(map);
        map.forEach((a,b)->System.out.println(a+" "+b));
        Map<Character, Integer> map2 = Arrays.stream(array).collect(Collectors.groupingBy(c-> c, Collectors.summingInt(e -> 1)));
        System.out.println(map2);
    }
}
