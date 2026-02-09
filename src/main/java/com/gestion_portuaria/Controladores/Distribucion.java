package com.gestion_portuaria.Controladores;

import com.gestion_portuaria.Carga.Contenedor;
import com.gestion_portuaria.Distribucion.Ruta;
import com.gestion_portuaria.Estructuras.ListaSimple;

/**
 * Clase encargada de centralizar la información relacionada con la distribución
 * Cumple la función del módulo D
 * Mantiene las rutas disponibles para envío y los contenedores que han sido
 * cargados desde el patio y están listos para ser distribuidos.
 */
public class Distribucion {
    /**
     * Rutas añadidas
     */
    public static ListaSimple<Ruta> rutas = new ListaSimple<Ruta>();
    /**
     * Contenedores cargados desde el patio de contenedores listos para envío
     */
    public static ListaSimple<Contenedor> contenedoresCargados = null;
}
