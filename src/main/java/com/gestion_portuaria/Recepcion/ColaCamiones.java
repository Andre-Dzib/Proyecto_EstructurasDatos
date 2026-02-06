package com.gestion_portuaria.Recepcion;

import com.gestion_portuaria.Estructuras.Queue;
import com.gestion_portuaria.Estructuras.ListaSimple;

public class ColaCamiones implements Queue<Camion> {
    protected ListaSimple<Camion> colaCamiones;
    protected int longitud;
    
    ColaCamiones() {
        colaCamiones = new ListaSimple<Camion>();
        longitud = 0;
    }

    @Override
    public void enqueue(Camion dato) {
        colaCamiones.insertaFinal(dato);
        longitud++;
    }

    @Override
    public Camion dequeue() {
        return colaCamiones.eliminaInicio();
    }

    @Override
    public int size() {
        return longitud;
    }

    @Override
    public Camion front() {
        return colaCamiones.getInicio().getDato();
    }
    @Override
    public boolean isEmpty() {
        return colaCamiones.vacio();
    }
}
