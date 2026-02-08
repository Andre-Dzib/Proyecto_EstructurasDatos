package com.gestion_portuaria.Vistas.Recepcion;

import com.gestion_portuaria.Controladores.Recepcion;
import com.gestion_portuaria.Vistas.Estilos;
import com.gestion_portuaria.Vistas.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Proximo extends Vista {
    @Override
    public void prepareGUI() {
        super.prepareGUI();

        window.setBounds(0, 0, 500, 500);

        Estilos.tituloCentrado(this, "Proximo camión", 10);
        {
            JLabel label = new JLabel("Placa: ", JLabel.CENTER);
            label.setFont( new Font( label.getFont().getName(), Font.BOLD, 20));
            label.setBounds(0, 80, window.getWidth(), 40);
            window.add(label);
        }

        {
            JLabel placa = new JLabel(Recepcion.colaCamiones.front().getPlaca(), JLabel.CENTER);
            placa.setFont( new Font( placa.getFont().getName(), Font.BOLD, 20));
            placa.setBounds(0, 100, window.getWidth(), 40);
            window.add(placa);
        }

        Estilos.botonCentrado(this, "Volver", 200).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });
    }
}
