package com.gestion_portuaria.Estructuras;

/**
 * Clase abstracta que representa una lista doblemente ligada.
 * Hereda de la clase Lista y extiende su funcionalidad usando nodos dobles,
 * permitiendo recorrer hacia adelante y hacia atrás
 */
public abstract class ListaD<T> extends Lista<T> {
    /**
     * Primer nodo de la lista
     */
    protected NodoDoble<T> inicio;

    /**
     * Ultimo nodo de la lista
     */
    protected NodoDoble<T> ultimo;

    /**
     * Indica si la lista se encuentra vacía.
     * @return true si no contiene elementos, false en caso contrario
     */
    public boolean vacio() {
        return inicio == null;
    }

    /**
     * Retorna el nodo inicial de la lista.
     * @return El nodo inicial de la lista
     */
    public NodoDoble<T> getInicio() {
        return inicio;
    }

    /**
     * Retorna el nodo final de la lista.
     * @return El nodo final de la lista
     */
    public NodoDoble<T> getUltimo() {
        return ultimo;
    }
}