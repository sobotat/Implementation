package org.implementation.mappers;

import org.implementation.Motorcycle;
import org.implementation.Owner;
import org.implementation.gateways.DBConnection;
import org.implementation.gateways.VehicleGateway;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

public class MotorcycleMapper implements VehicleMapper<Motorcycle> {

    @Override
    public Motorcycle find(int id) {
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
        if(!type.equals("Motorcycle")) {
            System.out.println("Wrong Mapper use " + type + " Mapper");
            return null;
        }

        String category = data.get(6);


        return new Motorcycle(vehicleId, name, km, owner, category);
    }

    @Override
    public void create(Motorcycle obj) {
        VehicleGateway vehicleGateway = new VehicleGateway();
        obj.vehicleId = vehicleGateway.create(obj.vehicleId, obj.name, obj.km, obj.owner.ownerId, obj.type, null, obj.category);
    }

    @Override
    public void update(Motorcycle obj) {
        VehicleGateway vehicleGateway = new VehicleGateway();
        vehicleGateway.update(obj.vehicleId, obj.name, obj.km, obj.owner.ownerId, obj.type, null, obj.category);
    }

    @Override
    public void delete(Motorcycle obj) {
        VehicleGateway vehicleGateway = new VehicleGateway();
        vehicleGateway.delete(obj.vehicleId);
    }
}
