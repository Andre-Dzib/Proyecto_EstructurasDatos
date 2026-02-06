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
public class ColaPrioridadA implements Queue {
    protected ArrayList cola;
    
    public ColaPrioridadA(){
        cola = new ArrayList();
    }
    
  
    
    @Override
    public void enqueue(Object dato) {
        cola.add(dato);
        Collections.sort(cola);
    }

    @Override
    public Object dequeue() {
          return cola.remove(0);
    }

    @Override
    public int size() {
            return cola.size();
    }

    @Override
    public Object front() {
          return cola.get(0);
    }

    @Override
    public boolean isEmpty() {
        return cola.isEmpty();
    }
    
    public static void main(String[] args) {
        ColaPrioridadA colap = new ColaPrioridadA();
        colap.enqueue(new NodoPrioridad(25,"Hola1"));
        colap.enqueue(new NodoPrioridad(20,"Hola2"));
        colap.enqueue(new NodoPrioridad(85,"Hola3"));
        colap.enqueue(new NodoPrioridad(4,"Hola4"));
        colap.enqueue(new NodoPrioridad(9,"Hola5"));
        while(!colap.isEmpty()){
            System.out.println(colap.dequeue());
    }
    
    }
}
