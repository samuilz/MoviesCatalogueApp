package com.moviecatalogue.server.repositories.base;

import java.util.List;

public interface BaseRepository<T> {

    List<T> getAll();

    T getById(int id);

    T add(T object);

    T update(int id, T object);
}
