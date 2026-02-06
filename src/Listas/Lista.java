/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas;

/**
 *
 * @author ojeda
 */
public abstract class Lista {
    protected Nodo inicio;
    protected Nodo ultimo;
    protected String Nombre;
    
    public Lista (){
        this("Lista");
    }

    public Lista(String Nombre) {
        this.Nombre = Nombre;
        inicio = ultimo = null;
    }
    
    public void imprimir(){
        Nodo actual = inicio;
        while((actual != null)){
            System.out.println(actual.getDato()+ "->");
            actual = actual.getSiguiente();
        }
    }
    
    public abstract void insertaInicio(Object dato);
    public abstract void insertarFinal(Object dato);
    public abstract void insertarSegundo(Object dato);
    public abstract void insertarPen(Object dato);
    public abstract Object eliminarInicio();
    public abstract Object eliminarFinal();
    
    public boolean vacio(){
        return getInicio() == null;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
    
}
