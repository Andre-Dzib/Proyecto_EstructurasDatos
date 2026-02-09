package com.gestion_portuaria.Recepcion;

import com.gestion_portuaria.Estructuras.Queue;
import com.gestion_portuaria.Estructuras.ListaSimple;

/**
 * Clase que representa una cola de camiones en el sistema de recepción del puerto.
 * Implementa la interfaz Queue utilizando una Lista simplemente ligada
 * para almacenar los camiones en orden de llegada.
 */
public class ColaCamiones implements Queue<Camion> {
    /**
     * Lista interna que mantiene los camiones en la cola.
     */
    protected ListaSimple<Camion> colaCamiones;
    /**
     * Número de camiones actualmente en la cola.
     */
    protected int longitud;

    /**
     * Constructor por defecto.
     * Inicializa la cola vacía.
     */
    public ColaCamiones() {
        colaCamiones = new ListaSimple<Camion>();
        longitud = 0;
    }

    /**
     * Agrega un camión al final de la cola (llega a la recepción).
     * @param dato El camión a encolar
     */
    @Override
    public void enqueue(Camion dato) {
        colaCamiones.insertaFinal(dato);
        longitud++;
    }

    /**
     * Elimina y retorna el camión al frente de la cola (siguiente en atención).
     * @return El camión desencolado, o null si la cola está vacía
     */
    @Override
    public Camion dequeue() {
        longitud--;
        return colaCamiones.eliminaInicio();
    }

    /**
     * Retorna el número de camiones actualmente en la cola.
     * @return tamaño actual de la cola
     */
    @Override
    public int size() {
        return longitud;
    }

    /**
     * Retorna el camión que está al frente de la cola sin eliminarlo.
     * @return El camión al frente, o null si la cola está vacía
     */
    @Override
    public Camion front() {
        return colaCamiones.getInicio().getDato();
    }

    /**
     * Verifica si la cola está vacía.
     * @return true si no hay camiones en la cola, false en caso contrario
     */
    @Override
    public boolean isEmpty() {
        return colaCamiones.vacio();
    }
}