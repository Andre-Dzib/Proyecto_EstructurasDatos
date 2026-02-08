package com.gestion_portuaria.Distribucion;

import com.gestion_portuaria.Estructuras.ListaD;
import com.gestion_portuaria.Estructuras.NodoDoble;

public class Ruta extends ListaD<Parada> {

    //Crea una ruta sin paradas
    public Ruta() {
        inicio = ultimo = null;  //punteros null
    }

    //Crea ruta con primera parada
    public Ruta(Parada parada) {
        insertaInicio(parada);  // Inserta la parada recibida como inicio
    }

    // Busca una parada por ID en la ruta circular
    public NodoDoble<Parada> buscarParada(int id) {
        NodoDoble<Parada> actual = inicio, nodo = null;  // Inicia recorrido desde inicio

        do {  // Recorre lista circularmente
            if( id == actual.getDato().getId() ) {  // Compara ID del nodo actual
                nodo = actual;  // Guarda nodo encontrado
                break;  
            }
            actual = actual.getSiguiente();  // Avanza al siguiente nodo
        } while( actual != inicio );  // Condición para lista circular

        return nodo;  // Retorna nodo encontrado o null
    }

    // Busca una parada por nombre en la ruta circular
    public NodoDoble<Parada> buscarParada(String nombre) {
        NodoDoble<Parada> actual = inicio, nodo = null;  

        do {  // Recorre lista circularmente
            if( nombre.contentEquals( actual.getDato().getNombre() )) {  // Compara nombre
                nodo = actual;  // Guarda nodo encontrado
                break;  
            }
            actual = actual.getSiguiente();  
        } while( actual != inicio );  // Condición para lista circular

        return nodo;  // Retorna nodo encontrado o null
    }

    // Inserta nueva parada después de una parada específica (usando objeto Parada)
    public void insertaDespuesDe(Parada busqueda, Parada nueva) {
        if( vacio() ) {  
            return;  // No hace nada si no hay paradas
        }

        NodoDoble<Parada> nodo = buscarParada(busqueda.getId());  // Busca nodo de referencia
        if( nodo == null ) {  
            return;  // Termina sin insertar
        }

        // Crea nuevo nodo con parada nueva
        NodoDoble<Parada> nuevoNodo = new NodoDoble<Parada>(nueva);
        
        nuevoNodo.setAnterior(nodo);  // Anterior del nuevo es nodo referencia
        nuevoNodo.setSiguiente(nodo.getSiguiente());  // Siguiente del nuevo es siguiente del referencia
        nodo.getSiguiente().setAnterior(nuevoNodo);  // Anterior del siguiente apunta al nuevo
        nodo.setSiguiente(nuevoNodo);  // Siguiente del referencia apunta al nuevo
    }

    // Inserta nueva parada después de una parada específica 
    public void insertaDespuesDe(String nombre, Parada nueva) {
        if( vacio() ) {  
            return;  // No hace nada si no hay paradas
        }

        NodoDoble<Parada> nodo = buscarParada(nombre);  // Busca nodo por nombre
        if( nodo == null ) {  
            return;  // Termina sin insertar
        }

        // Crea nuevo nodo con parada nueva
        NodoDoble<Parada> nuevoNodo = new NodoDoble<Parada>(nueva);
        
        nuevoNodo.setAnterior(nodo);
        nuevoNodo.setSiguiente(nodo.getSiguiente());
        nodo.getSiguiente().setAnterior(nuevoNodo);
        nodo.setSiguiente(nuevoNodo);
    }

    // Inserta nueva parada después de una parada específica 
    public void insertaDespuesDe(int id, Parada nueva) {
        if( vacio() ) {  
            return;  // No hace nada si no hay paradas
        }

        NodoDoble<Parada> nodo = buscarParada(id);  // Busca nodo por ID
        if( nodo == null ) {  
            return;  // Termina sin insertar
        }

        // Crea nuevo nodo con parada nueva
        NodoDoble<Parada> nuevoNodo = new NodoDoble<Parada>(nueva);
        // Configura enlaces (igual que métodos anteriores)
        nuevoNodo.setAnterior(nodo);
        nuevoNodo.setSiguiente(nodo.getSiguiente());
        nodo.getSiguiente().setAnterior(nuevoNodo);
        nodo.setSiguiente(nuevoNodo);
    }

    
    public void cancelarParada(Parada cancelada) {
        if( vacio() ) {  
            return;  // No hace nada si no hay paradas
        }

        NodoDoble<Parada> nodo = buscarParada(cancelada.getId());  // Busca nodo a eliminar
        if( nodo == null ) {  
            return;  // Termina sin eliminar
        }

        // Caso 1: Único nodo en la lista
        if (nodo == inicio && inicio == ultimo) {
            inicio = ultimo = null;  // Lista queda vacía
            return;
        } 
        // Caso 2: Nodo es el inicio
        else if (nodo == inicio) {
            inicio = nodo.getSiguiente();  // Nuevo inicio es siguiente nodo
            return;
        } 
        // Caso 3: Nodo es el último
        else if (nodo == ultimo) {
            ultimo = nodo.getAnterior();  // Nuevo último es anterior nodo
            return;
        }

        // Caso 4: Nodo está en medio
        
        nodo.getAnterior().setSiguiente(nodo.getSiguiente());
        nodo.getSiguiente().setAnterior(nodo.getAnterior());
    }

 
    public void cancelarParada(String nombre) {
        if (vacio()) {  
            return;  // No hace nada si no hay paradas
        }

        NodoDoble<Parada> nodo = buscarParada(nombre);  // Busca nodo 
        if (nodo == null) { 
            return;  // Termina sin eliminar
        }

      
        if (nodo == inicio && inicio == ultimo) {
            inicio = ultimo = null;
            return;
        } else if (nodo == inicio) {
            inicio = nodo.getSiguiente();
            return;
        } else if (nodo == ultimo) {
            ultimo = nodo.getAnterior();
            return;
        }

        
        nodo.getAnterior().setSiguiente(nodo.getSiguiente());
        nodo.getSiguiente().setAnterior(nodo.getAnterior());
    }


