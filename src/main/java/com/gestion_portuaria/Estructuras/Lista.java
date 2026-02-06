package com.gestion_portuaria.Estructuras;

public abstract class Lista<T> {
    protected Nodo<T> inicio;
    protected Nodo<T> ultimo;
    protected String nombre;

    public Lista(){
        this.nombre = "lista";
    }
    public Lista(String nombre){
        this.nombre = nombre;
        this.inicio = this.ultimo = null;
    }
    public boolean vacio(){
        return inicio == null;
    }
    public void imprimir(){
        Nodo<T> actual = inicio;
        while (actual != null){
            System.out.println(actual.getDato()+"");
            actual = actual.getSiguiente();
        }
    }
    public Nodo<T> getInicio() {
        return inicio;
    }
    public void setInicio(Nodo<T> inicio) {
        this.inicio = inicio;
    }
    public Nodo<T> getUltimo() {
        return ultimo;
    }
    public void setUltimo(Nodo<T> ultimo) {
        this.ultimo = ultimo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    // Metodos que se heredarán
    public abstract void insertaInicio(T dato);
    public abstract void insertaFinal(T dato);
    public abstract T eliminaInicio();
    public abstract T eliminaFinal();
}
