/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colas;

import Listas.ListaSimple;

/**
 *
 * @author ojeda
 */
public class ListaSQueue implements Queue {
protected ListaSimple lista;
protected int cont;
    
    ListaSQueue(){
        lista = new ListaSimple();
        cont = 0;
    }


    @Override
    public void enqueue(Object dato) {
            lista.insertarFinal(dato);
            cont++;
     }

    @Override
    public Object dequeue() {
        if(lista.vacio()){
            System.out.println("Lista Vacia");
        return null;
        }
        else {
                cont--;
            return lista.eliminarInicio();
        }
    }

    @Override
    public int size() {
        return cont;
    }

    @Override
    public Object front() {
       if(lista.vacio()){
            System.out.println("Lista Vacia");
        return null;
        }
        else {
            return lista.getInicio().getDato();
        }
    }

    @Override
    public boolean isEmpty() {
        return lista.vacio();
    }
    
    public static void main(String[] args) {
        ListaSQueue cola = new ListaSQueue();
        cola.enqueue("Hola");
        cola.enqueue(123);
        cola.enqueue(true);
        cola.enqueue(":)");
        cola.enqueue(false);
        while(!cola.isEmpty()){
                System.out.println(cola.dequeue());
        }
    }
    
}
