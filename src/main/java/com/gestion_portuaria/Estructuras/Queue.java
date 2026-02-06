package com.gestion_portuaria.Estructuras;

public interface Queue<T> {
    void enqueue(T dato);
    T dequeue();
    int size();
    T front();
    boolean isEmpty();
}
