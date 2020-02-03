package com.aditya.elevator;

import static com.aditya.elevator.Direction.*;
import static com.aditya.elevator.Person.EnterElevator;

public class ElevatorApplication {

    public static void main(String[] args) {

        Elevator elevator=new Elevator(0,UP);
        System.out.println(elevator);



        EnterElevator(elevator, "Ram", 2);
        EnterElevator(elevator, "Ravan", 9);
        EnterElevator(elevator, "sita", -2);


        System.out.println(elevator);

        elevator.move();

        System.out.println(elevator);

    }


}
