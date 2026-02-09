package com.gestion_portuaria.Distribucion;

/**
 * Clase que representa una parada dentro de una ruta de distribución.
 * Cada parada se identifica por un identificador único y un nombre descriptivo.
 */
public class Parada {
    /**
     * Identificador de la parada
     */
    private int id;
    /**
     * Nombre de la parada
     */
    private String nombre; 

    /**
     *Crea una nueva parada con un identificador y un nombre
     * @param id Identificador de la parada
     * @param nombre Nombre de la parada
     */
    public Parada(int id, String nombre) {
        this.id = id;        
        this.nombre = nombre; 
    }

    /**
     * Getter del ID
     * @return El identificador de la parada
     */
    public int getId() {
        return id;
    }

    /**
     * Asigna el identificador de la parada.
     * @param id El nuevo identificador de la parada.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter del nombre
     * @return Nombre de la parada
     */
    public String getNombre() {
        return nombre;  // Retorna el valor del atributo nombre
    }

    /**
     * Asigna del nombre de la parada.
     * @param nombre El nuevo nombre de la parada.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;  // Asigna el atributo nombre
    }

    /**
     * Representación en texto de la parada
     * @return Representación del texto de la parada en formato "nombre (id)"
     */
    @Override
    public String toString() {
        return nombre + " (" + id + ")";  
    }
}
