package com.gestion_portuaria.Almacenamiento;

import com.gestion_portuaria.Carga.Contenedor;
import com.gestion_portuaria.Estructuras.ListaSimple;
import com.gestion_portuaria.Estructuras.Pila;

/**
 * Se representa una columna de contenedores como una pila, donde un contenedor
 * de abajo no se puede acceder sin quitar uno de los de encima.
 * Permite checar su capacidad, meter, sacar y checar los contenedores que hay en la columna.
 */
public class ColumnaContenedores implements Pila<Contenedor> {
    /**
     * Lista que almacena los contenedores
     */
    protected ListaSimple<Contenedor> contenedores;
    /**
     * Capacidad máxima de la columna
     */
    protected int max;

    /**
     * Constructor por defecto de la clase, se le tiene que especificar un máximo a la pila creada
     */
    public ColumnaContenedores(int max) {
        contenedores = new ListaSimple<Contenedor>();
        this.max = max;
    }

    /**
     * Indica si la pila de contenedores está llena, si es el caso retorna verdadero
     * @return true si la pila está llena, en otro caso falso
     */
    public boolean isFull() {
        return size() >= max;
    }

    /**
     * Getter del tope máximo de la pila
     * @return El valor máximo de la pila
     */
    public int getMax() {
        return max;
    }

    /**
     * Ingresar un contenedor a la pila
     * @param x El contenedor que se desea ingresar a la pila
     */
    @Override
    public void push(Contenedor x) {
        if( size() >= max ) {
            // Ignora si columna llena
            return;
        }
        contenedores.insertaInicio(x);
    }

    /**
     * Remueve el contenedor que está en la cima de la pila
     * @return El contenedor de la cima, o si la pila está vacía null
     */
    @Override
    public Contenedor pop() {
        if( isEmpty() ){
            return null;
        }
        return contenedores.eliminaInicio();  // Elimina y retorna primer elemento
    }

    /**
     * Retorna el contenedor de la cima de la pila
     * @return El contenedor de la cima, o si la pila está vacía null
     */
    @Override
    public Contenedor top() {
        if( isEmpty() ){
            return null;
        }
        return contenedores.getInicio().getDato(); // Obtiene dato del primer nodo
    }

    /**
     * Getter del tamaño de la pila
     * @return El tamaño de la pila
     */
    @Override
    public int size() {
        return contenedores.getSize();
    }

    /**
     * Verifica si la pila está vacía
     * @return Booleano que representa si la pila está vacía o no
     */
    @Override
    public boolean isEmpty() {
        return contenedores.vacio();
    }
}
