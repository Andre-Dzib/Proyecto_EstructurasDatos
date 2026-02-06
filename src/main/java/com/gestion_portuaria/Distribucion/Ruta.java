package com.gestion_portuaria.Distribucion;

import com.gestion_portuaria.Estructuras.ListaD;
import com.gestion_portuaria.Estructuras.NodoDoble;

public class Ruta extends ListaD<Parada> {

    public Ruta() {
        this(null);
    }

    public Ruta(Parada parada) {
        insertaInicio(parada);
    }

    public void insertarDespuesDe(Parada nueva, Parada despues) {

    }

    public void cancelarParada(Parada cancelada) {

    }

    @Override
    public void insertaInicio(Parada dato) {
        NodoDoble<Parada> insertar = new NodoDoble<Parada>(dato);
        if( vacio() ) {
            inicio = ultimo = insertar;
            inicio.setAnterior(insertar);
            inicio.setSiguiente(insertar);
            ultimo.setAnterior(insertar);
            inicio.setSiguiente(insertar);

            return;
        }

        inicio.setAnterior(insertar);
        ultimo.setSiguiente(insertar);
        insertar.setSiguiente(inicio);
        insertar.setAnterior(ultimo);
        inicio = insertar;
    }

    @Override
    public void insertaFinal(Parada dato) {
        NodoDoble<Parada> insertar = new NodoDoble<Parada>(dato);
        if( vacio() ) {
            inicio = ultimo = insertar;
            inicio.setAnterior(insertar);
            inicio.setSiguiente(insertar);
            ultimo.setAnterior(insertar);
            inicio.setSiguiente(insertar);

            return;
        }

        inicio.setAnterior(insertar);
        ultimo.setSiguiente(insertar);
        insertar.setSiguiente(inicio);
        insertar.setAnterior(ultimo);
        ultimo = insertar;
    }

    @Override
    public Parada eliminaInicio() {
        Parada eliminado = inicio.getDato();

        if( inicio == ultimo ) {
            inicio = ultimo = null;
            return eliminado;
        }

        inicio.getSiguiente().setAnterior(ultimo);
        ultimo.setSiguiente(inicio.getSiguiente());

        return eliminado;
    }

    @Override
    public Parada eliminaFinal() {
        Parada eliminado = ultimo.getDato();

        if( inicio == ultimo ) {
            inicio = ultimo = null;
            return eliminado;
        }

        ultimo.getAnterior().setSiguiente(inicio);
        inicio.setAnterior(ultimo.getAnterior());
        return eliminado;
    }
}
