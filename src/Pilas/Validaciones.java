/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pilas;

/**
 *
 * @author ojeda
 */
public class Validaciones {
    protected ArrayLPila pila;
    
    public Validaciones(){
       pila = new ArrayLPila();
    }  
    
   public boolean parentesis(String cadena){
    pila = new ArrayLPila(); // reinicia la pila

    for (int i = 0; i < cadena.length(); i++) {
        if (cadena.charAt(i) == '(')
            pila.push('(');
        else if (cadena.charAt(i) == ')' && !pila.isEmpty())
            pila.pop();
        else
            return false;
    }
    return pila.isEmpty();
}
   
  public boolean Palindromos(String cadena){
         int inicio;
         for (int i = 0; i < cadena.length()/2; i++) 
             pila.push(cadena.charAt(i));
             if(cadena.length()%2!= 0) 
                 inicio=cadena.length()/2+1;
                 else
                 inicio=cadena.length()/2;
                    for (int i = inicio; i < cadena.length(); i++) {
                        char elemnto=(char)pila.pop();
                        if (elemnto!=cadena.charAt(i)) 
                            return false;
                   }
                     return pila.isEmpty();
                 }
    
    
    public static void main (String[] args){
        Validaciones valida = new Validaciones();
        if(valida.Palindromos("anitalavalatina"))
            System.out.println("La cadena es valida");
                    else
            System.out.println("La cadena no es valida");
    }
}

