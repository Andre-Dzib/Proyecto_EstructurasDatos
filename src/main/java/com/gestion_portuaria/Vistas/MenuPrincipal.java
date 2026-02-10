package com.gestion_portuaria.Vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa el menú principal de la aplicación.
 * Proporciona accesos directos a los módulos de:
 * Recepción de camiones (colas)
 * Patio de contenedores (pilas)
 * Logística y distribución (listas dobles)
 * Reporte general
 */
public class MenuPrincipal extends Vista {
    /**
     * Configura la interfaz gráfica de la ventana.
     * Crea el título y los botones que abren
     * las vistas correspondientes a cada módulo.
     */
    @Override
    public void prepareGUI() {
        super.prepareGUI();
        window.setBounds(0, 0, 500, 500);
        window.setTitle("Menu principal");

        Estilos.tituloCentrado(this, "Gestión portuaria", 10);

        Estilos.botonCentrado(this, "Recepción (Colas)", 80).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new com.gestion_portuaria.Vistas.Recepcion.Inicio().run();
            }
        });

        Estilos.botonCentrado(this, "Patio de contenedores (Pilas)", 170).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new com.gestion_portuaria.Vistas.Patio.Inicio().run();
            }
        });

        Estilos.botonCentrado(this, "Logística (Listas dobles)", 260).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new com.gestion_portuaria.Vistas.Distribucion.Inicio().run();
            }
        });

        Estilos.botonCentrado(this, "Reporte general", 350).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new com.gestion_portuaria.Vistas.Reporte.Inicio().run();
            }
        });
    }
}