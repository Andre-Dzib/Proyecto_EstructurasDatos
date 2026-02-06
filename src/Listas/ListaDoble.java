/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas;

/**
 *
 * @author ojeda
 */
public class ListaDoble extends ListaD{

    @Override
    public void insertaInicio(Object dato) {
            if(vacio())
                inicio = ultimo = new NodoDoble(dato);
                else{
                   NodoDoble nuevo = new NodoDoble(dato, inicio, null);
                   inicio.setAnterior(nuevo);
                   inicio = nuevo;
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
    public void insertarFinal(Object dato) {
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
    
    public static void main(String[] args) {
        ListaDoble listad = new ListaDoble();
        listad.insertaInicio(":)");
        listad.insertaInicio(6.7);
        listad.insertaInicio(true);
        listad.insertaInicio(":(");
        System.out.println("Imprimiendo desde el inicio");
        listad.imprimir();
        System.out.println("Imprimiendo desde el final");
        listad.imprimirAlReves();
    }
    
}
