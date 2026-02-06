package com.gestion_portuaria.Estructuras;

public interface Pila<T> {
    void push(T x);
    T pop();
    T top();
    int size();
    boolean isEmpty();
}

