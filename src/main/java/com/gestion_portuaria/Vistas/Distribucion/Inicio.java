package com.gestion_portuaria.Vistas.Distribucion;

import com.gestion_portuaria.Controladores.Distribucion;
import com.gestion_portuaria.Distribucion.Ruta;
import com.gestion_portuaria.Vistas.Estilos;
import com.gestion_portuaria.Vistas.Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends Vista {
    @Override
    public void prepareGUI() {
        super.prepareGUI();
        window.setBounds(0, 0, 500 ,600);
        Estilos.tituloCentrado(this, "Logística", 10);

        DefaultListModel<Ruta> modelo = new DefaultListModel<>();
        JButton zarpar = Estilos.botonCentrado(this, "Zarpar del puerto", 80);
        zarpar.setEnabled(Distribucion.contenedoresCargados != null);
        zarpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ruta nuevaRuta = new Ruta();
                nuevaRuta.setContenedores(Distribucion.contenedoresCargados);
                Distribucion.contenedoresCargados = null;
                Distribucion.rutas.insertaFinal(nuevaRuta);
                new InspeccionarRuta(nuevaRuta).run();
                zarpar.setEnabled(false);
                modelo.addElement(nuevaRuta);
            }
        });

        for(int i = 0; i < Distribucion.rutas.getSize(); i++) {
            modelo.addElement(Distribucion.rutas.get(i));
        }

        JList<Ruta> listaDeRutas = new JList<Ruta>(modelo);
        listaDeRutas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scroll = new JScrollPane(listaDeRutas);
        scroll.setBounds(50, 180, 400, 200);
        window.add(scroll);

        JButton botonRutas = Estilos.botonCentrado(this, "Inspeccionar ruta", 400);
        botonRutas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ruta seleccionada = listaDeRutas.getSelectedValue();

                if( seleccionada == null ) {
                    return;
                }

                new InspeccionarRuta(seleccionada).run();
            }
        });
    }
}
