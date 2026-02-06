package com.gestion_portuaria.Almacenamiento;

import com.gestion_portuaria.Carga.Contenedor;
import com.gestion_portuaria.Estructuras.ListaSimple;
import com.gestion_portuaria.Estructuras.Pila;

public class ColumnaContenedores implements Pila<Contenedor> {
    protected ListaSimple<Contenedor> contenedores;
    protected int max;

    public ColumnaContenedores(int max) {
        contenedores = new ListaSimple<Contenedor>();
        this.max = max;
    }

    public void meterContenedor(Contenedor contenedor){
        if( size() >= max ) {
            return;
        }
        contenedores.insertaInicio(contenedor);
    }

    @Override
    public void push(Contenedor x) {
        if( size() >= max ) {
            return;
        }
        contenedores.insertaInicio(x);
    }

    @Override
    public Contenedor pop() {
        if( isEmpty() ){
            System.out.println("La pila esta vacia");
            return null;
        }

        return contenedores.eliminaInicio();
    }
    
    @Override
    public Contenedor top() {
        if( isEmpty() ){
            System.out.println("La pila esta vacía");
            return null;
        }

        return contenedores.getInicio().getDato();
    }

    @Override
    public int size() {
        return contenedores.getSize();
    }

    @Override
    public boolean isEmpty() {
        return contenedores.vacio();
    }
    
}
