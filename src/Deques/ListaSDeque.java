/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Deques;

import Listas.ListaSimple;

/**
 *
 * @author ojeda
 */
public class ListaSDeque implements Deque{
    protected ListaSimple lista;
    protected int cont;
    
     ListaSDeque(){
        lista = new ListaSimple();
        cont = 0;
    }
    
    @Override
    public int size() {
        return cont;
    }

    @Override
    public boolean isEmpty() {
        return lista.vacio();
    }

    @Override
    public void insertFirst(Object Data) {
        lista.insertaInicio(Data);
        cont++;
    }

    @Override
    public void insertLast(Object Data) {
       lista.insertarFinal(Data);
            cont++;
        
    }

    @Override
    public Object removeFirst() {
        
         if(lista.vacio()) {
            System.out.println("Lista Vacia");
         return null;
         }
         else {
             cont--;
          return lista.eliminarInicio();
         }
    }

    @Override
    public Object removeLast() {
       if(lista.vacio()) {
            System.out.println("Lista Vacia");
         return null;
         }
         else {
             cont--;
          return lista.eliminarFinal();
         }
    }

    @Override
    public Object first() {
        if(!lista.vacio())
            return lista.getInicio().getDato();
        else 
            System.out.println("La lista esta vacia");
        return null;
    }

    @Override
    public Object last() {
        if(!lista.vacio())
            return lista.getUltimo().getDato();
        else 
            System.out.println("La lista esta vacia");
        return null;
    }
    
    public static void main(String[] args) {
        ListaSDeque lista = new ListaSDeque();
        lista.insertFirst("Hola");
        lista.insertFirst(true);
        lista.insertFirst(":V");
        lista.insertLast(32);
        System.out.println("El primer objeto es: " + lista.first() + " El ultimo elemento es: "
        + lista.last());
        while(!lista.isEmpty()){
            System.out.println( lista.size());
            System.out.println(lista.removeFirst());
            
        }
       
    }
    
}
