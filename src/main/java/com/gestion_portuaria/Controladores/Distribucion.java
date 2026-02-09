package com.gestion_portuaria.Controladores;

import com.gestion_portuaria.Carga.Contenedor;
import com.gestion_portuaria.Distribucion.Ruta;
import com.gestion_portuaria.Estructuras.ListaSimple;

public class Distribucion {
    public static ListaSimple<Ruta> rutas = new ListaSimple<Ruta>();
    public static ListaSimple<Contenedor> contenedoresCargados = null;
}
