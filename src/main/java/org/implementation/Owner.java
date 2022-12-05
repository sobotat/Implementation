package org.implementation;

public class Owner {

    public int ownerId;
    String name;

    public Owner(int ownerId, String name) {
        this.ownerId = ownerId;
        this.name = name;
    }

    @Override
    public String toString(){
        return "Owner: " + name;
    }
}
