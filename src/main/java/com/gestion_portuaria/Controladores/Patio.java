package com.gestion_portuaria.Controladores;

import com.gestion_portuaria.Almacenamiento.ColumnaContenedores;
import com.gestion_portuaria.Estructuras.ListaSimple;
import com.gestion_portuaria.Recepcion.Camion;

/**
 * Clase que representa el patio de contenedores del puerto.
 * Cumple la función del módulo B.
 * Actúa como un controlador de datos compartidos entre los módulos de
 * recepción y distribución del sistema.
 */
public class Patio {
    /**
     * Camión que entró
     */
    public static Camion entrante = null;
    public static ListaSimple<ColumnaContenedores> columnasContenedores = new ListaSimple<ColumnaContenedores>();
}
