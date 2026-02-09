package com.gestion_portuaria.Carga;

public class Producto {
    private int id;         
    private String nombre;  
    private double peso;     

    // Constructor: Crea un nuevo producto con ID, nombre y peso
    public Producto(int id, String nombre, double peso) {
        this.id = id;       
        this.nombre = nombre; 
        this.peso = peso;  
    }
    
    // Imprime la información del producto en formato: "ID - Nombre (Peso kg)"
    public void imprimir(){
        System.out.println(this.id + " - " + this.nombre + " ("+this.peso+" kg)");
    }
    
    // Getter: Retorna el ID del producto
    public int getId() {
        return id;  
    }
    
   
    public void setId(int id) {
        this.id = id;  // Asigna el valor id
    }
    
    // Retorna el nombre del producto
    public String getNombre() {
        return nombre; 
    }
    
 
    public void setNombre(String nombre) {
        this.nombre = nombre;  // Asigna el valor recibido al atributo nombre
    }
    

    public double getPeso() {
        return peso;  // Retorna el peso
    }
    
   
    public void setPeso(double peso) {
        this.peso = peso;  // Asigna el valor del peso
    }
}
