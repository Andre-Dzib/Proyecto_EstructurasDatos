package com.gestion_portuaria.Vistas;

import javax.swing.*;
import java.awt.*;

/**
 * Clase utilitaria que proporciona métodos para aplicar estilos comunes a componentes gráficos de las vistas.
 */
public final class Estilos {
    /**
     * Crea un JLabel centrado horizontalmente en la ventana de la vista.
     * @param vista La vista donde se añadirá el label
     * @param texto El texto a mostrar en el label
     * @param y La posición vertical del label
     * @return El JLabel creado y añadido a la ventana
     */
    public static JLabel tituloCentrado(Vista vista, String texto, int y) {
        JLabel label = new JLabel(texto, JLabel.CENTER);

        label.setFont(new Font(label.getFont().getName(), Font.BOLD, 20));
        label.setBounds(0, y, vista.window.getWidth(), 50);
        vista.window.add(label);

        return label;
    }

    /**
     * Crea un JButton centrado horizontalmente en la ventana de la vista.
     * @param vista La vista donde se añadirá el botón
     * @param texto El texto a mostrar en el botón
     * @param y La posición vertical del botón
     * @return El JButton creado y añadido a la ventana
     */
    public static JButton botonCentrado(Vista vista, String texto, int y) {
        JButton button = new JButton(texto);

        button.setBounds(80, y, vista.window.getWidth() - 160, 80);
        vista.window.add(button);

        return button;
    }
}