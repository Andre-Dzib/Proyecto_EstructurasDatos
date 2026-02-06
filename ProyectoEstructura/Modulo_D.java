/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoEstructura;

import Listas.ListaD;
import Listas.ListaDoble;
import Listas.NodoDoble;

/**
 *
 * @author ojeda
 */
public class Modulo_D extends ListaD{
    
    int cont;
    ListaDoble listaD;
  

    public Modulo_D( int cont, ListaDoble listaD ) {
 
        this.cont = cont;
      listaD = new ListaDoble();
    }
    
   public Parada eliminarParada(int numero) {

    NodoDoble actual = inicio;

    while (actual != null) {
        Parada p = (Parada) actual.getDato();

        if (p.getNumero() == numero) {

            NodoDoble ant = actual.getAnterior();
            NodoDoble sig = actual.getSiguiente();

            if (ant == null) {          // era el primero
                inicio = sig;
            } else {
                ant.setSiguiente(sig);
            }

            if (sig != null) {
                sig.setAnterior(ant);
            }

            cont--;
            return p;
        }
        actual = actual.getSiguiente();
    }

    return null;
}
   public void insertarParada(int numero){
       
       Parada p = new Parada(numero);
       NodoDoble nuevo = new NodoDoble(p);
       
       if (inicio == null) {
        inicio = nuevo;
        cont++;
      return;
       }
   
           NodoDoble actual = inicio;
           while(actual != null && ((Parada) actual.getDato()).getNumero() < numero){
               actual = actual.getSiguiente();
           }
           if(inicio == ultimo){
               nuevo.setSiguiente(inicio);
               inicio.setAnterior(nuevo);
               inicio = nuevo;
           }
           else if(actual == null){
               NodoDoble fin = inicio;
               while(fin.getSiguiente() != null){
                   fin = fin.getSiguiente();
                   fin.setSiguiente(fin);
               }
           } else {
               NodoDoble anterior = actual.getAnterior();
               anterior.setSiguiente(nuevo);
               nuevo.setAnterior(anterior);  
               nuevo.setSiguiente(actual);
               actual.setAnterior(nuevo);
           }
           cont++;
   } 
   


    @Override
    public void insertaInicio(Object dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertarFinal(Object dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertarSegundo(Object dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertarPen(Object dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object eliminarInicio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object eliminarFinal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
