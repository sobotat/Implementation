package org.implementation;

import gateways.DBConnection;
import org.implementation.mappers.CarMapper;
import org.implementation.mappers.MotorcycleMapper;
import org.implementation.mappers.OwnerMapper;
import org.implementation.mappers.VehicleMapper;

/**
 * Tato implementace obsahuje Table Gateway, Single Table Inheritance, Foreign Key Mapping
 * Made by Tomáš Sobota
 * **/

public class Main {
    public static void main(String[] args) {

        Car car = new CarMapper().find(1);
        Motorcycle motorcycle = new MotorcycleMapper().find(2);

        System.out.println(car.toString());
        System.out.println(motorcycle.toString() + "\n");

        // Owner Mapper
        OwnerMapper ownerMapper = new OwnerMapper();
        Owner owner = new Owner(0, "Marek");
        ownerMapper.create(owner);
        owner.name = "Petr";
        ownerMapper.update(owner);
        System.out.println(owner);

        // Car Mapper
        CarMapper carMapper = new CarMapper();
        Car car2 = new Car(0, "BMW", 450000, owner, 1000);
        carMapper.create(car2);
        car2.carryWeight = 2500;
        carMapper.update(car2);
        car2 = carMapper.find(car2.id);
        System.out.println(car2);
        carMapper.delete(car2);

        // Motorcycle Mapper
        MotorcycleMapper motorcycleMapper = new MotorcycleMapper();
        Motorcycle motorcycle2 = new Motorcycle(0, "Scooter", 100, owner, "A3");
        motorcycleMapper.create(motorcycle2);
        motorcycle2.category = "A2";
        motorcycleMapper.update(motorcycle2);
        motorcycle2 = motorcycleMapper.find(motorcycle2.id);
        System.out.println(motorcycle2);
        motorcycleMapper.delete(motorcycle2);

        // Vehicle Mapper
        VehicleMapper vehicleMapper = new VehicleMapper();
        Vehicle vehicle = new Vehicle(0, "Airbus", 100000, owner, "Plane");
        vehicleMapper.create(vehicle);
        vehicle.km = 50000;
        vehicleMapper.update(vehicle);
        vehicle = vehicleMapper.find(vehicle.id);
        System.out.println(vehicle);
        vehicleMapper.delete(vehicle);

        ownerMapper.delete(owner);

        System.out.println("\nEnd");
        DBConnection.close();
    }
}