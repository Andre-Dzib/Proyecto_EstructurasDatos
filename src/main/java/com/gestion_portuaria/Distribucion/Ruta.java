package com.gestion_portuaria.Distribucion;

import com.gestion_portuaria.Estructuras.ListaD;
import com.gestion_portuaria.Estructuras.NodoDoble;

public class Ruta extends ListaD<Parada> {

    public Ruta() {
        inicio = ultimo = null;
    }

    public Ruta(Parada parada) {
        insertaInicio(parada);
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

        NodoDoble<Parada> nuevoNodo = new NodoDoble<Parada>(nueva);
        nuevoNodo.setAnterior(nodo);
        nuevoNodo.setSiguiente(nodo.getSiguiente());
        nodo.getSiguiente().setAnterior(nuevoNodo);
        nodo.setSiguiente(nuevoNodo);
    }

    public void cancelarParada(Parada cancelada) {
        if( vacio() ) {
            return;
        }

        NodoDoble<Parada> nodo = buscarParada(cancelada.getId());
        if( nodo == null ) {
            return;
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

    public void cancelarParada(String nombre) {
        if (vacio()) {
            return;
        }

        NodoDoble<Parada> nodo = buscarParada(nombre);
        if (nodo == null) {
            return;
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
            return;
        }

        NodoDoble<Parada> nodo = buscarParada(id);
        if( nodo == null ) {
            return;
        }

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
            inicio = ultimo = null;
            return eliminado;
        }

        inicio.getSiguiente().setAnterior(null);
        inicio = inicio.getSiguiente();

        return eliminado;
    }

    @Override
    public Parada eliminaFinal() {
        Parada eliminado = ultimo.getDato();

        if( inicio == ultimo ) {
            inicio = ultimo = null;
            return eliminado;
        }

        ultimo.getAnterior().setSiguiente(null);
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
}
