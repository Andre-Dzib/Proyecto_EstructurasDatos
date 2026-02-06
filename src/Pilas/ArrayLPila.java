/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pilas;

import java.util.ArrayList;

/**
 *
 * @author ojeda
 */
public class ArrayLPila implements Pila{
protected ArrayList pila;

public ArrayLPila(){
    pila = new ArrayList();
}
    
    @Override
    public void push(Object x) {
        pila.add(x);
    }

    @Override
    public Object pop() {
        if(pila.isEmpty()){
            System.out.println("La pila esta vacia");
         return null;   
    }
        else
        return pila.remove(pila.size()-1);
        
    }
    
    @Override
    public Object top() {
 if(pila.isEmpty()){
            System.out.println("La pila esta vacia");
         return null;   
        }
        else
        return pila.get(pila.size()-1);    }

    @Override
    public int size() {    
        return pila.size(); 
    }

    @Override
    public boolean isEmpty() {
            return pila.isEmpty();    
    }
 
   public static void main(String[] args) {
    ArrayLPila pila = new ArrayLPila();

    pila.push(1);
    pila.push(2);
    pila.push(3);
    pila.push(4);
    pila.push(5);
    pila.push("Hola");
    pila.push(6.4);

    while (!pila.isEmpty())
        System.out.println(pila.pop());
}
    
}

