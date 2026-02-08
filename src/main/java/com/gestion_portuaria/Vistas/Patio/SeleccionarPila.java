package com.gestion_portuaria.Vistas.Patio;

import com.gestion_portuaria.Almacenamiento.ColumnaContenedores;
import com.gestion_portuaria.Controladores.Patio;
import com.gestion_portuaria.Vistas.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionarPila extends JDialog {
    public Integer numeroPila = null;
    private final boolean meter;

    public SeleccionarPila(JFrame parent) {
        this(parent, true);
    }

    public SeleccionarPila(JFrame parent, boolean meter) {
        // El true es para indicar que es un modal
        super(parent, "Seleccionar pila", true);
        this.meter = meter;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(0, 0, 500, 500);

        prepareGUI();
    }

    public void prepareGUI() {
        JPanel listaPilas = new JPanel();
        listaPilas.setLayout(new BoxLayout(listaPilas, BoxLayout.X_AXIS));

        for(int i = 0; i < Patio.columnasContenedores.getSize(); i++) {
            JPanel infoPila = new JPanel(new GridLayout(0, 1));
            ColumnaContenedores columnaContenedores = Patio.columnasContenedores.get(i);
            infoPila.setPreferredSize( new Dimension(200, 50) );
            infoPila.setMaximumSize( new Dimension(200, 80) );

            infoPila.add(new JLabel("Contenedores: " + columnaContenedores.size()));
            infoPila.add(new JLabel("Maximo: " + columnaContenedores.getMax()));

            JButton button = new JButton("Pila " + (i + 1));

            if( meter ) {
                if( columnaContenedores.isFull() ) {
                    button.setEnabled(false);
                }
            }
            else {
                if( columnaContenedores.isEmpty() ) {
                    button.setEnabled(false);
                }
            }


            button.setToolTipText(String.valueOf(i));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    numeroPila = Integer.parseInt( button.getToolTipText() );
                    dispose();
                }
            });

            infoPila.add(button);

            listaPilas.add(infoPila);
        }

        JScrollPane scroll = new JScrollPane(listaPilas);
        scroll.setBounds(50, 50, 400, 400);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        add(scroll);
    }
}
