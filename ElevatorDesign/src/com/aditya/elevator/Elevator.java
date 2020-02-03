package com.aditya.elevator;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.aditya.elevator.Direction.*;

public class Elevator {
    private static final int MAX_CAPACITY = 10;
    private static final int BUILDING_SIZE=15;
    private int currentFloor;
    private List<Integer> targetFloors = new ArrayList<Integer>();
    private Direction direction;
    static int NumberOfPersons=0;
    static int maxFloor=0;

    public Elevator(int currentFloor,Direction direction) {
        this.currentFloor = currentFloor;
        this.direction=direction;
    }

    public boolean addFloor(int floor)
    {
        if(floor> BUILDING_SIZE)
        {
            System.out.println("Enter a valid Floor !!");
            return false;
        }
        if(floor>maxFloor)
        {
            maxFloor=floor;
        }
        if(floor>currentFloor && direction==UP) {
            targetFloors.add(floor);
            return true;
        }
        else if(floor<currentFloor && direction==UP) {
            System.out.println("Sorry !! The Elevator is going up");
            return false;
        }

        else if(floor<currentFloor && direction== DOWN) {
            targetFloors.add(floor);
            return true;
        }
        else {
            System.out.println("Sorry !! The Elevator is going down");
            return false;
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public List<Integer> getTargetFloors() {
        return targetFloors;
    }

    public static int getMaxNumberOfPersons() {
        return NumberOfPersons;
    }

    public void enter()
    {
        if(NumberOfPersons> MAX_CAPACITY)
        {
            System.out.println("Elevator Capacity Exceeds");
            return;
        }
        NumberOfPersons++;
    }

    public void exit()
    {
        NumberOfPersons--;
    }

    public static int getMaxCapacity() {
        return MAX_CAPACITY;
    }

    public static int getBuildingSize() {
        return BUILDING_SIZE;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setTargetFloors(List<Integer> targetFloors) {
        this.targetFloors = targetFloors;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public static void setMaxNumberOfPersons(int maxNumberOfPersons) {
        NumberOfPersons = maxNumberOfPersons;
    }

    public static int getMaxFloor() {
        return maxFloor;
    }

    public static void setMaxFloor(int maxFloor) {
        Elevator.maxFloor = maxFloor;
    }


    @Override
    public String toString() {
        return "Elevator{" +
                "currentFloor=" + currentFloor +
                ", targetFloors=" + targetFloors +
                ", direction=" + direction +
                ", Number of Persons=" + NumberOfPersons +
                '}';
    }

    public void move() {
        for(int i=this.getCurrentFloor();i<=this.maxFloor;i++)
        {
            System.out.println("Floor " + i + " Reached !!");
            this.targetFloors.remove(Integer.valueOf(i));
            this.setCurrentFloor(i);
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        this.setMaxNumberOfPersons(0);
    }
}