    public void cancelarParada(int id) {
        if( vacio() ) { 
            return;  // No hace nada 
        }

        NodoDoble<Parada> nodo = buscarParada(id);  // Busca nodo por ID
        if( nodo == null ) {  
            return;  // Termina sin eliminar
        }

        // Casos especiales iguales a métodos anteriores
        if( nodo == inicio && inicio == ultimo ) {
            inicio = ultimo = null;
            return;
        }
        else if( nodo == inicio ) {
            inicio = nodo.getSiguiente();
            return;
        }
        else if ( nodo == ultimo ) {
            ultimo = nodo.getAnterior();
            return;
        }

        // Reconexión para nodo en medio
        nodo.getAnterior().setSiguiente(nodo.getSiguiente());
        nodo.getSiguiente().setAnterior(nodo.getAnterior());
    }

    // Inserta una parada al inicio
    @Override
    public void insertaInicio(Parada dato) {
        NodoDoble<Parada> insertar = new NodoDoble<Parada>(dato);  // Crea nuevo nodo
        if( vacio() ) {  // Si lista vacía
            inicio = ultimo = insertar;  // Único nodo es inicio y fin
            inicio.setSiguiente(null); 
            inicio.setAnterior(null);
            return;
        }

   
        insertar.setSiguiente(null);
        insertar.setSiguiente(inicio);  // Nuevo apunta al antiguo inicio
        inicio.setAnterior(insertar);  // Antiguo inicio apunta al nuevo como anterior
        inicio = insertar;  // Nuevo nodo se convierte en inicio
    }

    // Inserta una parada al final
    @Override
    public void insertaFinal(Parada dato) {
        NodoDoble<Parada> insertar = new NodoDoble<Parada>(dato);  // Crea nuevo nodo
        if( vacio() ) { 
            inicio = ultimo = insertar;  // Único nodo es inicio y fin
            inicio.setSiguiente(null); 
            inicio.setAnterior(null);
            return;
        }

        
        insertar.setSiguiente(null);
        insertar.setAnterior(ultimo);  // Nuevo apunta al antiguo último como anterior
        ultimo.setSiguiente(insertar);  // Antiguo último apunta al nuevo como siguiente
        ultimo = insertar;  // Nuevo nodo se convierte en último
    }

    
    @Override
    public Parada eliminaInicio() {
        Parada eliminado = inicio.getDato();  // Guarda dato a eliminar

        if( inicio == ultimo ) {  
            inicio = ultimo = null; 
            return eliminado;  // Retorna parada eliminada
        }

        // Reconfigura enlaces
        inicio.getSiguiente().setAnterior(null);  
        inicio = inicio.getSiguiente();  // Nuevo inicio es el siguiente nodo

        return eliminado;  // Retorna parada eliminada
    }

    
    @Override
    public Parada eliminaFinal() {
        Parada eliminado = ultimo.getDato();  // Guarda dato a eliminar

        if( inicio == ultimo ) {  
            inicio = ultimo = null;  // Lista queda vacía
            return eliminado;  // Retorna parada eliminada
        }

       
        ultimo.getAnterior().setSiguiente(null);  
        ultimo = ultimo.getAnterior();  // Nuevo último es el anterior nodo

        return eliminado;  // Retorna parada eliminada
    }

    // Método main para pruebas de la clase Ruta
    public static void main(String[] args) {
        Ruta ruta = new Ruta(); 

        // Inserta varias paradas
        ruta.insertaFinal(new Parada(10, "dirección 10"));
        ruta.insertaFinal(new Parada(8, "dirección 8"));
        ruta.insertaFinal(new Parada(9, "dirección 9"));
        ruta.insertaFinal(new Parada(5, "dirección 5"));
        ruta.insertaInicio(new Parada(0, "dirección 0"));
        ruta.insertaInicio(new Parada(12, "dirección 12"));

        ruta.imprimir();  

        System.out.println("======================================");

        ruta.cancelarParada(12); 
        ruta.imprimir(); 

        System.out.println("======================================");

        ruta.insertaDespuesDe(8, new Parada(20, "dirección 20"));  
        ruta.imprimir();  
    }
}
