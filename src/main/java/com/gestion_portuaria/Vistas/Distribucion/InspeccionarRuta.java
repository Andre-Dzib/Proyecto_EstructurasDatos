package com.gestion_portuaria.Vistas.Distribucion;

import com.gestion_portuaria.Distribucion.Parada;
import com.gestion_portuaria.Distribucion.Ruta;
import com.gestion_portuaria.Estructuras.NodoDoble;
import com.gestion_portuaria.Vistas.Estilos;
import com.gestion_portuaria.Vistas.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InspeccionarRuta extends Vista {
    private final Ruta ruta;
    private JPanel listaRutas;
    private int contador;


    public InspeccionarRuta(Ruta ruta) {
        this.ruta = ruta;
        contador = 1;
    }

    public void actualizarLista() {
        listaRutas.removeAll();

        NodoDoble<Parada> actual = ruta.getInicio();
        while (actual != null) {
            JPanel fila = new JPanel(new GridLayout(1, 4));
            Parada parada = actual.getDato();

            fila.setPreferredSize(new Dimension(300, 40));
            fila.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

            fila.add(new JLabel(parada.getNombre()));

            JButton agregar = new JButton("↓");
            agregar.setToolTipText("Agregar una parada después de esta");
            agregar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nombre = JOptionPane.showInputDialog("Nombre de la parada");

                    if( nombre == null || nombre.isEmpty() ) {
                        return;
                    }

                    ruta.insertaDespuesDe(parada.getId(), new Parada(contador++, nombre));
                    actualizarLista();
                }
            });
            fila.add(agregar);

            JButton eliminar = new JButton("X");
            eliminar.addActionListener(e -> {
                ruta.cancelarParada(parada.getId());
                actualizarLista();
            });
            fila.add(eliminar);
            listaRutas.add(fila);
            actual = actual.getSiguiente();
        }

        listaRutas.revalidate();
        listaRutas.repaint();
    }

    @Override
    public void prepareGUI() {
        super.prepareGUI();
        window.setBounds(0, 0, 500, 500);

        Estilos.tituloCentrado(this, "Gestionar ruta", 10);

        listaRutas = new JPanel();
        listaRutas.setLayout(new BoxLayout(listaRutas, BoxLayout.Y_AXIS));

        JScrollPane scroll = new JScrollPane(listaRutas);
        scroll.setBounds(50, 60, 400, 200);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        window.add(scroll);

        Estilos.botonCentrado(this, "Agregar ruta al final", 280).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog(window, "Nombre de la parada");

                if( nombre == null || nombre.isEmpty() ) {
                    return;
                }

                ruta.insertaFinal(new Parada(contador++, nombre));
                actualizarLista();
            }
        });

        JButton agregar = Estilos.botonCentrado(this, "Navegación", 380);
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if( ruta.vacio() ) {
                    JOptionPane.showMessageDialog(window, "La ruta esta vacía, no se puede navegar");
                    return;
                }

                new Navegacion(ruta).run();
            }
        });

        actualizarLista();
    }
}
