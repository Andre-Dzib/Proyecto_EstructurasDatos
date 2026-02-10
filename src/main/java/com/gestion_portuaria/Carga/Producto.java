package com.gestion_portuaria.Carga;

/**
 * Representa a un producto con un identificador, nombre y peso
 */
public class Producto {
    /**
     * Identificador del producto
     */
    private int id;
    /**
     * Nombre del producto
     */
    private String nombre;
    /**
     * Peso del producto
     */
    private double peso;     

    /**
     * Crea un nuevo producto con sus atributos requeridos
     * @param id El identificador del producto
     * @param nombre El nombre del producto
     * @param peso El peso del producto (En kilogramos)
     */
    public Producto(int id, String nombre, double peso) {
        this.id = id;       
        this.nombre = nombre; 
        this.peso = peso;  
    }

    /**
     * Getter del ID del producto
     * @return El identificador del producto
     */
    public int getId() {
        return id;  
    }

    /**
     * Asigna el ID del producto al especificado
     * @param id El nuevo ID del producto
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter del nombre del producto
     * @return El nombre del producto
     */
    public String getNombre() {
        return nombre; 
    }

    /**
     * Asigna el nombre del producto al específicado
     * @param nombre El nuevo nombre del producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    /**
     * Getter del peso del producto
     * @return El peso del producto
     */
    public double getPeso() {
        return peso;
    }


    /**
     * Asigna el peso del producto al específicado
     * @param peso El nuevo peso del producto
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }
}
