package com.gestion_portuaria;

import com.formdev.flatlaf.FlatLightLaf;
import com.gestion_portuaria.Almacenamiento.ColumnaContenedores;
import com.gestion_portuaria.Carga.Contenedor;
import com.gestion_portuaria.Carga.Producto;
import com.gestion_portuaria.Controladores.Patio;
import com.gestion_portuaria.Vistas.MenuPrincipal;

import javax.swing.*;

public class Main {
    public static void inicializarPilaContenedores() {
        for(int i = 0; i < 6; i++) {
            Patio.columnasContenedores.insertaFinal(new ColumnaContenedores(5 - i));
        }
        Patio.columnasContenedores.get(0).push(new Contenedor(new Producto(100, "wa", 10)));
        Patio.columnasContenedores.get(0).push(new Contenedor(new Producto(100, "we", 10)));
        Patio.columnasContenedores.get(0).push(new Contenedor(new Producto(100, "wi", 10)));
    }

    public static void main(String[] args) {
        inicializarPilaContenedores();
        FlatLightLaf.setup();
        new MenuPrincipal().run();
    }
}