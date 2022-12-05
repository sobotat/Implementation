package org.implementation.mappers;

public interface Mapper <T> {

    T find(int id);
    void create(T obj);
    void update(T obj);
    void delete(T obj);
}
