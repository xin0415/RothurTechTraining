package org.example.day1;

public class DefaultInterfaceDemo {
    public static void main(String[] args) {
        Car car = new Car();
        car.startEngine(); // This will call the default method
        car.move(); // This will call the overridden method
        //Starting the engine.
        //Car is moving.
    }
}
interface Vehicle {
    // Abstract method
    void move();

    // Default method
    default void startEngine() {
        System.out.println("Starting the engine.");
    }
}
class Car implements Vehicle {
    @Override
    public void move() {
        System.out.println("Car is moving.");
    }
}

