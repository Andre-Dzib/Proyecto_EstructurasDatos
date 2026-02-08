package com.gestion_portuaria.Vistas.Recepcion;

import com.gestion_portuaria.Controladores.Patio;
import com.gestion_portuaria.Controladores.Recepcion;
import com.gestion_portuaria.Recepcion.Camion;
import com.gestion_portuaria.Vistas.Estilos;
import com.gestion_portuaria.Vistas.Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends Vista {
    public JLabel status;

    @Override
    public void prepareGUI() {
        super.prepareGUI();
        window.setBounds(0, 0, 500, 500);
        status = new JLabel("", JLabel.CENTER);
        status.setBounds(0, 35, window.getWidth(), 50);
        window.add(status);

        Estilos.tituloCentrado(this, "Recepción", 10);
        {
            JButton button = Estilos.botonCentrado(this, "Registrar llegada camión (Enqueue)", 80);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Registro().run();
                }
            });
        }

        {
            JButton button = Estilos.botonCentrado(this, "Dar ingreso a patio (Dequeue)", 170);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if( Recepcion.colaCamiones.isEmpty() ) {
                        status.setText("La cola está vacía");
                        return;
                    }

                    if( Patio.entrante != null ) {
                        status.setText("Ya hay un camión esperando en el patio");
                        return;
                    }

                    Camion actual = Recepcion.colaCamiones.dequeue();
                    status.setText("Se ha sacado el camión con placa " + actual.getPlaca() + " de la cola");
                    Patio.entrante = actual;
                }
            });
        }
        Estilos.botonCentrado(this, "Ver próximo camión (Peek)", 260).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if( Recepcion.colaCamiones.isEmpty() ) {
                    status.setText("La cola está vacía");
                    return;
                }

                new Proximo().run();
            }
        });
        Estilos.botonCentrado(this, "Listar todos los camiones", 350).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Lista().run();
            }
        });
    }
}
