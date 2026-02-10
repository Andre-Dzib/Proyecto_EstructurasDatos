package com.gestion_portuaria.Estructuras;

/**
 * Implementación de una lista simple ligada.
 * Hereda de la clase abstracta Lista y mantiene un contador de elementos.
 * Permite inserciones y eliminaciones al inicio o al final de la lista.
 * @param <T> El tipo de elementos almacenados en la lista
 */
public class ListaSimple<T> extends Lista<T> {
    /**
     * Cantidad de elementos presentes en la lista.
     */
    protected int size = 0;

    /**
     * Inserta un elemento al inicio de la lista.
     * @param dato Elemento a insertar
     */
    @Override
    public void insertaInicio(T dato) {
        size++;
        if (vacio()) {
            inicio = ultimo = new Nodo<T>(dato);
            return;
        }

        inicio = new Nodo<T>(dato, inicio);
    }

    /**
     * Inserta un elemento al final de la lista.
     * @param dato El elemento a insertar
     */
    @Override
    public void insertaFinal(T dato) {
        size++;
        if (vacio()) {
            inicio = ultimo = new Nodo<T>(dato);
            return;
        }

        Nodo<T> nuevo = new Nodo<T>(dato);
        ultimo.setSiguiente(nuevo);
        ultimo = nuevo;
    }

    /**
     * Elimina y retorna el elemento al inicio de la lista.
     * @return El elemento eliminado, o null si la lista está vacía
     */
    @Override
    public T eliminaInicio() {
        if (vacio()) {
            System.out.println("La lista está vacía");
            return null;
        }
        size--;
        T eliminado = inicio.getDato();

        if (inicio == ultimo) {
            inicio = ultimo = null;
        } else {
            inicio = inicio.getSiguiente();
        }
        return eliminado;
    }

    /**
     * Elimina y retorna el elemento al final de la lista.
     * @return El elemento eliminado, o null si la lista está vacía
     */
    @Override
    public T eliminaFinal() {
        if (vacio()) {
            System.out.println("La lista está vacía");
            return null;
        }
        size--;

        T eliminado = ultimo.getDato();

        if (inicio == ultimo) {
            inicio = ultimo = null;
        } else {
            Nodo<T> actual = inicio;

            while (actual.getSiguiente() != ultimo) {
                actual = actual.getSiguiente();
            }

            actual.setSiguiente(null);
            ultimo = actual;
        }
        return eliminado;
    }

    /**
     * Retorna la cantidad de elementos en la lista.
     * @return El tamaño actual de la lista
     */
    public int getSize() {
        return size;
    }

    /**
     * Retorna el elemento ubicado en la posición indicada.
     * @param index El índice del elemento (Empieza desde 0)
     * @return El elemento en la posición, o null si el índice es inválido
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Nodo<T> actual = inicio;
        for (int i = 0; i < index; i++) {
            actual = actual.getSiguiente();
        }

        return actual.getDato();
    }
}