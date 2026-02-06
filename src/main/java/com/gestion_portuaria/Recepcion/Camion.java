package com.gestion_portuaria.Recepcion;

import com.gestion_portuaria.Carga.Contenedor;

public class Camion {
    protected Contenedor contenedor;
    protected String placa;

    public Camion() {
        contenedor = null;
        placa = null;
    }

    public Camion(Contenedor contenedor, String placa) {
        this.contenedor = contenedor;
        this.placa = placa;
    }

    public Contenedor getContenedor() {
        return contenedor;
    }

    public void setContenedor(Contenedor contenedor) {
        this.contenedor = contenedor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
