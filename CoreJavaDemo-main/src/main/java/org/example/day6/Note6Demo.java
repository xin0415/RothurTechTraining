package org.example.day6;

public class Note6Demo {
    public static void main(String[] args) {
        // builder design pattern
        Department d = Department.builder().setName("Java").setId(1).build();
        // factory design pattern
        PhoneFactory factory = new PhoneFactory();
        Phone iphone = factory.getPhone("iphone");
        Phone sony = factory.getPhone("sony");
    }
}
