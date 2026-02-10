package com.gestion_portuaria.Vistas.Patio;

import com.gestion_portuaria.Almacenamiento.ColumnaContenedores;
import com.gestion_portuaria.Controladores.Patio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Diálogo modal para seleccionar una pila de contenedores en el patio.
 * Se utiliza tanto para agregar contenedores a una pila (Push) como
 * para retirar contenedores de una pila (Pop).
 * Cada pila muestra su número, la cantidad actual de contenedores y su capacidad máxima.
 * Los botones se habilitan o deshabilitan según si la pila puede recibir un nuevo contenedor o si tiene contenedores disponibles
 * para extraer.
 */
public class SeleccionarPila extends JDialog {
    /**
     * Índice de la pila seleccionada por el usuario.
     * Será null si el usuario cierra el diálogo sin seleccionar ninguna pila.
     */
    public Integer numeroPila = null;
    /**
     * Indica si el diálogo se usa para agregar contenedores true o retirar false.
     */
    private final boolean meter;

    /**
     * Constructor para seleccionar una pila para agregar contenedores.
     * @param parent ventana padre del diálogo
     */
    public SeleccionarPila(JFrame parent) {
        this(parent, true);
    }

    /**
     * Constructor para seleccionar una pila.
     * @param parent La ventana padre del diálogo
     * @param meter true si se usa para agregar contenedores, false si se usa para retirar
     */
    public SeleccionarPila(JFrame parent, boolean meter) {
        // El true es para indicar que es un modal
        super(parent, "Seleccionar pila", true);
        this.meter = meter;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(0, 0, 500, 500);

        prepareGUI();
    }

    /**
     * Configura la interfaz gráfica del diálogo.
     *
     * <p>Crea un panel horizontal con columnas de pilas. Cada columna muestra
     * la cantidad de contenedores, su capacidad máxima y un botón para seleccionarla.
     * Los botones se deshabilitan según el modo (meter/retirar) y el estado de la pila.</p>
     */
    public void prepareGUI() {
        JPanel listaPilas = new JPanel();
        listaPilas.setLayout(new BoxLayout(listaPilas, BoxLayout.X_AXIS));

        for(int i = 0; i < Patio.columnasContenedores.getSize(); i++) {
            JPanel infoPila = new JPanel(new GridLayout(0, 1));
            ColumnaContenedores columnaContenedores = Patio.columnasContenedores.get(i);
            infoPila.setPreferredSize(new Dimension(200, 50));
            infoPila.setMaximumSize(new Dimension(200, 80));

            infoPila.add(new JLabel("Contenedores: " + columnaContenedores.size()));
            infoPila.add(new JLabel("Maximo: " + columnaContenedores.getMax()));

            JButton button = new JButton("Pila " + (i + 1));

            // Validación según si es para meter o sacar contenedores
            if(meter) {
                if(columnaContenedores.isFull()) {
                    button.setEnabled(false);
                }
            } else {
                if(columnaContenedores.isEmpty()) {
                    button.setEnabled(false);
                }
            }

            button.setToolTipText(String.valueOf(i));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    numeroPila = Integer.parseInt(button.getToolTipText());
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