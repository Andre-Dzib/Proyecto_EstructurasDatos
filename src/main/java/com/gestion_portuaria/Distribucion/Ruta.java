package com.gestion_portuaria.Distribucion;

import com.gestion_portuaria.Carga.Contenedor;
import com.gestion_portuaria.Estructuras.ListaD;
import com.gestion_portuaria.Estructuras.ListaSimple;
import com.gestion_portuaria.Estructuras.NodoDoble;

public class Ruta extends ListaD<Parada> {
    private ListaSimple<Contenedor> contenedores;
    private NodoDoble<Parada> paradaActual;

    //Crea una ruta sin paradas
    public Ruta() {
        inicio = ultimo = paradaActual = null;
        contenedores = null;
    }

    //Crea ruta con primera parada
    public Ruta(Parada parada) {
        insertaInicio(parada);
        contenedores = null;
    }

    public NodoDoble<Parada> getParadaActual() {
        return paradaActual;
    }

    public void siguienteParada() {
        if( paradaActual == ultimo ) {
            return;
        }

        paradaActual = paradaActual.getSiguiente();
    }

    public void anteriorParada() {
        if( paradaActual == inicio ) {
            return;
        }

        paradaActual = paradaActual.getAnterior();
    }

    public void setContenedores(ListaSimple<Contenedor> contenedores) {
        this.contenedores = contenedores;
    }

    public int size() {
        NodoDoble<Parada> actual = inicio;
        int longitud = 0;
        while( actual != null ) {
            longitud++;
            actual = actual.getSiguiente();
        }

        return longitud;
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

        if( nodo == ultimo ) {
            insertaFinal(nueva);
            return;
        }

        NodoDoble<Parada> nuevoNodo = new NodoDoble<Parada>(nueva);
        // Configura enlaces (igual que métodos anteriores)
        nuevoNodo.setAnterior(nodo);
        nuevoNodo.setSiguiente(nodo.getSiguiente());
        nodo.getSiguiente().setAnterior(nuevoNodo);
        nodo.setSiguiente(nuevoNodo);
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
            inicio = ultimo = paradaActual = null;
            return;
        } else if (nodo == inicio) {
            inicio = nodo.getSiguiente();
            if( nodo == paradaActual ) {
                paradaActual = inicio;
            }
            return;
        } else if (nodo == ultimo) {
            ultimo = nodo.getAnterior();
            if( nodo == paradaActual ) {
                paradaActual = ultimo;
            }
            return;
        }

        if( nodo == paradaActual ) {
            paradaActual = nodo.getAnterior();
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
            inicio = ultimo = paradaActual = null;
            return;
        }
        else if( nodo == inicio ) {
            inicio = nodo.getSiguiente();
            inicio.setAnterior(null);
            if( nodo == paradaActual ) {
                paradaActual = inicio;
            }
            return;
        }
        else if ( nodo == ultimo ) {
            ultimo = nodo.getAnterior();
            ultimo.setSiguiente(null);
            if( nodo == paradaActual ) {
                paradaActual = ultimo;
            }
            return;
        }

        if( nodo == paradaActual ) {
            paradaActual = nodo.getAnterior();
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
            paradaActual = inicio;

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
            paradaActual = ultimo;

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
            inicio = ultimo = paradaActual = null;
            return eliminado;
        }

        inicio.getSiguiente().setAnterior(null);

        if( paradaActual == inicio ) {
            paradaActual = inicio.getSiguiente();
        }

        inicio = inicio.getSiguiente();

        return eliminado;  // Retorna parada eliminada
    }

    
    @Override
    public Parada eliminaFinal() {
        Parada eliminado = ultimo.getDato();  // Guarda dato a eliminar

        if( inicio == ultimo ) {
            inicio = ultimo = paradaActual = null;
            return eliminado;
        }

        ultimo.getAnterior().setSiguiente(null);

        if( paradaActual == ultimo ) {
            paradaActual = ultimo.getAnterior();
        }

        ultimo = ultimo.getAnterior();

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

    @Override
    public String toString() {
        return inicio == null ? "Nueva ruta" : inicio.getDato().getNombre();
    }
}
