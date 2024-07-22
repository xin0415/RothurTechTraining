package org.example.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest2 {
    public static void main(String[] args) {
        List<Student> list=new ArrayList<Student>();
        list.add(new Student("Abc",15,30));
        list.add(new Student("Abcaa",17,31));
        list.add(new Student("bcc",18,32));
        list.add(new Student("caa",19,33));
        list.add(new Student("AAAAbc",21,34));
        list.add(new Student("CCCbc",21,35));
        List<Student> startA=list.stream().filter(s->s.name.charAt(0)=='A').collect(Collectors.toList());
        for(Student s:startA){
            System.out.println(s.name+":"+s.age);
        }
        int score=list.stream().map(s ->s.score).mapToInt(Integer::intValue).sum();
        System.out.println(score);
        List<String> string=list.stream().map(s ->s.name).collect(Collectors.toList());
        System.out.println(string);
        Map<Integer,Integer> map=list.stream().collect(Collectors.toMap(s->s.age,age->1,(a,b)->a+b));
        System.out.println(map);
    }
}
class Student{
    String name;
    int age;
    int score;
    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
    public int getAge(){
        return age;
    }
}
