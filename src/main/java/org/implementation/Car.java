package org.implementation;

public class Car extends Vehicle{
    Integer carryWeight;

    public Car(int vehicleId, String name, double km, Owner owner, Integer carryWeight) {
        super(vehicleId, name, km, owner);

        this.carryWeight = carryWeight;
    }
}
