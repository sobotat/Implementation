package org.implementation;

public class Motorcycle extends Vehicle{
    public String category;

    public Motorcycle(int vehicleId, String name, double km, Owner owner, String category) {
        super(vehicleId, name, km, owner, "Motorcycle");

        this.category =category;
    }

    @Override
    public String toString(){
        return "Motorcycle: " + vehicleId + " " + name + " ["+ km +"] " + owner + " -> " + category;
    }
}
