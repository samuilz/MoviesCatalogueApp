package com.quicksilver.moviesapp.validators.base;

public interface Validator<T> {
    boolean isValid(T object);
}
