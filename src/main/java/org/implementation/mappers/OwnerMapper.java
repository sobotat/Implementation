package org.implementation.mappers;

import org.implementation.Owner;
import gateways.OwnerGateway;

import java.util.LinkedList;

public class OwnerMapper implements Mapper<Owner> {

    @Override
    public Owner find(int id) {
        OwnerGateway ownerGateway = new OwnerGateway();
        LinkedList<String> data = ownerGateway.find(id);

        if(data.isEmpty())
            return null;

        int ownerId = Integer.parseInt(data.get(0));
        String name = data.get(1);

        return new Owner(ownerId, name);
    }

    @Override
    public void create(Owner obj) {
        OwnerGateway ownerGateway = new OwnerGateway();
        obj.ownerId = ownerGateway.create(obj.ownerId, obj.name);
    }

    @Override
    public void update(Owner obj) {
        OwnerGateway ownerGateway = new OwnerGateway();
        ownerGateway.update(obj.ownerId, obj.name);
    }

    @Override
    public void delete(Owner obj) {
        OwnerGateway ownerGateway = new OwnerGateway();
        ownerGateway.delete(obj.ownerId);
    }
}
