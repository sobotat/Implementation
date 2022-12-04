package org.implementation;

public class Motorcycle extends Vehicle{
    String category;

    public Motorcycle(int vehicleId, String name, double km, Owner owner, String category) {
        super(vehicleId, name, km, owner);

        this.category =category;
    }
}
