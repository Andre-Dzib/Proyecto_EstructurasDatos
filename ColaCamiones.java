/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoEstructura;

import Colas.Queue;
import Listas.ListaSimple;
/**
 *
 * @author ojeda
 */
public class ColaCamiones implements Queue {
   protected ListaSimple lista;
    protected int cont;
    
    
    ColaCamiones(){
        lista = new ListaSimple();
        cont = 0;
    }
    
    
    
    public void ingresarCamion(Camion camion){
        lista.insertarFinal(camion);
        cont++;
    }
    
    public Camion sacarCamion() {
        if(lista.vacio()){ 
        System.out.println("La lista esta vacia");
        return null;
        } else{
            cont--;
            Camion camion = (Camion) lista.eliminarInicio();
            return camion;
        }
            
    }
    
     public Camion frente() {
     if(lista.vacio()){
            System.out.println("Lista Vacia");
        return null;
        }
        else {
         Camion cam = (Camion) lista.getInicio().getDato();
            return cam;
        }
    }
    
    
    @Override
    public void enqueue(Object dato) {
        ingresarCamion((Camion) dato);
    }

    @Override
    public Object dequeue() {
        return sacarCamion();
            
    }

    @Override
    public int size() {
        return cont;
    }

    @Override
    public Object front() {
     return frente();
    }
    @Override
    public boolean isEmpty() {
        return lista.vacio();
    }

    public ListaSimple getLista() {
        return lista;
    }

    public void setLista(ListaSimple lista) {
        this.lista = lista;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }
    
    
    
}
