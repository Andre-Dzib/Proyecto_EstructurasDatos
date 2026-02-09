package com.gestion_portuaria.Estructuras;

/**
 * Clase que representa un nodo doblemente ligado para listas dobles.
 * Permite recorrer la lista en ambas direcciones
 * @param <T> tipo de dato almacenado en el nodo
 */
public class NodoDoble<T> extends Nodo<T> {
    /**
     * Referencia al siguiente nodo de la lista.
     */
    protected NodoDoble<T> siguiente;
    /**
     * Referencia al nodo anterior de la lista.
     */
    protected NodoDoble<T> anterior;

    /**
     * Constructor que crea un nodo sin dato y sin enlaces.
     */
    public NodoDoble() {
        super(null);
        anterior = null;
    }

    /**
     * Constructor que crea un nodo con dato y sin enlaces.
     * @param dato El dato a almacenar en el nodo
     */
    public NodoDoble(T dato) {
        super(dato);
        anterior = null;
    }

    /**
     * Constructor que crea un nodo doble con dato, nodo siguiente y nodo anterior.
     * @param dato El dato a almacenar en el nodo
     * @param siguiente El nodo siguiente en la lista
     * @param anterior El nodo anterior en la lista
     */
    public NodoDoble(T dato, NodoDoble<T> siguiente, NodoDoble<T> anterior) {
        super(dato);
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    /**
     * Retorna el nodo siguiente en la lista.
     * @return El siguiente nodo
     */
    public NodoDoble<T> getSiguiente() {
        return siguiente;
    }

    /**
     * Asigna el nodo siguiente en la lista.
     * @param siguiente El nodo que será el siguiente
     */
    public void setSiguiente(NodoDoble<T> siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Retorna el nodo anterior en la lista.
     * @return El nodo anterior
     */
    public NodoDoble<T> getAnterior() {
        return anterior;
    }

    /**
     * Asigna el nodo anterior en la lista.
     * @param anterior El nodo que será el anterior
     */
    public void setAnterior(NodoDoble<T> anterior) {
        this.anterior = anterior;
    }
}