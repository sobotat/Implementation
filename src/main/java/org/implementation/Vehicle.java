package org.implementation;

public class Vehicle extends DomainObject {

    public String name;
    public double km;
    public Owner owner;
    public String type;

    public Vehicle(int vehicleId, String name, double km, Owner owner, String type) {
        super(vehicleId);
        this.name = name;
        this.km = km;
        this.owner = owner;
        this.type = type;
    }

    @Override
    public String toString(){
        return super.toString() + " " + type + ": " + name + " ["+ km +"] " + owner;
    }
}
