package com.gestion_portuaria.Recepcion;

import com.gestion_portuaria.Carga.Contenedor;

/**
 * Clase que representa un camión en el sistema de recepción del puerto.
 * Cada camión puede transportar un contenedor y tiene un identificador de placa.
 */
public class Camion {
    /**
     * Contenedor transportado por el camión.
     */
    protected Contenedor contenedor;
    /**
     * Placa del camión.
     */
    protected String placa;

    /**
     * Constructor por defecto.
     * Inicializa el camión sin contenedor y sin placa asignada.
     */
    public Camion() {
        contenedor = null;
        placa = null;
    }

    /**
     * Constructor que inicializa un camión con una placa.
     * Se crea un contenedor vacío automáticamente.
     * @param placa La placa del camión
     */
    public Camion(String placa) {
        this.contenedor = new Contenedor();
        this.placa = placa;
    }

    /**
     * Constructor que inicializa un camión con un contenedor y placa específicos.
     * @param contenedor El contenedor que transporta el camión
     * @param placa La placa del camión
     */
    public Camion(Contenedor contenedor, String placa) {
        this.contenedor = contenedor;
        this.placa = placa;
    }

    /**
     * Retorna el contenedor que transporta el camión.
     * @return El contenedor del camión
     */
    public Contenedor getContenedor() {
        return contenedor;
    }

    /**
     * Asigna un contenedor al camión.
     * @param contenedor El contenedor a asignar
     */
    public void setContenedor(Contenedor contenedor) {
        this.contenedor = contenedor;
    }

    /**
     * Retorna la placa del camión.
     * @return La placa del camión
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Asigna la placa del camión.
     * @param placa La placa a asignar
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }
}