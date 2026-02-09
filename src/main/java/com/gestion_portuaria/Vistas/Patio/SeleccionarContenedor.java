package com.gestion_portuaria.Vistas.Patio;

import com.gestion_portuaria.Almacenamiento.ColumnaContenedores;
import com.gestion_portuaria.Controladores.Patio;
import com.gestion_portuaria.Vistas.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionarContenedor extends Vista  {

    public void abrirContenedor(int numeroColumna, int numeroFila) {
        ColumnaContenedores columnaContenedores = Patio.columnasContenedores.get(numeroColumna);
        ColumnaContenedores auxiliar = new ColumnaContenedores(columnaContenedores.getMax());
        int size = columnaContenedores.size();

        for(int i = size; i > numeroFila; i--) {
            auxiliar.push(columnaContenedores.pop());
        }

        new InspeccionarContenedor(columnaContenedores.top()).run();

        while(! auxiliar.isEmpty() ) {
            columnaContenedores.push(auxiliar.pop());
        }
    }


    @Override
    public void prepareGUI() {
        super.prepareGUI();
        window.setBounds(0, 0, 500, 500);

        JPanel listaPilas = new JPanel();
        listaPilas.setLayout(new BoxLayout(listaPilas, BoxLayout.X_AXIS));

        for(int i = 0; i < Patio.columnasContenedores.getSize(); i++) {
            JPanel infoPila = new JPanel(new GridLayout(0, 1));
            ColumnaContenedores columnaContenedores = Patio.columnasContenedores.get(i);
            infoPila.setPreferredSize( new Dimension(200, 50) );
            infoPila.setMaximumSize( new Dimension(200, 80) );

            ColumnaContenedores auxiliar = new ColumnaContenedores(columnaContenedores.getMax());
            int size = columnaContenedores.size();
            for(int j = size; j > 0; j--) {
                auxiliar.push(columnaContenedores.pop());

                JButton botonContenedor = new JButton(String.valueOf(j));
                botonContenedor.setToolTipText(String.valueOf(i));
                botonContenedor.addActionListener( e -> {
                    abrirContenedor(Integer.parseInt(botonContenedor.getToolTipText()), Integer.parseInt(botonContenedor.getText()));
                });

                infoPila.add(botonContenedor);
            }

            while( ! auxiliar.isEmpty() ) {
                columnaContenedores.push(auxiliar.pop());
            }

            infoPila.add(new JLabel("Pila " + (i + 1)));

            listaPilas.add(infoPila);
        }

        JScrollPane scroll = new JScrollPane(listaPilas);
        scroll.setBounds(50, 50, 400, 400);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        window.add(scroll);
    }
}
