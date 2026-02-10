package com.gestion_portuaria.Carga;

import com.gestion_portuaria.Estructuras.Lista;
import com.gestion_portuaria.Estructuras.Nodo;

/**
 * Representa un contenedor de productos implementado como una lista enlazada.
 * Permite insertar, eliminar y consultar productos, así como calcular el peso total.
 */
public class Contenedor extends Lista<Producto> {
    /**
     * Constructor por defecto, se crea un contenedor vacío sin productos
     */
    public Contenedor(){
        inicio = ultimo = null;
    }

    /**
     * Constructor con producto, crea el contenedor y agrega el producto automáticamente
     * @param producto El producto a agregar
     */
    public Contenedor(Producto producto){
        inicio = ultimo = new Nodo<Producto>(producto);
    }

    /**
     * Calcula el peso total del contenedor
     * @return El peso total del contenedor como un double
     */
    public double getPesoTotal() {
        double pesoTotal = 0;  
        Nodo<Producto> actual = inicio;  

        while( actual != null ) {  
            pesoTotal += actual.getDato().getPeso();  
            actual = actual.getSiguiente();
        }

        return pesoTotal;
    }

    /**
     * Busca en el contenedor actual si hay existencia de un producto en específico
     * @param id El identificador del producto a buscar
     * @return true el producto existe, en otro caso, falso
     */
    public boolean existeProducto(int id){
        Nodo<Producto> actual = inicio;  
        while(actual != null){  
            Producto producto = actual.getDato();  
            if( producto.getId() == id ) {
                return true;
            }
            actual = actual.getSiguiente();  
        }
        return false;
    }

    /**
     * Busca en el contenedor actual si hay existencia de un producto en específico
     * @param nombre El nombre del producto a buscar
     * @return true el producto existe, en otro caso, falso
     */
    public boolean existeProducto(String nombre){
        Nodo<Producto> actual = inicio;  
        while(actual != null){ 
            Producto producto = actual.getDato();  
            if( producto.getNombre().equals(nombre) ) {
                return true;
            }
            actual = actual.getSiguiente();  
        }
        return false;
    }

    /**
     * Elimina un producto del contenedor actual
     * @param nombre El nombre del producto a eliminar
     * @return El producto eliminado
     */
    public Producto eliminaProducto(String nombre) {
        Nodo<Producto> actual = inicio;
        Nodo<Producto> anterior = null;
        boolean encontrado = false;

        while(actual != null) {
            if( actual.getDato().getNombre().contentEquals(nombre) ) {
                encontrado = true;
                break;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }

        // Si el producto a buscar no existe en la lista no elimina nada y retorna null
        if(! encontrado ) {
            return null;
        }

        if(anterior == null) {
            return eliminaInicio();
        }
        else if( actual == ultimo ) {
            return eliminaFinal();
        }

        anterior.setSiguiente(actual.getSiguiente());
        return actual.getDato();
    }

    /**
     * Insertar un producto al inicio de la lista
     * @param dato El producto a insertar
     */
    @Override
    public void insertaInicio(Producto dato) {
        Nodo<Producto> nuevo = new Nodo<Producto>(dato);
        if( vacio() ) {  
            inicio = ultimo = nuevo;
            return;
        }
        nuevo.setSiguiente(inicio);
        inicio = nuevo;
    }

    /**
     * Inserta un producto al final de la lista
     * @param dato El producto a insertar
     */
    @Override
    public void insertaFinal(Producto dato) {
        Nodo<Producto> nuevo = new Nodo<Producto>(dato);
        if( vacio() ){  
            inicio = ultimo = nuevo;
            return;
        }
        ultimo.setSiguiente(nuevo);
        ultimo = nuevo;
    }

    /**
     * Elimina el producto al inicio del contenedor
     * @return El producto eliminado
     */
    @Override
    public Producto eliminaInicio() {
        if ( vacio() ){ 
            return null;
        }
        Producto productoEliminado = inicio.getDato();
        inicio = inicio.getSiguiente();


        if( inicio == null ) {
            ultimo = null;
        }
        return productoEliminado;
    }


    /**
     * Elimina el producto al final del contenedor
     * @return El producto eliminado
     */
    @Override
    public Producto eliminaFinal() {
        if( vacio() ) {  
            return null;
        }

        Producto productoEliminado = ultimo.getDato();
        if ( inicio == ultimo ){
            inicio = ultimo = null;
        }
        else{
            Nodo<Producto> actual = inicio; 
            while( actual.getSiguiente() != ultimo ){
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(null);
            ultimo = actual;
        }
        return productoEliminado;
    }
}
