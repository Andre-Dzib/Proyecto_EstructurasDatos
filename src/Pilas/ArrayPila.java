/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pilas;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ojeda
 */
public class ArrayPila implements Pila{
protected Object[] pila;
protected int tope;

    public ArrayPila(){
    pila = new Object[1000];
    tope = -1;
    }
    
        @Override
    public void push(Object x) {
        if(isFull()){
            System.out.println("La pila ests llena");
            return;
        }
        pila[++tope] = x;
    }
    
    @Override
    public Object pop() {
        if(isEmpty()){
            System.out.println("La pila esta vacia");
         return null;   
    }
       Object valor = pila[tope];
       pila[tope--] = null;
        return valor;
    }
    
    @Override
    public Object top() {
        if(isEmpty()){
            System.out.println("La pila esta vacia");
         return null;   
        }
      
        return pila[tope];    
  }

    @Override
    public int size() {    
        return tope + 1; 
    }

    @Override
    public boolean isEmpty() {
            return tope == -1;    
    } 
    
    public boolean isFull(){
        return tope == pila.length -1;
    }
    
 
   public static void main(String[] args) {
    ArrayPila pila = new ArrayPila();
    
   
    for(int i = 0; i < 1000; i++){
        pila.push(i);
    }
    
    while (!pila.isEmpty())
        System.out.println(pila.pop());
}
    
}

