package org.implementation;

public class Car extends Vehicle{
    public Integer carryWeight;

    public Car(int vehicleId, String name, double km, Owner owner, Integer carryWeight) {
        super(vehicleId, name, km, owner, "Car");

        this.carryWeight = carryWeight;
    }

    @Override
    public String toString(){
        return super.toString() + " -> " + carryWeight;
    }
}
