package com.gestion_portuaria.Vistas.Recepcion;

import com.gestion_portuaria.Controladores.Recepcion;
import com.gestion_portuaria.Recepcion.Camion;
import com.gestion_portuaria.Recepcion.ColaCamiones;
import com.gestion_portuaria.Vistas.Estilos;
import com.gestion_portuaria.Vistas.Vista;

import javax.swing.*;
import java.awt.*;

public class Lista extends Vista {
    @Override
    public void prepareGUI() {
        super.prepareGUI();
        window.setBounds(0, 0, 500, 500);
        Estilos.tituloCentrado(this, "Lista de camiones", 10);

        JPanel listaCamiones = new JPanel();
        listaCamiones.setLayout(new BoxLayout(listaCamiones, BoxLayout.Y_AXIS));

        {
            // Guardamos los camiones para volver a encolarlos después
            ColaCamiones auxiliar = new ColaCamiones();
            int size = Recepcion.colaCamiones.size();
            for(int i = 0; i < size; i++) {
                Camion actual = Recepcion.colaCamiones.front();
                auxiliar.enqueue(Recepcion.colaCamiones.dequeue());
                JLabel placa = new JLabel(actual.getPlaca(), JLabel.CENTER);
                placa.setFont(new Font(placa.getFont().getName(), Font.PLAIN, 40));
                placa.setPreferredSize(new Dimension(400, 60));
                placa.setMaximumSize(new Dimension(400, 80));
                listaCamiones.add(placa);
            }

            // Lo volvemos a ingresar en la lista original
            for(int i = 0; i < size; i++) {
                Recepcion.colaCamiones.enqueue(auxiliar.dequeue());
            }
        }

        JScrollPane scroll = new JScrollPane(listaCamiones);
        scroll.setBounds(50, 50, 400, 400);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        window.add(scroll);
    }
}
