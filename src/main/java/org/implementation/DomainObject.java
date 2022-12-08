package org.implementation;

public class DomainObject {
    public int id;

    public DomainObject(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "[" + id + "]";
    }
}
