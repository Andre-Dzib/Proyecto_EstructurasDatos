package com.gestion_portuaria.Estructuras;

/**
 * Interfaz genérica que representa una cola (queue) de elementos.
 * Define los métodos básicos de una cola: encolar, desencolar,
 * consultar el frente, obtener el tamaño y verificar si está vacía.
 * @param <T> El tipo de elementos almacenados en la cola
 */
public interface Queue<T> {
    /**
     * Agrega un elemento al final de la cola.
     * @param dato El elemento a encolar
     */
    void enqueue(T dato);

    /**
     * Elimina y retorna el elemento al frente de la cola.
     * @return El elemento desencolado, o null si la cola está vacía
     */
    T dequeue();

    /**
     * Retorna la cantidad de elementos actualmente en la cola.
     * @return El tamaño actual de la cola
     */
    int size();

    /**
     * Retorna el elemento al frente de la cola sin eliminarlo.
     * @return El elemento al frente, o null si la cola está vacía
     */
    T front();

    /**
     * Verifica si la cola está vacía.
     * @return true si la cola no contiene elementos, false en caso contrario
     */
    boolean isEmpty();
}