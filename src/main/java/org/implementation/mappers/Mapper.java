package org.implementation.mappers;

import java.util.LinkedList;

public interface Mapper <T> {

    T find(int id);
    void create(T obj);
    void update(T obj);
    void delete(T obj);
}
