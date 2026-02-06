/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoEstructura;

import Listas.ListaSimple;
import Listas.Nodo;

/**
 *
 * @author ojeda
 */
public class LogicaContenedor {
        public void agregarProduc(Contenedor con, Producto producto){
       con.getProductos().insertarFinal(producto);
    }
    
    public float pesoTotal(Contenedor con){
        float total = 0;
        Nodo actual = con.getProductos().getInicio();
        while(actual != null){
            Producto p = (Producto) actual.getDato();
            total +=  p.getPeso();
            actual = actual.getSiguiente();
        }
        return total;
    }
    
    

    public boolean existeContenedor(Contenedor con,int id){
        Nodo actual = con.getProductos().getInicio();
        while(actual != null){
           Producto p = (Producto) actual.getDato();
           if(p.getID() == id) return true;
           actual = actual.getSiguiente();
        }
        
        return false;
    }
    
}
