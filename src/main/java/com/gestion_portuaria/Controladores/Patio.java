package com.gestion_portuaria.Controladores;

import com.gestion_portuaria.Almacenamiento.ColumnaContenedores;
import com.gestion_portuaria.Estructuras.ListaSimple;
import com.gestion_portuaria.Recepcion.Camion;

public class Patio {
    public static Camion entrante = null;
    public static ListaSimple<ColumnaContenedores> columnasContenedores = new ListaSimple<ColumnaContenedores>();
}
