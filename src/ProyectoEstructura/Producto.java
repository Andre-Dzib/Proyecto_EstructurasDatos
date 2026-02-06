/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoEstructura;

import Listas.ListaSimple;

/**
 *
 * @author ojeda
 */
public class Producto {
    public int ID;
   public String nombre;
   public float peso;

    public Producto(int ID, String nombre, float peso) {
        this.ID = ID;
        this.nombre = nombre;
        this.peso = peso;
   
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
 
   
}
