package com.gestion_portuaria.Controladores;

import com.gestion_portuaria.Estructuras.ListaSimple;
import com.gestion_portuaria.Estructuras.Pila;
import com.gestion_portuaria.Vistas.Vista;

public class Vistas {
    public static Vista vistaActual = null;
    public static PilaVistas vistasAnteriores = new PilaVistas();

    public static class PilaVistas implements Pila<Vista> {
        ListaSimple<Vista> lista;

        public PilaVistas() {
            lista = new ListaSimple<Vista>();
        }

        @Override
        public void push(Vista x) {
            lista.insertaFinal(x);
        }

        @Override
        public Vista pop() {
            return lista.eliminaFinal();
        }

        @Override
        public Vista top() {
            return lista.getUltimo().getDato();
        }

        @Override
        public int size() {
            return lista.getSize();
        }

        @Override
        public boolean isEmpty() {
            return lista.vacio();
        }
    }
}
