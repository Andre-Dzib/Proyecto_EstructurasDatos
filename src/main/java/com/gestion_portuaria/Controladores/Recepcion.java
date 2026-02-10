package com.gestion_portuaria.Controladores;

import com.gestion_portuaria.Recepcion.ColaCamiones;

/**
 * Clase encargada de gestionar el proceso de recepción de camiones en el puerto.
 * Cumple la función del módulo A.
 * Mantiene la cola de camiones que esperan ser atendidos para la descarga o registro de su carga.
 */
public class Recepcion {
    /**
     * Cola de camiones esperando en recepción
     */
    public static final ColaCamiones colaCamiones = new ColaCamiones();
}