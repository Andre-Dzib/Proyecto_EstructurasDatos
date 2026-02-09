package com.gestion_portuaria.Vistas.Distribucion;

import com.gestion_portuaria.Distribucion.Ruta;
import com.gestion_portuaria.Vistas.Estilos;
import com.gestion_portuaria.Vistas.Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Navegacion extends Vista {
    private Ruta ruta;
    private JLabel nombreActual;

    public Navegacion(Ruta ruta) {
        this.ruta = ruta;
    }

    @Override
    public void prepareGUI() {
        super.prepareGUI();
        window.setBounds(0, 0, 500, 500);
        Estilos.tituloCentrado(this, "Navegación", 10);
        nombreActual = Estilos.tituloCentrado(this, ruta.getParadaActual().getDato().getNombre(), 100);

        JButton izquierda = new JButton("←");
        JButton derecha = new JButton("→");
        JLabel textoIzquierda = new JLabel("");
        JLabel textoDerecha = new JLabel("", JLabel.RIGHT);
        textoIzquierda.setBounds(50, 200, 200, 40);
        textoDerecha.setBounds(250, 200, 200, 40);

        textoIzquierda.setText( ruta.getParadaActual().getAnterior() == null ? "Final" : ruta.getParadaActual().getAnterior().getDato().getNombre() );
        textoDerecha.setText( ruta.getParadaActual().getSiguiente() == null ? "Final" : ruta.getParadaActual().getSiguiente().getDato().getNombre() );

        window.add(textoIzquierda);
        window.add(textoDerecha);

        izquierda.setBounds(50, 150, 80, 40);
        izquierda.setEnabled(ruta.getParadaActual().getAnterior() != null);
        izquierda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruta.anteriorParada();
                izquierda.setEnabled(ruta.getParadaActual().getAnterior() != null);
                derecha.setEnabled(ruta.getParadaActual().getSiguiente() != null);
                nombreActual.setText(ruta.getParadaActual().getDato().getNombre());


                textoIzquierda.setText( ruta.getParadaActual().getAnterior() == null ? "Final" : ruta.getParadaActual().getAnterior().getDato().getNombre() );
                textoDerecha.setText( ruta.getParadaActual().getSiguiente() == null ? "Final" : ruta.getParadaActual().getSiguiente().getDato().getNombre() );
            }
        });
        window.add(izquierda);

        derecha.setBounds(370, 150, 80, 40);
        derecha.setEnabled(ruta.getParadaActual().getSiguiente() != null);
        derecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruta.siguienteParada();
                izquierda.setEnabled(ruta.getParadaActual().getAnterior() != null);
                derecha.setEnabled(ruta.getParadaActual().getSiguiente() != null);
                nombreActual.setText(ruta.getParadaActual().getDato().getNombre());

                textoIzquierda.setText( ruta.getParadaActual().getAnterior() == null ? "Final" : ruta.getParadaActual().getAnterior().getDato().getNombre() );
                textoDerecha.setText( ruta.getParadaActual().getSiguiente() == null ? "Final" : ruta.getParadaActual().getSiguiente().getDato().getNombre() );
            }
        });
        window.add(derecha);

    }
}
