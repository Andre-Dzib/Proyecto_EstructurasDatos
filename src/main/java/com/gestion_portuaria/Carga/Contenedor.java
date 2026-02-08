package com.gestion_portuaria.Carga;

import com.gestion_portuaria.Estructuras.Lista;
import com.gestion_portuaria.Estructuras.Nodo;

public class Contenedor extends Lista<Producto> {
    // Constructor vacío: Crea un contenedor vacío sin productos
    public Contenedor(){
        inicio = ultimo = null;  // Inicializa ambos punteros como null
    }
    // Constructor con producto: Crea contenedor con un primer producto
    public Contenedor(Producto producto){
        inicio = ultimo = new Nodo<Producto>(producto);  // Crea nodo con producto y lo asigna a inicio y ultimo
    }

    // Calcula el peso total sumando el peso de todos los productos en el contenedor
    public double getPesoTotal() {
        double pesoTotal = 0;  
        Nodo<Producto> actual = inicio;  

        while( actual != null ) {  
            pesoTotal += actual.getDato().getPeso();  
            actual = actual.getSiguiente();  // Avanza al siguiente nodo
        }

        return pesoTotal;  // Retorna la suma total de pesos
    }

     // Imprime el contenido del contenedor
    public void imprimirContenido(){
        Nodo<Producto> actual = inicio;  
        while (actual != null){  
            Producto producto = actual.getDato();  // Obtiene el producto del nodo actual
            producto.imprimir();  
            actual = actual.getSiguiente();  //  siguiente nodo
        }
    }

    // Verifica si existe un producto con un ID específico
    public boolean existeProducto(int id){
        Nodo<Producto> actual = inicio;  
        while(actual != null){  
            Producto producto = actual.getDato();  
            if( producto.getId() == id ) {  // Compara el ID del producto con el buscado
                return true;  // Retorna true si encuentra coincidencia
            }
            actual = actual.getSiguiente();  
        }
        return false;  // Retorna false si no encuentra el producto
    }

    // Verifica si existe un producto con un nombre específico
    public boolean existeProducto(String nombre){
        Nodo<Producto> actual = inicio;  
        while(actual != null){ 
            Producto producto = actual.getDato();  
            if( producto.getNombre().equals(nombre) ) {  // Compara el nombre del producto
                return true;  // Retorna true si encuentra coincidencia
            }
            actual = actual.getSiguiente();  
        }
        return false;  // Retorna false si no encuentra el producto
    }

    // Inserta un producto al inicio de la lista (sobrescribe método de la clase padre)
    @Override
    public void insertaInicio(Producto dato) {
        Nodo<Producto> nuevo = new Nodo<Producto>(dato);  // Crea un nuevo nodo con el producto
        if( vacio() ) {  
            inicio = ultimo = nuevo;  // El nuevo nodo es tanto inicio como fin
        }
        else {  // Si ya hay elementos
            nuevo.setSiguiente(inicio);  // El nuevo nodo apunta al actual inicio
            inicio = nuevo;  // El nuevo nodo se convierte en el inicio
        }
    }

  // Inserta un producto al final de la lista (sobrescribe método de la clase padre)
    @Override
    public void insertaFinal(Producto dato) {
        Nodo<Producto> nuevo = new Nodo<Producto>(dato);  // Crea un nuevo nodo con el producto
        if( vacio() ){  
            inicio = ultimo = nuevo;  // El nuevo nodo es tanto inicio como fin
        }
        else{  // Si ya hay elementos
            ultimo.setSiguiente(nuevo);  // El último actual apunta al nuevo nodo
            ultimo = nuevo;  // El nuevo nodo se convierte en el último
        }
    }

    // Elimina y retorna el producto del inicio de la lista (sobrescribe método de la clase padre)
    @Override
    public Producto eliminaInicio() {
        if ( vacio() ){ 
            return null;  // Retorna null porque no hay nada que eliminar
        }
        Producto productoEliminado = inicio.getDato();  // Guarda el producto que se va a eliminar
        inicio = inicio.getSiguiente();  // apuntar siguiente nodo

        // Si después de eliminar el inicio queda vacio osea hay solo un nodo
        if( inicio == null ) {
            ultimo = null;  // se actualiza último a null
        }
        return productoEliminado;  // Retorna el producto eliminado
    }


   // Elimina y retorna el producto del final de la lista (sobrescribe método de la clase padre)
    @Override
    public Producto eliminaFinal() {
        if( vacio() ) {  
            return null;  // Retorna null porque no hay nada que eliminar
        }

        Producto productoEliminado = ultimo.getDato();  // Guarda el producto 
        if ( inicio == ultimo ){  // solo hay un elemento en la lista
            inicio = ultimo = null;  // vacio
        }
        else{  // más de un elemento
            Nodo<Producto> actual = inicio; 
            while( actual.getSiguiente() != ultimo ){  // Busca el penúltimo nodo
                actual = actual.getSiguiente();  // Avanza hasta encontrar el penúltimo
            }
            actual.setSiguiente(null);  //se convierte en el ultimo
            ultimo = actual;  // Actualiza el puntero
        }
        return productoEliminado;  // Retorna el producto eliminado
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
