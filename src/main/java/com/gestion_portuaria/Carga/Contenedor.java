package com.gestion_portuaria.Carga;

import com.gestion_portuaria.Estructuras.Lista;
import com.gestion_portuaria.Estructuras.Nodo;

public class Contenedor extends Lista<Producto> {
    private double pesoTotal;
    public Contenedor(){
        inicio = ultimo = null;
        this.pesoTotal = 0;
    }
    public Contenedor(Producto producto){
        inicio = ultimo = new Nodo<Producto>(producto);
        this.pesoTotal = producto.getPeso();
    }
    // Métodos propios
    public double getPesoTotal() {
        if (pesoTotal <0) return 0;
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
            Producto producto = actual.getDato(); // Producto actual
            if(producto.getId() == id) return true; // Si lo encontró, retorna verdad
            actual = actual.getSiguiente(); // Cambia al siguiente nodo
        }
        return false; // Si llego hasta aquí, entonces no existía dentro
    }
    public boolean existeProducto(String nombre){
        Nodo<Producto> actual = inicio; // nodo auxiliar
        while(actual != null){ // Mientras no llegue al final de la lista
            Producto producto = actual.getDato(); // Producto actual
            if(producto.getNombre().equals(nombre)) return true; // Si lo encontró, retorna verdad
            actual = actual.getSiguiente(); // cambia al siguiente nodo
        }
        return false; // Si llego hasta aquí, entonces no existía dentro
    }
    // Métodos heredados
    @Override
    public void insertaInicio(Producto dato) {
        Nodo<Producto> nuevo = new Nodo<Producto>(dato);
        if(vacio()){ // Lista vacia
            inicio = ultimo = nuevo;
        }
        else{
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
        this.pesoTotal += dato.getPeso();
    }

    @Override
    public void insertaFinal(Producto dato) {
        Nodo<Producto> nuevo = new Nodo<Producto>(dato);
        if(vacio()){
            inicio = ultimo = nuevo;
        }
        else{
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
        this.pesoTotal += dato.getPeso();
    }

    @Override
    public Producto eliminaInicio() {
        if (vacio()) return null; // Lista vacia
        Producto productoEliminado = inicio.getDato(); // Primer producto
        inicio = inicio.getSiguiente(); // Cambiar al siguiente producto en la lista
        if(inicio == null) ultimo = null; // Si vaciaron todo
        this.pesoTotal -= productoEliminado.getPeso(); // Quitar el peso
        return productoEliminado; // Regresar el producto eliminado
    }

    @Override
    public Producto eliminaFinal() {
        if (vacio()) return null; // Lista vacia
        Producto productoEliminado = null;// Producto eliminado
        if (inicio == ultimo){ // Si solo hay un nodo
            productoEliminado = inicio.getDato(); // Obtener producto eliminado
            inicio = ultimo = null; // Vaciar lsita
        }
        else{
            Nodo<Producto> actual = inicio; // Nodo Auxiliar
            while(actual.getSiguiente() != ultimo){ // Para llegar al final de la lista
                actual = actual.getSiguiente(); // Llegar al penultimo de la lista
            }
            productoEliminado = (Producto) ultimo.getDato(); // Obtener producto eliminado
            actual.setSiguiente(null); // No hay más alla en la lista
            ultimo = actual; // el ultiimo pasa ser el penultimo
        }
        this.pesoTotal -= productoEliminado.getPeso(); // Restar al peso
        return productoEliminado; // Retornar producto eliminado
    }
    // Para probar
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
