package com.gestion_portuaria.Estructuras;

public class ListaSimple<T> extends Lista<T> {
    protected int size = 0;

    @Override
    public void insertaInicio(T dato) {
        size++;
        if( vacio() ) {
            inicio = ultimo = new Nodo<T>(dato);
            return;
        }

        inicio = new Nodo<T>(dato, inicio);
    }

    @Override
    public void insertaFinal(T dato) {
        size++;
        if( vacio() ) {
            inicio = ultimo = new Nodo<T>(dato);
            return;
        }

        Nodo<T> nuevo = new Nodo<T>(dato);
        ultimo.setSiguiente(nuevo);
        ultimo = nuevo;
    }

    @Override
    public T eliminaInicio() {
        if( vacio() ) {
            System.out.println("La lista esta vacía");
            return null;
        }
        size--;
        T eliminado = inicio.getDato();

        if( inicio == ultimo ){
            inicio = ultimo = null;
        }
        else {
            inicio = inicio.getSiguiente();
        }
        return eliminado;
    }

    @Override
    public T eliminaFinal() {
        if( vacio() ) {
            System.out.println("La lista esta vacia");
        }
        size--;
        T eliminado = ultimo.getDato();

        if( inicio == ultimo ){
            inicio = ultimo = null;
        }
        else {
            Nodo<T> actual = inicio;

            while( actual.getSiguiente()!=ultimo ){
                actual = actual.getSiguiente();
            }

            actual.setSiguiente(null);
            ultimo = actual;
        }
        return eliminado;
    }

    public int getSize() {
        return size;
    }
}
