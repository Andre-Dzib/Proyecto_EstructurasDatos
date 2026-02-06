package com.gestion_portuaria.Distribucion;

public class Parada {
    private String destinatario;
    private String direccion;
    private String ciudad;
    private String pais;
    private String codigoPostal; // El código postal no siempre es un número entero

    public Parada() {
        this.destinatario = null;
        this.direccion = null;
        this.ciudad = null;
        this.pais = null;
        this.codigoPostal = null;
    }

    public Parada(String destinatario, String direccion, String ciudad, String pais, String codigoPostal) {
        this.destinatario = destinatario;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public String toString() {
        return destinatario + " " + direccion + " / " + ciudad + " (" + codigoPostal + ")";
    }
}
