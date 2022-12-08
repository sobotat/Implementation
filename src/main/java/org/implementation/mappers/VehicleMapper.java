package org.implementation.mappers;

import gateways.VehicleGateway;
import org.implementation.Car;
import org.implementation.Owner;
import org.implementation.Vehicle;

import java.util.LinkedList;

public class VehicleMapper implements Mapper<Vehicle> {

    @Override
    public Vehicle find(int id) {
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

        return new Vehicle(vehicleId, name, km, owner, type);
    }

    @Override
    public void create(Vehicle obj) {
        VehicleGateway vehicleGateway = new VehicleGateway();
        obj.id = vehicleGateway.create(obj.id, obj.name, obj.km, obj.owner.id, obj.type, null, null);
    }

    @Override
    public void update(Vehicle obj) {
        VehicleGateway vehicleGateway = new VehicleGateway();
        vehicleGateway.update(obj.id, obj.name, obj.km, obj.owner.id, obj.type, null, null);
    }

    @Override
    public void delete(Vehicle obj) {
        VehicleGateway vehicleGateway = new VehicleGateway();
        vehicleGateway.delete(obj.id);
    }
}
