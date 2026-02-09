package com.gestion_portuaria.Distribucion;

import com.gestion_portuaria.Carga.Contenedor;
import com.gestion_portuaria.Estructuras.ListaD;
import com.gestion_portuaria.Estructuras.ListaSimple;
import com.gestion_portuaria.Estructuras.NodoDoble;

/**
 * Clase que representa una ruta de distribución compuesta por una lista simple de paradas.
 * La ruta permite recorrer sus paradas, insertar nuevas paradas en posiciones específicas y cancelar paradas existentes.
 * Además, mantiene una referencia a la parada actual y a los contenedores asignados a la ruta.
 */
public class Ruta extends ListaD<Parada> {
    /**
     * Lista de contenedores asociados a la ruta para su distribución.
     */
    private ListaSimple<Contenedor> contenedores;
    /**
     * Referencia a la parada actual dentro de la ruta.
     */
    private NodoDoble<Parada> paradaActual;

    /**
     * Crea una ruta vacía sin paradas ni contenedores asignados.
     */
    public Ruta() {
        inicio = ultimo = paradaActual = null;
        contenedores = null;
    }

    /**
     * Crea una ruta con una primera parada inicial.
     * @param parada La parada inicial de la ruta
     */
    public Ruta(Parada parada) {
        insertaInicio(parada);
        contenedores = null;
    }

    /**
     * Retorna la parada en la que se encuentra el barco actualmente
     * @return La parada actual
     */
    public NodoDoble<Parada> getParadaActual() {
        return paradaActual;
    }

    /**
     * El barco navega hacia la siguiente parada
     */
    public void siguienteParada() {
        if( paradaActual == ultimo ) {
            return;
        }

        paradaActual = paradaActual.getSiguiente();
    }

    /**
     * El barco navega hacia la parada anterior
     */
    public void anteriorParada() {
        if( paradaActual == inicio ) {
            return;
        }

        paradaActual = paradaActual.getAnterior();
    }

    /**
     * Asigna los contenedores a la ruta
     * @param contenedores Los contenedores asignados a la ruta
     */
    public void setContenedores(ListaSimple<Contenedor> contenedores) {
        this.contenedores = contenedores;
    }

    /**
     * Retorna la cantidad total de paradas que conforman la ruta
     * @return La cantidad de paradas que contiene la ruta
     */
    public int size() {
        NodoDoble<Parada> actual = inicio;
        int longitud = 0;
        while( actual != null ) {
            longitud++;
            actual = actual.getSiguiente();
        }

        return longitud;
    }

    /**
     * Busca una parada por medio de su identificador
     * @param id El identificador de la parada a buscar
     * @return La parada especificada, o null si no se encontró
     */
    public NodoDoble<Parada> buscarParada(int id) {
        NodoDoble<Parada> actual = inicio, nodo = null;

        do {
            if( id == actual.getDato().getId() ) {
                nodo = actual;
                break;  
            }
            actual = actual.getSiguiente();
        } while( actual != inicio );

        return nodo;
    }

    /**
     * Busca una parada por medio de su nombre
     * @param nombre El nombre de la parada a buscar
     * @return La parada especificada, o null si no se encontró
     */
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

    /**
     * Inserta una parada después de la específicada
     * Si la ruta no tiene paradas o no encuentra la parada especificada entonces no hace nada
     * @param busqueda La parada que estará antes de la nueva a ingresar
     * @param nueva La parada que se va a ingresar a la ruta
     */
    public void insertaDespuesDe(Parada busqueda, Parada nueva) {
        if( vacio() ) {  
            return;
        }

        NodoDoble<Parada> nodo = buscarParada(busqueda.getId());
        if( nodo == null ) {  
            return;
        }


        NodoDoble<Parada> nuevoNodo = new NodoDoble<Parada>(nueva);
        
        nuevoNodo.setAnterior(nodo);
        nuevoNodo.setSiguiente(nodo.getSiguiente());
        nodo.getSiguiente().setAnterior(nuevoNodo);
        nodo.setSiguiente(nuevoNodo);
    }

    /**
     * Inserta una parada después de la específicada
     * Si la ruta no tiene paradas o no encuentra la parada especificada entonces no hace nada
     * @param nombre El nombre de la parada que estará antes de la nueva a ingresar
     * @param nueva La parada que se va a ingresar a la ruta
     */
    public void insertaDespuesDe(String nombre, Parada nueva) {
        if( vacio() ) {  
            return;
        }

        NodoDoble<Parada> nodo = buscarParada(nombre);
        if( nodo == null ) {  
            return;
        }


        NodoDoble<Parada> nuevoNodo = new NodoDoble<Parada>(nueva);
        
        nuevoNodo.setAnterior(nodo);
        nuevoNodo.setSiguiente(nodo.getSiguiente());
        nodo.getSiguiente().setAnterior(nuevoNodo);
        nodo.setSiguiente(nuevoNodo);
    }

