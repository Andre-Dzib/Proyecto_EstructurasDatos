package com.gestion_portuaria.Estructuras;

public abstract class ListaD<T> extends Lista<T> {
    protected NodoDoble<T> inicio;
    protected NodoDoble<T> ultimo;

    public boolean vacio() {
        return inicio == null;
    }

    public void imprimir() {
        super.setInicio(inicio);
        super.imprimir();
    }

    public void imprimirAlReves() {
        NodoDoble<T> actual = ultimo;

        while(actual != null) {
            System.out.println(actual.getDato() + "->");
            actual = actual.getAnterior();
        }
    }
}