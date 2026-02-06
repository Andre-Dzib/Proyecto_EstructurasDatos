package com.gestion_portuaria.Carga;

import com.gestion_portuaria.Estructuras.Lista;
import com.gestion_portuaria.Estructuras.Nodo;

public class Contenedor extends Lista<Producto> {
    public Contenedor(){
        inicio = ultimo = null;
    }
    public Contenedor(Producto producto){
        inicio = ultimo = new Nodo<Producto>(producto);
    }

    public double getPesoTotal() {
        double pesoTotal = 0;
        Nodo<Producto> actual = inicio;

        while( actual != null ) {
            pesoTotal += actual.getDato().getPeso();
            actual = actual.getSiguiente();
        }

        return pesoTotal;
    }

    public void imprimirContenido(){
        Nodo<Producto> actual = inicio;
        while (actual != null){
            Producto producto = actual.getDato();
            producto.imprimir();
            actual = actual.getSiguiente();
        }
    }

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

    @Override
    public void insertaInicio(Producto dato) {
        Nodo<Producto> nuevo = new Nodo<Producto>(dato);
        if( vacio() ) {
            inicio = ultimo = nuevo;
        }
        else {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
    }

    @Override
    public void insertaFinal(Producto dato) {
        Nodo<Producto> nuevo = new Nodo<Producto>(dato);
        if( vacio() ){
            inicio = ultimo = nuevo;
        }
        else{
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
    }

    @Override
    public Producto eliminaInicio() {
        if ( vacio() ){
            return null;
        }
        Producto productoEliminado = inicio.getDato();
        inicio = inicio.getSiguiente();

        // Si vaciaron completamente el contenedor
        if( inicio == null ) {
            ultimo = null;
        }
        return productoEliminado;
    }

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

    // Pruebas
    public static void main(String[] args) {
        Contenedor contenedor = new Contenedor();
        contenedor.insertaInicio(new Producto(1, "Palomas", 10.1));
        System.out.println("Peso actual de contenedor: " + contenedor.getPesoTotal() + " kg");
        contenedor.insertaInicio(new Producto(2, "Chocolate en barra", 10.2));
        System.out.println("Peso actual de contenedor: " + contenedor.getPesoTotal() + " kg");
        contenedor.insertaFinal(new Producto(3, "Chocolate blanco", 10.2));
        System.out.println("Peso actual de contenedor: " + contenedor.getPesoTotal() + " kg");
        contenedor.insertaInicio(new Producto(4, "Chocolate con nuez", 10.2));
        System.out.println("Peso actual de contenedor: " + contenedor.getPesoTotal() + " kg");
        contenedor.insertaInicio(new Producto(5, "Chocolate con almendra", 10.2));
        System.out.println("Peso actual de contenedor: " + contenedor.getPesoTotal() + " kg");
        contenedor.insertaFinal(new Producto(6, "Vainilla", 10.1));
        System.out.println("Peso actual de contenedor: " + contenedor.getPesoTotal() + " kg");
        System.out.println("\n\n\n________________________________________________\n\n\n");
        System.out.println("Lista de productos dentro del contenedor");
        contenedor.imprimirContenido();
        System.out.println("Confirmar si existe producto con ID 6... " + contenedor.existeProducto(6));
        System.out.println("Confirmar si existe producto con nombre: 'Vainilla'... " + contenedor.existeProducto("Vainilla"));
        System.out.println("\n\n\n________________________________________________\n\n\n");
        System.out.println("Lista de productos en proceso de eliminación");
        contenedor.imprimirContenido();
        System.out.println("Peso actual de contenedor: " + contenedor.getPesoTotal() + " kg");
        contenedor.eliminaInicio();
        System.out.println("\n --------- Se elimino el primero");
        contenedor.imprimirContenido();
        System.out.println("Peso actual de contenedor: " + contenedor.getPesoTotal() + " kg");
        contenedor.eliminaFinal();
        System.out.println("\n --------- Se elimino el ultimo");
        contenedor.imprimirContenido();
        System.out.println("Peso actual de contenedor: " + contenedor.getPesoTotal() + " kg");
        contenedor.eliminaInicio();
        System.out.println("\n --------- Se elimino el primero");
        contenedor.imprimirContenido();
        System.out.println("Peso actual de contenedor: " + contenedor.getPesoTotal() + " kg");
        contenedor.eliminaFinal();
        System.out.println("\n --------- Se elimino el ultimo");
        contenedor.imprimirContenido();
        System.out.println("Peso actual de contenedor: " + contenedor.getPesoTotal() + " kg");
        contenedor.eliminaInicio();
        System.out.println("\n --------- Se elimino el primero");
        contenedor.imprimirContenido();
        System.out.println("Peso actual de contenedor: " + contenedor.getPesoTotal() + " kg");
        contenedor.eliminaInicio();
        System.out.println("\n --------- Se elimino el primero");
        System.out.println("Peso actual de contenedor: " + contenedor.getPesoTotal() + " kg");
        System.out.println("Confirmar si aun existe producto con ID 6 ... " + contenedor.existeProducto(6));
        System.out.println("Confirmar si aun existe producto con nombre: 'Vainilla' ... " + contenedor.existeProducto("Vainilla"));
    }
}