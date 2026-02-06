/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Deques;

import java.util.ArrayList;
import Deques.ArrayLDeque;
/**
 *
 * @author ojeda
 */
public class Clinica {
    private ArrayLDeque Pacientes;

    public Clinica() {
        this.Pacientes = new ArrayLDeque();
    }

    
    public void pacienteNormal(Paciente paciente) {
        Pacientes.insertLast(paciente);
        System.out.println("Paciente normal agregado: " + paciente.getNombre());
    }

   
    public void pacienteUrgencia(Paciente paciente) {
        Pacientes.insertFirst(paciente);
        System.out.println("Paciente de urgencias agregado: " + paciente.getNombre());
    }

    
    public void atenderPrimero() {
        if (Pacientes.isEmpty()) {
            System.out.println("No hay pacientes en espera.");
            return;
        }
        Paciente atendido = (Paciente) Pacientes.removeFirst();
        System.out.println("Atendiendo al primer paciente: " + 
                          atendido.getNombre() + " (" + atendido.getEdad() + " años)");
    }

  
    public void atenderUltimo() {
        if (Pacientes.isEmpty()) {
            System.out.println("No hay pacientes en espera.");
            return;
        }
        Paciente atendido = (Paciente) Pacientes.removeLast();
        System.out.println("Atendiendo al último paciente: " + 
                          atendido.getNombre() + " (" + atendido.getEdad() + " años)");
    }

  
    public void mostrarFila() {
        if (Pacientes.isEmpty()) {
            System.out.println(" La cola vacía.");
            return;
        }
        System.out.print("cola actual: ");
        
      
        ArrayLDeque temp = new ArrayLDeque();
        int size = Pacientes.size();
        
        // Transferir todos los elementos a temporal
        for (int i = 0; i < size; i++) {
            Object paci = Pacientes.removeFirst();
            System.out.print(((Paciente)paci).getNombre() + "(" + ((Paciente)paci).getEdad() + ") ");
            temp.insertLast(paci);
        }
        
        // Devolver los elementos a la cola original
        for (int i = 0; i < size; i++) {
            Pacientes.insertLast(temp.removeFirst());
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Clinica clinica = new Clinica();
        
        clinica.pacienteUrgencia(new Paciente("jose alberto",19));
        clinica.pacienteUrgencia(new Paciente("alexis",34));
        clinica.pacienteNormal(new Paciente("Darius",21));
        
        clinica.pacienteNormal(new Paciente("akemi",21));
        clinica.atenderPrimero();
        clinica.atenderUltimo();
        clinica.mostrarFila();
        
        
    }
    
}