    /**
     * Inserta una parada después de la específicada
     * Si la ruta no tiene paradas o no encuentra la parada especificada entonces no hace nada
     * @param id El identificador de la parada que estará antes de la nueva a ingresar
     * @param nueva La parada que se va a ingresar a la ruta
     */
    public void insertaDespuesDe(int id, Parada nueva) {
        if( vacio() ) {  
            return;
        }

        NodoDoble<Parada> nodo = buscarParada(id);
        if( nodo == null ) {  
            return;
        }

        if( nodo == ultimo ) {
            insertaFinal(nueva);
            return;
        }

        NodoDoble<Parada> nuevoNodo = new NodoDoble<Parada>(nueva);

        nuevoNodo.setAnterior(nodo);
        nuevoNodo.setSiguiente(nodo.getSiguiente());
        nodo.getSiguiente().setAnterior(nuevoNodo);
        nodo.setSiguiente(nuevoNodo);
    }

    /**
     * Cancela la parada especificada y reasigna la ruta para continuar omitiéndola
     * Actualiza la parada actual si es necesario
     * @param nombre El nombre de la ruta a cancelar
     */
    public void cancelarParada(String nombre) {
        if (vacio()) {  
            return;
        }

        NodoDoble<Parada> nodo = buscarParada(nombre);
        if (nodo == null) { 
            return;
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

    /**
     * Cancela la parada especificada y reasigna la ruta para continuar omitiéndola
     * Actualiza la parada actual si es necesario
     * @param id El identificador de la ruta a cancelar
     */
    public void cancelarParada(int id) {
        if( vacio() ) { 
            return;
        }

        NodoDoble<Parada> nodo = buscarParada(id);
        if( nodo == null ) {  
            return;
        }


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

        nodo.getAnterior().setSiguiente(nodo.getSiguiente());
        nodo.getSiguiente().setAnterior(nodo.getAnterior());
    }

    /**
     * Inserta una parada al inicio de la ruta
     * @param dato La parada a insertar
     */
    @Override
    public void insertaInicio(Parada dato) {
        NodoDoble<Parada> insertar = new NodoDoble<Parada>(dato);
        if( vacio() ) {
            inicio = ultimo = insertar;
            inicio.setSiguiente(null); 
            inicio.setAnterior(null);
            paradaActual = inicio;

            return;
        }

   
        insertar.setSiguiente(null);
        insertar.setSiguiente(inicio);
        inicio.setAnterior(insertar);
        inicio = insertar;
    }

    /**
     * Inserta una parada al final de la ruta
     * @param dato La parada a insertar
     */
    @Override
    public void insertaFinal(Parada dato) {
        NodoDoble<Parada> insertar = new NodoDoble<Parada>(dato);
        if( vacio() ) { 
            inicio = ultimo = insertar;
            inicio.setSiguiente(null); 
            inicio.setAnterior(null);
            paradaActual = ultimo;

            return;
        }

        
        insertar.setSiguiente(null);
        insertar.setAnterior(ultimo);
        ultimo.setSiguiente(insertar);
        ultimo = insertar;
    }

    /**
     * Elimina la primera parada de la ruta
     * @return La parada eliminada
     */
    @Override
    public Parada eliminaInicio() {
        Parada eliminado = inicio.getDato();

        if( inicio == ultimo ) {
            inicio = ultimo = paradaActual = null;
            return eliminado;
        }

        inicio.getSiguiente().setAnterior(null);

        if( paradaActual == inicio ) {
            paradaActual = inicio.getSiguiente();
        }

        inicio = inicio.getSiguiente();

        return eliminado;
    }

    /**
     * Elimina la ultima parada de la ruta
     * @return La parada eliminada
     */
    @Override
    public Parada eliminaFinal() {
        Parada eliminado = ultimo.getDato();

        if( inicio == ultimo ) {
            inicio = ultimo = paradaActual = null;
            return eliminado;
        }

        ultimo.getAnterior().setSiguiente(null);

        if( paradaActual == ultimo ) {
            paradaActual = ultimo.getAnterior();
        }

        ultimo = ultimo.getAnterior();

        return eliminado;
    }

    /**
     * Representación en texto de la ruta
     * @return El nombre de la primera parada, si no se ha establecido entonces retorna "Nueva ruta"
     */
    @Override
    public String toString() {
        return inicio == null ? "Nueva ruta" : inicio.getDato().getNombre();
    }
}