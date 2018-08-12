package ru.protei.tcpserver.dao;

public interface CRUD<T> {
    T create(T t);
    T update(T t);
    T delete(T t);
    boolean exists(T t);
}
