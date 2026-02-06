/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas;

/**
 *
 * @author ojeda
 */
public class ListaDobleC extends ListaD {

    public void imprimir(){
        NodoDoble actual = inicio;
        if(!vacio())
            if(inicio == ultimo)
                System.out.println(actual.getDato());
             else{
                do {
                    System.out.println(actual.getDato() + "->");
                    actual = actual.getSiguiente();
                } while(actual != inicio);
            }
    }
    
    public void imprimirAlReves(){
        NodoDoble actual = ultimo;
        if(!vacio())
            if(inicio == ultimo)
                System.out.println(actual.getDato());
            else {
                do {
                    System.out.println(actual.getDato() + "->");
                    actual = actual.getAnterior();
                }while(actual != ultimo);
            }
    }
    
    @Override
    public void insertaInicio(Object dato) {
            if(vacio()){
                inicio = ultimo = new NodoDoble(dato);
                inicio.setSiguiente(ultimo);
                ultimo.setAnterior(inicio);
            }else{
                NodoDoble nuevo = new NodoDoble(dato,inicio,ultimo);
                inicio.setAnterior(nuevo);
                ultimo.setSiguiente(nuevo);
                inicio = nuevo;
            }
    }

    @Override
    public void insertarFinal(Object dato) {
            if(vacio()){
                inicio = ultimo = new NodoDoble(dato);
                inicio.setSiguiente(ultimo);
                ultimo.setAnterior(inicio);
            } else {
                NodoDoble nuevo = new NodoDoble(dato,inicio,ultimo);
                inicio.setAnterior(nuevo);
                ultimo.setSiguiente(nuevo);
                ultimo = nuevo;
            }
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
        Object eliminado = null;
        if(vacio())
            System.out.println("Lista vacia");
        else {
            if(inicio == ultimo){
                eliminado = inicio.getDato();
                inicio = ultimo = null;
            } else {
                eliminado = inicio.getDato();
                inicio = inicio.getSiguiente();
                inicio.setAnterior(ultimo);
                ultimo.setSiguiente(inicio);
            }
        }
            return eliminado;
    }

    @Override
    public Object eliminarFinal() {
            Object eliminado = null;
            if(vacio())
                System.out.println("Lista vacia");
            else {
                if(inicio == ultimo){
                    eliminado = ultimo.getDato();
                    inicio = ultimo = null;
                } else{
                    eliminado = ultimo.getDato();
                    ultimo = ultimo.getAnterior();
                    ultimo.setSiguiente(inicio);
                    inicio.setAnterior(ultimo);
                }
            }
            return eliminado;
    }
    
    public static void main(String[] args) {
        ListaDobleC listaDobleC = new ListaDobleC();
        listaDobleC.insertaInicio("holaaa");
        listaDobleC.insertaInicio(1);
        listaDobleC.insertaInicio(25.5);
        listaDobleC.insertaInicio(true);
        listaDobleC.insertarFinal("ultimo");
        System.out.println("Recorrido hacia adelante:");
        listaDobleC.imprimir();
        System.out.println("Recorrido hacia atras:");
        listaDobleC.imprimirAlReves();
        System.out.println("El inicio eliminado de la lista es: " +  listaDobleC.eliminarInicio());
      System.out.println("Recorrido hacia adelante:");
        listaDobleC.imprimir();
        System.out.println("Recorrido hacia atras:");
        listaDobleC.imprimirAlReves();
        System.out.println("El ultimo eliminado de la lista es: " +  listaDobleC.eliminarFinal());
         System.out.println("Recorrido hacia adelante:");
        listaDobleC.imprimir();
        System.out.println("Recorrido hacia atras:");
        listaDobleC.imprimirAlReves();
        }
    
}
