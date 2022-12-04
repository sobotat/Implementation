package org.implementation;

public class Vehicle {

    int vehicleId;
    String name;
    double km;
    Owner owner;

    public Vehicle(int vehicleId, String name, double km, Owner owner) {
        this.vehicleId = vehicleId;
        this.name = name;
        this.km = km;
        this.owner = owner;
    }
}
