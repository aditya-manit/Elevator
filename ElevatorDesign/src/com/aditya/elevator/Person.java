package com.aditya.elevator;

import java.util.Objects;

public class Person {
    private String name;


    public Person(String name) {
        this.name = name;
    }

    public static void EnterElevator(Elevator elevator, String name, int floor) {
        Person ram = new Person(name);
        if(Objects.equals(elevator.addFloor(floor), true))
        elevator.enter();
    }
}
