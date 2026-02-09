package com.gestion_portuaria.Estructuras;

/**
 * Clase abstracta que representa una estructura de lista.
 * Permite que las clases hijas implementen la lógica específica de inserción
 * y eliminación de elementos.
 */
public abstract class Lista<T> {
    /**
     * Referencia al primer nodo de la lista.
     */
    protected Nodo<T> inicio;
    /**
     * Referencia al último nodo de la lista.
     */
    protected Nodo<T> ultimo;
    /**
     * Nombre descriptivo de la lista.
     */
    protected String nombre;

    /**
     * Crea una lista con un nombre por defecto.
     */
    public Lista(){
        this.nombre = "lista";
    }

    /**
     * Crea una lista con un nombre específico
     * @param nombre nombre de la lista
     */
    public Lista(String nombre){
        this.nombre = nombre;
        this.inicio = this.ultimo = null;
    }

    /**
     * Indica si la lista se encuentra vacía.
     * @return true si la lista no contiene elementos, false en caso contrario
     */
    public boolean vacio(){
        return inicio == null;
    }

    /**
     * Retorna el nodo inicial de la lista.
     * @return El nodo inicial de la lista
     */
    public Nodo<T> getInicio() {
        return inicio;
    }

    /**
     * Asigna el nodo inicial de la lista.
     * @param inicio El nuevo nodo inicial
     */
    public void setInicio(Nodo<T> inicio) {
        this.inicio = inicio;
    }

    /**
     * Retorna el nodo final de la lista.
     * @return El nodo final de la lista
     */
    public Nodo<T> getUltimo() {
        return ultimo;
    }

    /**
     * Asigna el nodo final de la lista.
     * @param ultimo El nuevo nodo final
     */
    public void setUltimo(Nodo<T> ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * Retorna el nombre de la lista.
     * @return El nombre de la lista
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre de la lista.
     * @param nombre El nuevo nombre de la lista
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Inserta un elemento al inicio de la lista.
     * @param dato El elemento a insertar
     */
    public abstract void insertaInicio(T dato);

    /**
     * Inserta un elemento al final de la lista.
     * @param dato El elemento a insertar
     */
    public abstract void insertaFinal(T dato);

    /**
     * Elimina y retorna el elemento ubicado al inicio de la lista.
     * @return El elemento eliminado
     */
    public abstract T eliminaInicio();

    /**
     * Elimina y retorna el elemento ubicado al final de la lista.
     * @return El elemento eliminado
     */
    public abstract T eliminaFinal();
}