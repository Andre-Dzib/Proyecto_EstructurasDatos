package com.gestion_portuaria.Estructuras;

public class NodoDoble<T> extends Nodo<T> {
    protected NodoDoble<T> siguiente;
    protected NodoDoble<T> anterior;

    public NodoDoble() {
        super(null);
        anterior = null;
    }

    public NodoDoble(T dato) {
        super(dato);
        anterior = null;
    }

    public NodoDoble(T dato, NodoDoble<T> siguiente, NodoDoble<T> anterior) {
        super(dato);
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public NodoDoble<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble<T> siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble<T> anterior) {
        this.anterior = anterior;
    }
}