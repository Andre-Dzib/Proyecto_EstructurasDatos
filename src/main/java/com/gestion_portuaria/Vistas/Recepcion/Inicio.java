package com.gestion_portuaria.Vistas.Recepcion;

import com.gestion_portuaria.Controladores.Patio;
import com.gestion_portuaria.Controladores.Recepcion;
import com.gestion_portuaria.Recepcion.Camion;
import com.gestion_portuaria.Vistas.Estilos;
import com.gestion_portuaria.Vistas.Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa la ventana principal de la sección de Recepción en el sistema de gestión portuaria.
 * Permite al usuario interactuar con la cola de camiones que esperan a ingresar al patio, proporcionando botones para:
 * Registrar la llegada de un camión (enqueue).
 * Dar ingreso a un camión al patio (dequeue).
 * Consultar el próximo camión en turno (peek).
 * Listar todos los camiones en la cola.
 */
public class Inicio extends Vista {
    /**
     * Label para indicarle el estado de las operaciones al usuario
     */
    public JLabel status;

    @Override
    public void prepareGUI() {
        super.prepareGUI();
        window.setBounds(0, 0, 500, 500);
        status = new JLabel("", JLabel.CENTER);
        status.setBounds(0, 35, window.getWidth(), 50);
        window.add(status);
        Estilos.tituloCentrado(this, "Recepción", 10);

        agregarBotonRegistrarLlegada();
        agregarBotonIngresoPatio();
        agregarBotonVerProximo();
        agregarBotonListarCamiones();
    }

    /**
     * Agrega el botón para registrar la llegada de un camión
     */
    private void agregarBotonRegistrarLlegada() {
        JButton button = Estilos.botonCentrado(this, "Registrar llegada camión (Enqueue)", 80);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Registro().run();
            }
        });
    }

    /**
     * Agrega el botón para dar ingreso a un camión al patio
     */
    private void agregarBotonIngresoPatio() {
        JButton button = Estilos.botonCentrado(this, "Dar ingreso a patio (Dequeue)", 170);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Recepcion.colaCamiones.isEmpty()) {
                    status.setText("La cola está vacía");
                    return;
                }

                if (Patio.entrante != null) {
                    status.setText("Ya hay un camión esperando en el patio");
                    return;
                }

                // Extrae el camión de la cola y lo coloca en el patio
                Camion actual = Recepcion.colaCamiones.dequeue();
                status.setText("Se ha sacado el camión con placa " + actual.getPlaca() + " de la cola");
                Patio.entrante = actual;
            }
        });
    }

    /**
     * Agrega el botón para ver el próximo camión en turno sin sacarlo de la cola
     */
    private void agregarBotonVerProximo() {
        JButton button = Estilos.botonCentrado(this, "Ver próximo camión (Peek)", 260);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Recepcion.colaCamiones.isEmpty()) {
                    status.setText("La cola está vacía");
                    return;
                }

                new Proximo().run();
            }
        });
    }

    /**
     * Agrega el botón para listar todos los camiones en la cola
     */
    private void agregarBotonListarCamiones() {
        JButton button = Estilos.botonCentrado(this, "Listar todos los camiones", 350);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Lista().run();
            }
        });
    }
}