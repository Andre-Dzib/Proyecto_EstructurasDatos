package com.gestion_portuaria.Distribucion;

import com.gestion_portuaria.Carga.Contenedor;
import com.gestion_portuaria.Estructuras.ListaD;
import com.gestion_portuaria.Estructuras.ListaSimple;
import com.gestion_portuaria.Estructuras.NodoDoble;

public class Ruta extends ListaD<Parada> {
    private ListaSimple<Contenedor> contenedores;
    private NodoDoble<Parada> paradaActual;

    public Ruta() {
        inicio = ultimo = paradaActual = null;
        contenedores = null;
    }

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

    public NodoDoble<Parada> buscarParada(String nombre) {
        NodoDoble<Parada> actual = inicio, nodo = null;

        do {
            if( nombre.contentEquals( actual.getDato().getNombre() )) {
                nodo = actual;
                break;
            }
            actual = actual.getSiguiente();
        } while( actual != inicio );

        return nodo;
    }


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

    public static void main(String[] args) {
        Ruta ruta = new Ruta();

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
