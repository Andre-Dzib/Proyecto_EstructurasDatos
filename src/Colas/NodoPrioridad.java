/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colas;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ojeda
 */
public class NodoPrioridad implements Comparable {

    private int prioridad;
    private Object dato;

    public NodoPrioridad(int prioridad, Object dato) {
        this.prioridad = prioridad;
        this.dato = dato;
    }
    
    public String toString(){
        return prioridad + ":" + dato;
    }
    
    @Override
    public int compareTo(Object o) {
            if(this.prioridad < ((NodoPrioridad)o).prioridad)
            return -1;
            else if (this.prioridad > ((NodoPrioridad)o).prioridad)

                    return 1;
            else 
             return 0;
            }

    /**
     * @return the prioridad
     */
    protected int getPrioridad() {
        return prioridad;
    }

    /**
     * @param prioridad the prioridad to set
     */
    protected void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * @return the dato
     */
    protected Object getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    protected void setDato(Object dato) {
        this.dato = dato;
    }
 
    public static void main(String[] args) {
        ArrayList datos = new ArrayList();
        datos.add(new NodoPrioridad(25,"Hola1"));
        datos.add(new NodoPrioridad(23,"Hola2"));
        datos.add(new NodoPrioridad(5,"Hola3")); 
        datos.add(new NodoPrioridad(80,"Hola4"));
        datos.add(new NodoPrioridad(4,"Hola5"));
           Collections.sort(datos);
           System.out.println(datos);
            
    }
    
}
