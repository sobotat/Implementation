package org.implementation.mappers;

import org.implementation.Car;
import org.implementation.Owner;
import org.implementation.gateways.VehicleGateway;

import java.util.LinkedList;

public class CarMapper implements VehicleMapper<Car> {

    @Override
    public Car find(int id) {
        VehicleGateway vehicleGateway = new VehicleGateway();
        LinkedList<String> data = vehicleGateway.find(id);

        if(data.isEmpty())
            return null;

        int vehicleId = Integer.parseInt(data.get(0));
        String name = data.get(1);
        double km = Double.parseDouble(data.get(2));

        OwnerMapper ownerMapper = new OwnerMapper();
        Owner owner = ownerMapper.find(Integer.parseInt(data.get(3)));

        String type = data.get(4);
        if(!type.equals("Car")) {
            System.out.println("Wrong Mapper use " + type + " Mapper");
            return null;
        }

        Integer carryWeight = Integer.parseInt(data.get(5));

        return new Car(vehicleId, name, km, owner, carryWeight);
    }

    @Override
    public void create(Car obj) {
        VehicleGateway vehicleGateway = new VehicleGateway();
        obj.vehicleId = vehicleGateway.create(obj.vehicleId, obj.name, obj.km, obj.owner.ownerId, obj.type, obj.carryWeight, null);
    }

    @Override
    public void update(Car obj) {
        VehicleGateway vehicleGateway = new VehicleGateway();
        vehicleGateway.update(obj.vehicleId, obj.name, obj.km, obj.owner.ownerId, obj.type, obj.carryWeight, null);
    }

    @Override
    public void delete(Car obj) {
        VehicleGateway vehicleGateway = new VehicleGateway();
        vehicleGateway.delete(obj.vehicleId);
    }
}
