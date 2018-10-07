package com.quicksilver.moviesapp.parsers.base;

import java.util.List;

public interface JsonParser<T> {
    List<T> fromJsonArray(String json);

    T fromJson(String json);

    String toJson(T object);
}
