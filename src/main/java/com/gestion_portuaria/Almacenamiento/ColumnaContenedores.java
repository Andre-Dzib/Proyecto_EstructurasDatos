package com.gestion_portuaria.Almacenamiento;

import com.gestion_portuaria.Carga.Contenedor;
import com.gestion_portuaria.Estructuras.ListaSimple;
import com.gestion_portuaria.Estructuras.Pila;

public class ColumnaContenedores implements Pila<Contenedor> {
    protected ListaSimple<Contenedor> contenedores;  // Lista que almacena los contenedores
    protected int max;  // Capacidad máxima de la columna

    // Constructor: Crea columna vacía con capacidad máxima
    public ColumnaContenedores(int max) {
        contenedores = new ListaSimple<Contenedor>();  // Inicializa lista vacía
        this.max = max;  // Establece límite de contenedores
    }

    public boolean isFull() {
        return size() >= max;
    }

    public int getMax() {
        return max;
    }

    // Igual que meterContenedor: apila contenedor si hay espacio (no retorna nada)
    @Override
    public void push(Contenedor x) {
        if( size() >= max ) {  // Verifica capacidad
            return;  // Ignora si columna llena
        }
        contenedores.insertaInicio(x);  // Inserta al inicio de la lista
    }

    // Remueve y retorna contenedor de la cima, o null si vacía
    @Override
    public Contenedor pop() {
        if( isEmpty() ){  // Verifica si hay elementos
            System.out.println("La pila esta vacia");  // Mensaje error
            return null;  // Retorna null si vacía
        }
        return contenedores.eliminaInicio();  // Elimina y retorna primer elemento
    }
    
    // Retorna contenedor en cima sin removerlo, o null si vacía
    @Override
    public Contenedor top() {
        if( isEmpty() ){  // Verifica si hay elementos
            System.out.println("La pila esta vacía");  // Mensaje error
            return null;  // Retorna null si vacía
        }
        return contenedores.getInicio().getDato();  // Obtiene dato del primer nodo
    }

    // Retorna cantidad actual de contenedores en columna
    @Override
    public int size() {
        return contenedores.getSize();  // Delegado a lista simple
    }

    // Retorna true si columna vacía, false si tiene contenedores
    @Override
    public boolean isEmpty() {
        return contenedores.vacio();  // Delegado a lista simple
    }
}
