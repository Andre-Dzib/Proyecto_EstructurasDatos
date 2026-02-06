package com.gestion_portuaria.Carga;

public class Producto {
    private int id;
    private String nombre;
    private double peso;

    public Producto(int id, String nombre, double peso) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
    }
    public void imprimir(){
        System.out.println(this.id + " - " + this.nombre + " ("+this.peso+" kg)");
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
}
