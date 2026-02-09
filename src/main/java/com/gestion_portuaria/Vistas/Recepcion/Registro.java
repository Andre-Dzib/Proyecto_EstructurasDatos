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

/**
 * Vista para registrar la llegada de un camión a la cola de recepción.
 * Permite ingresar la placa del camión, inspeccionar el contenedor
 * que transporta, y agregarlo a la cola de recepción.
 */
public class Registro extends Vista {
    /**
     * Campo de texto donde el usuario ingresa la placa del camión
     */
    protected JTextField placaCamion;

    /**
     * Label donde se muestran mensajes de estado
     */
    protected JLabel status;

    /**
     * Contenedor que transporta el camión a registrar
    */
    protected Contenedor contenedor;

    /**
     * Constructor de la vista.
     * Inicializa la ventana con título "Registro camión" y
     * crea un contenedor vacío para el camión.
     */
    public Registro() {
        super("Registro camión");
        this.contenedor = new Contenedor();
    }

    /**
     * Prepara la interfaz gráfica de la vista.
     */
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
                String placa = placaCamion.getText().replaceAll("\\s+", "");

                if ( placa.isEmpty() ) {
                    status.setText("No se puede agregar un camión sin placa");
                    return;
                }

                Recepcion.colaCamiones.enqueue(new Camion(contenedor, placa));
                closeWindow();

                ((Inicio) Vistas.vistaActual).status.setText("Se ha agregado el camión correctamente");
            }
        });
    }
}