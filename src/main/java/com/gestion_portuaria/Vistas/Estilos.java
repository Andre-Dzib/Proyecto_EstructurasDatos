package com.gestion_portuaria.Vistas;

import javax.swing.*;
import java.awt.*;

public final class Estilos {
    public static JLabel tituloCentrado(Vista vista, String texto, int y) {
        JLabel label = new JLabel(texto, JLabel.CENTER);
        label.setFont(new Font( label.getFont().getName(), Font.BOLD, 20 ));
        label.setBounds(0, y, vista.window.getWidth(), 50);
        vista.window.add(label);
        return label;
    }

    public static JButton botonCentrado(Vista vista, String texto, int y) {
        // ImageIcon icon = new ImageIcon("/home/adrian/icon.png");
        JButton button = new JButton(texto);
        button.setBounds(80, y, vista.window.getWidth() - 160, 80);
        vista.window.add(button);
        return button;
    }
}
