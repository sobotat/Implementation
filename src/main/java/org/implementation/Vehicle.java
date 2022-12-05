package org.implementation;

public class Vehicle {

    public int vehicleId;
    public String name;
    public double km;
    public Owner owner;
    public String type;

    public Vehicle(int vehicleId, String name, double km, Owner owner, String type) {
        this.vehicleId = vehicleId;
        this.name = name;
        this.km = km;
        this.owner = owner;
        this.type = type;
    }
}
