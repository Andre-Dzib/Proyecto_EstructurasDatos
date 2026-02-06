/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoEstructura;

import Listas.ListaSimple;
import Pilas.Pila;

/**
 *
 * @author ojeda
 */
public class Modulo_B implements Pila {
    protected ListaSimple stack;
    protected int topeMax;
    protected int cont;

    public Modulo_B(int max) {
        stack = new ListaSimple();
        topeMax = max;
        cont = 0;
    }

    public void meterContenedor(Contenedor contenedor){
         if(cont == topeMax){
            System.out.println("La pila esta llena");
       return;
       } else {
             stack.insertaInicio(contenedor);
             cont++;
         }
    }
    
    public Contenedor sacar(){
        if(stack.vacio()){
            System.out.println("La pila esta vacia");
         return null;   
    } else{
            cont--;
            Contenedor contSalida = (Contenedor) stack.eliminarInicio();
            return contSalida;
            
        }
    }
    
    @Override
    public void push(Object x) {
       if(cont == topeMax){
            System.out.println("La pila esta llena");
       return;
       }
       else{
           stack.insertaInicio(x);
           cont++;
          
       }
    }
    
    public Contenedor tope(){
        if(stack.vacio()){
            System.out.println("La pila esta vacia");
         return null;   
        }
        else{
            Contenedor contTope = (Contenedor)stack.getInicio().getDato(); 
        return contTope;
    }
  }
     

    @Override
    public Object pop() {
    if(isEmpty()){
            System.out.println("La pila esta vacia");
         return null;   
    } else{
        cont--;
        return stack.eliminarInicio();
    }
  }
    
    @Override
    public Object top() {
     if(stack.vacio()){
            System.out.println("La pila esta vacia");
         return null;   
        }
        else
        return stack.getInicio().getDato();
    }


    @Override
    public int size() {
        return cont;
    }

    @Override
    public boolean isEmpty() {
        return stack.vacio();
    }
    
}
