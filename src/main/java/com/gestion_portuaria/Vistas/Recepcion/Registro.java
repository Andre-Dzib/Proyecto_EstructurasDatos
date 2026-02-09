package com.gestion_portuaria.Vistas.Recepcion;

import com.gestion_portuaria.Carga.Contenedor;
import com.gestion_portuaria.Controladores.Recepcion;
import com.gestion_portuaria.Controladores.Vistas;
import com.gestion_portuaria.Recepcion.Camion;
import com.gestion_portuaria.Vistas.Estilos;
import com.gestion_portuaria.Vistas.Patio.InspeccionarContenedor;
import com.gestion_portuaria.Vistas.Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro extends Vista {
    protected JTextField placaCamion;
    protected JLabel status;
    protected Contenedor contenedor;

    public Registro() {
        super("Registro camión");
        this.contenedor = new Contenedor();
    }

    @Override
    public void prepareGUI() {
        super.prepareGUI();
        window.setBounds(0, 0, 500, 500);

        Estilos.tituloCentrado(this, "Agregar camión", 10);

        status = new JLabel("", JLabel.CENTER);
        status.setBounds(0, 50, window.getWidth(), 30);
        window.add(status);

        {
            JLabel label = new JLabel("Placa del camion:", JLabel.CENTER);
            label.setBounds(0, 80, window.getWidth(), 30);
            window.add(label);
        }

        placaCamion = new JTextField();
        placaCamion.setBounds(100, 120, 300, 50);
        window.add(placaCamion);

        Estilos.botonCentrado(this, "Inspeccionar contenedor", 200).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InspeccionarContenedor vista = new InspeccionarContenedor(contenedor);
                vista.run();
            }
        });

        Estilos.botonCentrado(this, "Agregar", 350).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String placa = placaCamion.getText();
                // Elimina los espacios vacíos
                placa = placa.replaceAll("\\s+", "");

                if( placa.contentEquals("") ) {
                    status.setText("No se puede agregar un camión sin placa");
                    return;
                }

                Recepcion.colaCamiones.enqueue(new Camion(contenedor, placa));
                closeWindow();
                // Casteo para indicar que se ha agregado el camión
                ((Inicio) Vistas.vistaActual ).status.setText("Se ha agregado el camión correctamente");
            }
        });
    }
}
