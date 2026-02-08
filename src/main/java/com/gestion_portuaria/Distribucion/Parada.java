package com.gestion_portuaria.Distribucion;

public class Parada {
    private int id;        
    private String nombre; 
    
    // Constructor: Crea una nueva parada con ID y nombre
    public Parada(int id, String nombre) {
        this.id = id;        
        this.nombre = nombre; 
    }

    
    public int getId() {
        return id;  // Retorna el valor del atributo id
    }

   
    public void setId(int id) {
        this.id = id;  // Asigna el valor id
    }

   
    public String getNombre() {
        return nombre;  // Retorna el valor del atributo nombre
    }

   
    public void setNombre(String nombre) {
        this.nombre = nombre;  // Asigna el atributo nombre
    }

    // Sobrescribe el método retorna representación en texto de la parada
    @Override
    public String toString() {
        return nombre + " (" + id + ")";  
    }
}
