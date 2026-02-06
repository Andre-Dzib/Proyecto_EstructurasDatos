/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas;

/**
 *
 * @author ojeda
 */
public class ListaSimpleC extends ListaCirc{

    @Override
    public void insertaInicio(Object dato) {
            if(vacio()){
                inicio = ultimo = new Nodo(dato);
                ultimo.setSiguiente(inicio);
            }
            else {
                inicio = new Nodo(dato,inicio);
                ultimo.setSiguiente(inicio);
            }
            
    }

    @Override
    public void insertarFinal(Object dato) {
                if(vacio()){
                inicio = ultimo = new Nodo(dato);
                ultimo.setSiguiente(inicio);
            }
            else{
                Nodo temp = new Nodo(dato);
                ultimo.setSiguiente(temp);
                ultimo = temp;
                ultimo.setSiguiente(inicio);
            }  
    }

    @Override
    public Object eliminarInicio() {
           Object eliminado = null;
            if(vacio())
                System.out.println("La lista esta vacia");
            else {
                if(inicio == ultimo){
                    eliminado = inicio.getDato();
                    inicio = ultimo = null;
                }
                else{
                    eliminado = inicio.getDato();
                    inicio = inicio.getSiguiente();
                    ultimo.setSiguiente(inicio);
                }
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
                }
                else{
                    Nodo actual = inicio;
                    while(actual.getSiguiente() != ultimo)
                        actual = actual.getSiguiente();
                   eliminado = ultimo.getDato();
                   actual.setSiguiente(inicio);
                   ultimo = actual;
                }
            
            return eliminado;
    }
    
    @Override
    public void insertarSegundo(Object dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertarPen(Object dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void main(String[] args) {
        ListaSimpleC listac = new ListaSimpleC();
        listac.insertaInicio(":C");
        listac.insertaInicio(":)");
         listac.insertaInicio("Hola");
          listac.insertaInicio("b");
          listac.insertarFinal("ultimo");
          listac.imprimir();
          System.out.println("Ahora probemos la eliminacion...");
          System.out.println("El primer elemento de la lista a eliminar es: " + 
                  listac.eliminarInicio());
            listac.imprimir();
          System.out.println("Eliminando el ultimo: " + listac.eliminarFinal());
          listac.imprimir();
    }

    
    
}
