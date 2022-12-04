package org.implementation;

import org.implementation.mappers.CarMapper;
import org.implementation.mappers.MotorcycleMapper;

public class Main {
    public static void main(String[] args) {

        Car car = new CarMapper().find(1);
        Motorcycle motorcycle = new MotorcycleMapper().find(2);

        System.out.println(car.carryWeight);
        System.out.println(car.owner.name);
        System.out.println(motorcycle.category);

        System.out.println("End");
    }
}