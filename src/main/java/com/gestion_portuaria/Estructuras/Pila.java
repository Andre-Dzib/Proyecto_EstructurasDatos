package com.gestion_portuaria.Estructuras;

/**
 * Interfaz genérica para representar una pila (stack) de elementos.
 * Define los métodos básicos de una pila: apilar, desapilar, consultar
 * el elemento superior, obtener el tamaño y verificar si está vacía.
 * @param <T> tipo de elementos almacenados en la pila
 */
public interface Pila<T> {

    /**
     * Apila un elemento en la cima de la pila.
     * @param x El elemento a apilar
     */
    void push(T x);

    /**
     * Desapila y retorna el elemento de la cima de la pila.
     * @return El elemento desapilado, o null si la pila está vacía
     */
    T pop();

    /**
     * Retorna el elemento en la cima de la pila sin desapilarlo.
     * @return El elemento en la cima, o null si la pila está vacía
     */
    T top();

    /**
     * Retorna la cantidad de elementos en la pila.
     * @return El tamaño actual de la pila
     */
    int size();

    /**
     * Verifica si la pila está vacía.
     * @return El true si la pila no contiene elementos, false en caso contrario
     */
    boolean isEmpty();
}