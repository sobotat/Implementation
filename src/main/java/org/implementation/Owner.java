package org.implementation;

public class Owner extends DomainObject {

    public String name;

    public Owner(int ownerId, String name) {
        super(ownerId);
        this.name = name;
    }

    @Override
    public String toString(){
        return "Owner: " + name;
    }
}
