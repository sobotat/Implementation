package org.implementation.mappers;

import org.implementation.Owner;
import org.implementation.gateways.OwnerGateway;

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

    }

    @Override
    public void update(Owner obj) {

    }

    @Override
    public void delete(Owner obj) {

    }
}
