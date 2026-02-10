package com.gestion_portuaria.Estructuras;

/**
 * Clase que representa un nodo para listas simples.
 * Contiene un dato de tipo T y una referencia al siguiente nodo de la lista.
 * @param <T> tipo de dato almacenado en el nodo
 */
public class Nodo<T> {
    /**
     * Dato almacenado en el nodo.
     */
    protected T dato;
    /**
     * Referencia al siguiente nodo en la lista.
     */
    protected Nodo<T> siguiente;

    /**
     * Constructor que crea un nodo con un dato y sin siguiente.
     * @param dato El dato a almacenar en el nodo
     */
    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    /**
     * Constructor que crea un nodo con un dato y referencia al siguiente nodo.
     * @param dato El dato a almacenar en el nodo
     * @param siguiente El nodo siguiente en la lista
     */
    public Nodo(T dato, Nodo<T> siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    /**
     * Retorna el dato almacenado en el nodo.
     * @return El dato del nodo
     */
    public T getDato() {
        return dato;
    }

    /**
     * Asigna un nuevo dato al nodo.
     * @param dato El nuevo dato a almacenar
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * Retorna el nodo siguiente en la lista.
     * @return El nodo siguiente
     */
    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    /**
     * Asigna el nodo siguiente en la lista.
     * @param siguiente El nodo que será el siguiente
     */
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}