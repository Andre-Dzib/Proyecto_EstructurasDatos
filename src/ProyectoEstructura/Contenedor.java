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
public class Contenedor {
   public int idContenedor;
   public ListaSimple productos;
   
    public Contenedor(){
       this.idContenedor =  idContenedor;
        productos = new ListaSimple();
    }


    public int getIdContenedor() {
        return idContenedor;
    }

    public void setIdContenedor(int idContenedor) {
        this.idContenedor = idContenedor;
    }

    public ListaSimple getProductos() {
        return productos;
    }

    public void setProductos(ListaSimple listaCon) {
        this.productos = productos;
    }
    
    
    
   
}
