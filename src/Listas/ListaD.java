/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas;

/**
 *
 * @author ojeda
 */
public abstract class ListaD extends Lista{
    protected NodoDoble inicio;
    protected NodoDoble ultimo;
    
    
    public boolean vacio(){
        return inicio == null;
    }
    
    public void imprimir (){
        super.setInicio(inicio);
        super.imprimir();
    }
    
    public void imprimirAlReves(){
        NodoDoble actual = ultimo;
        while(actual != null){
            System.out.println(actual.getDato()+"->");
            actual = actual.getAnterior();
        }
    }
    
}
