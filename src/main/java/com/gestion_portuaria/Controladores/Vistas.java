package com.gestion_portuaria.Controladores;

import com.gestion_portuaria.Estructuras.ListaSimple;
import com.gestion_portuaria.Estructuras.Pila;
import com.gestion_portuaria.Vistas.Vista;

/**
 * Clase encargada de gestionar las vistas del sistema.
 * Mantiene la vista actualmente activa y un historial de vistas anteriores para permitir la navegación entre pantallas.
 */
public class Vistas {
    /**
     * Vista que se muestra actualmente en pantalla
     */
    public static Vista vistaActual = null;
    /**
     * Pila de vistas previamente mostradas, utilizada para regresar a vistas anteriores.
     */
    public static PilaVistas vistasAnteriores = new PilaVistas();

    /**
     * Clase interna que representa a la pila de vistas
     * Permite almacenar, recuperar y gestionar el historial de navegación entre vistas
     */
    public static class PilaVistas implements Pila<Vista> {
        /**
         * Lista interna utilizada para almacenar las vistas en orden de navegación
         */
        ListaSimple<Vista> lista;

        /**
         * Constructor de la pila de vistas
         * Inicializa la estructura interna utilizada para almacenar las vistas
         */
        public PilaVistas() {
            lista = new ListaSimple<Vista>();
        }

        /**
         * Inserta una vista en la pila
         * @param x La vista a ingresar
         */
        @Override
        public void push(Vista x) {
            lista.insertaFinal(x);
        }

        /**
         * Elimina el último elemento de la pila
         * @return La última vista de la pila
         */
        @Override
        public Vista pop() {
            return lista.eliminaFinal();
        }

        /**
         * Retorna la vista que se encuentra en la parte superior de la pila sin eliminarla
         * @return La vista del tope de la pila
         */
        @Override
        public Vista top() {
            return lista.getUltimo().getDato();
        }

        /**
         * Retorna la cantidad de vistas almacenadas en la pila
         * @return La cantidad de vistas almacenadas
         */
        @Override
        public int size() {
            return lista.getSize();
        }

        /**
         * Indica si la pila de vistas está vacía
         * @return true si está vacía, en otro caso, false
         */
        @Override
        public boolean isEmpty() {
            return lista.vacio();
        }
    }
}
