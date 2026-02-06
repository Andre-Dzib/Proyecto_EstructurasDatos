/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Deques;

import java.util.ArrayList;

/**
 *
 * @author ojeda
 */
public class ArrayLDeque implements Deque{
protected ArrayList deque;


public ArrayLDeque(){
    deque = new ArrayList();
}
  

    
    
    @Override
    public int size() {
    return deque.size(); 
        }

    @Override
    public boolean isEmpty() {
    return deque.isEmpty(); 
    }

    @Override
    public void insertFirst(Object data) {
        deque.add(0, data);  
                }

    @Override
    public void insertLast(Object data) {
        deque.add(data);
    }

    @Override
    public Object removeFirst() {
        if(!deque.isEmpty())
            return deque.remove(0);
        else{
            System.out.println("El deque esta vacio");
        return null;
        }
        
    }

    @Override
    public Object removeLast() {
 if(!deque.isEmpty())
            return deque.remove(deque.size() -1);
        else{
            System.out.println("El deque esta vacio");
        return null;
        }
    }

    @Override
    public Object first() {
 if(!deque.isEmpty())
            return deque.get(0);
        else{
            System.out.println("El deque esta vacio");
        return null;
        }  
    }

    @Override
    public Object last() {
 if(!deque.isEmpty())
            return deque.get(deque.size() -1);
        else{
            System.out.println("El deque esta vacio");
        return null;
        }
    }
    
    public static void main(String[] args) {
        ArrayLDeque deque = new ArrayLDeque();
        deque.insertFirst("Hola 1");
        deque.insertFirst("Hola 2");
        deque.insertLast("ultimo");
        deque.insertLast("Ahora si es el ultimo");
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        while(!deque.isEmpty()){
            System.out.println(deque.removeFirst());
        }
    }
    
}
