/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas;

/**
 *
 * @author ojeda
 */
public abstract class ListaCirc extends Lista {
    
    public void imprimir(){
        Nodo actual = inicio;
        if(!vacio())
            if(inicio == ultimo)
                System.out.println(actual.getDato());
            else{
                do{
                    System.out.println(actual.getDato()+"->");
                    actual = actual.getSiguiente();
                }while(actual != inicio);
            }
        
    }
    
}
