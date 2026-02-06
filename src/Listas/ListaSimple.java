/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas;

/**
 *
 * @author ojeda
 */
public class ListaSimple extends Lista {

    @Override
    public void insertaInicio(Object dato) {
                if(vacio())
                    inicio = ultimo = new Nodo(dato);
                else
                    inicio = new Nodo(dato,inicio);
    }

    @Override
    public void insertarFinal(Object dato) {
            if(vacio())
                inicio = ultimo = new Nodo(dato);
            else {
                Nodo temp = new Nodo(dato);
                ultimo.setSiguiente(temp);
                ultimo = temp;
            }
    }

    @Override
    public Object eliminarInicio() {
            Object eliminado = null;
            if(vacio())
                System.out.println("La lista esta vacia");
            else 
                if(inicio == ultimo){
                    eliminado = inicio.getDato();
                inicio = ultimo = null;    
             }
               else {
               eliminado = inicio.getDato();
               inicio = inicio.getSiguiente();
              }
          return eliminado;
    }

    @Override
    public Object eliminarFinal() {
        Object eliminado = null;
        if(vacio())
            System.out.println("La lista esta vacia");
        else
            if(inicio == ultimo){
                eliminado = ultimo.getDato();
                inicio = ultimo = null;
            } else {
                eliminado = ultimo.getDato();
                Nodo actual = inicio;
                while(actual.getSiguiente()!=ultimo){
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(null);
                ultimo = actual;
            }
        return eliminado;
    }
    
    public void insertarEnOrden(int dato){
        if(vacio())
            insertaInicio(dato);
        else
            if(inicio == ultimo){
                if(dato < (Integer)inicio.getDato())
                    insertaInicio(dato);
                else
                    insertarFinal(dato);
            }
            else{
                Nodo antes = null, despues = inicio;
                while(despues != null && dato > (Integer)despues.getDato()){
                    antes = despues;
                    despues = despues.getSiguiente();
                }
                if(antes == null)
                    insertaInicio(dato);
                else{
                    Nodo nuevo = new Nodo(dato,despues);
                    antes.setSiguiente(nuevo);
                }
            }
    }
    
    @Override
    public void insertarSegundo(Object dato) {
            if(vacio()){
                inicio = ultimo = new Nodo(dato);
            } else {
                Nodo nuevo = new Nodo(dato);
                nuevo.setSiguiente(inicio.getSiguiente());
                inicio.setSiguiente(nuevo);
            }
    }

    @Override
    public void insertarPen(Object dato) {
        
            if(vacio()){
                inicio = ultimo = new Nodo(dato);
            } if(inicio == ultimo) {
                Nodo pen = new Nodo(dato);
                inicio.setSiguiente(pen);
                pen.setSiguiente(ultimo);
            } else {
                Nodo actual = inicio;
                Nodo pen = new Nodo(dato);
                while(actual.getSiguiente()!=ultimo){
                   actual = actual.getSiguiente();
                }
                pen.setSiguiente(ultimo);
                actual.setSiguiente(pen);
                
            }    
    }
    
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();
        
     lista.insertaInicio(7);
        lista.insertaInicio("Hola");
        lista.insertaInicio(":)");
        lista.insertaInicio('a');
        lista.insertarFinal("ultimo");
        lista.imprimir();
        System.out.println("Vamos a probar la eliminacion");
        System.out.println("El primer elemento a eliminar de la lista es: " + lista.eliminarInicio());
        lista.imprimir();
        System.out.println("El tultimo de la lista que queremos eliminar es: " + lista.eliminarFinal());
        lista.imprimir();
        System.out.println("Vamos a probar el insertado al segundo "  );
        lista.insertarSegundo("segundo");
        lista.imprimir();
        System.out.println("Vamos a probar el insertado en el penultimo "  );
        lista.insertarPen("penultimo");
         lista.imprimir();
        
     /*     
     lista.insertarEnOrden(26);
        lista.insertarEnOrden(1);
           lista.insertarEnOrden(0);
              lista.insertarEnOrden(2);  
              lista.insertarEnOrden(6); 
              lista.insertarEnOrden(600);
              lista.imprimir();
              */
              
    }
    
}
