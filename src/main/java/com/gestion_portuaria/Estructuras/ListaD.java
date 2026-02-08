package com.gestion_portuaria.Estructuras;

public abstract class ListaD<T> extends Lista<T> {
    protected NodoDoble<T> inicio;
    protected NodoDoble<T> ultimo;

    public boolean vacio() {
        return inicio == null;
    }

    @Override
    public void imprimir() {
        NodoDoble<T> actual = inicio;

        if( vacio() ) {
            System.out.println("Lista vacía");
            return;
        }

        while( actual != null ) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }

    public NodoDoble<T> getInicio() {
        return inicio;
    }

    public NodoDoble<T> getUltimo() {
        return ultimo;
    }
}