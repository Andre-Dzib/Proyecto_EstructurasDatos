package com.gestion_portuaria.Vistas.Patio;

import com.gestion_portuaria.Almacenamiento.ColumnaContenedores;
import com.gestion_portuaria.Carga.Contenedor;
import com.gestion_portuaria.Controladores.Patio;

import javax.swing.*;
import java.awt.*;

/**
 * Vista para seleccionar un contenedor específico dentro de las pilas del patio.
 * Permite inspeccionar cualquier contenedor de las columnas de almacenamiento,
 * mostrando botones por cada contenedor disponible en cada pila. Al seleccionar un
 * contenedor, se abre otra vista para visualizar su contenido.
 */
public class SeleccionarContenedor extends JDialog {
    /**
     * El contenedor que se seleccióno en la vista
     */
    protected Contenedor contenedorSeleccionado = null;
    /**
     * El número de columna para el contenedor
     */
    protected int columna;
    /**
     * El número de fila del contenedor
     */
    protected int fila;

    /**
     * Constructor por defecto, crea el dialog de forma correcta
     * @param parent
     */
    public SeleccionarContenedor(JFrame parent) {
        super(parent, "Seleccionar contenedor", true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(0, 0, 500, 500);
        prepareGUI();
    }
    /**
     * Abre la vista de inspección para un contenedor específico.
     * Se mueve temporalmente cualquier contenedor que esté por encima del
     * contenedor seleccionado a una pila auxiliar para poder acceder a él,
     * y luego se restauran los contenedores.
     * @param numeroColumna índice de la columna donde se encuentra el contenedor.
     * @param numeroFila índice del contenedor dentro de la columna (de arriba hacia abajo).
     */
    public void abrirContenedor(int numeroColumna, int numeroFila) {
        ColumnaContenedores columnaContenedores = Patio.columnasContenedores.get(numeroColumna);
        ColumnaContenedores auxiliar = new ColumnaContenedores(columnaContenedores.getMax());
        int size = columnaContenedores.size();

        for(int i = size; i > numeroFila; i--) {
            auxiliar.push(columnaContenedores.pop());
        }

        contenedorSeleccionado = columnaContenedores.top();
        this.columna = numeroColumna;
        this.fila = numeroFila;

        while(!auxiliar.isEmpty()) {
            columnaContenedores.push(auxiliar.pop());
        }
        dispose();
    }

    /**
     * Configura la interfaz gráfica de la vista.
     */
    public void prepareGUI() {
        JPanel listaPilas = new JPanel();
        listaPilas.setLayout(new BoxLayout(listaPilas, BoxLayout.X_AXIS));

        for(int i = 0; i < Patio.columnasContenedores.getSize(); i++) {
            JPanel infoPila = new JPanel(new GridLayout(0, 1));
            ColumnaContenedores columnaContenedores = Patio.columnasContenedores.get(i);
            infoPila.setPreferredSize(new Dimension(200, 50));
            infoPila.setMaximumSize(new Dimension(200, 80));

            ColumnaContenedores auxiliar = new ColumnaContenedores(columnaContenedores.getMax());
            int size = columnaContenedores.size();
            for(int j = size; j > 0; j--) {
                auxiliar.push(columnaContenedores.pop());

                JButton botonContenedor = new JButton(String.valueOf(j));
                botonContenedor.setToolTipText(String.valueOf(i));
                botonContenedor.addActionListener(e -> {
                    abrirContenedor(
                            Integer.parseInt(botonContenedor.getToolTipText()),
                            Integer.parseInt(botonContenedor.getText())
                    );
                });

                infoPila.add(botonContenedor);
            }

            while(!auxiliar.isEmpty()) {
                columnaContenedores.push(auxiliar.pop());
            }

            infoPila.add(new JLabel("Pila " + (i + 1)));
            listaPilas.add(infoPila);
        }

        JScrollPane scroll = new JScrollPane(listaPilas);
        scroll.setBounds(50, 50, 400, 400);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        add(scroll);
    }

    /**
     * Obtener el contenedor seleccionado en la vista
     * @return El contendor obtenido en la vista, en otro caso, null
     */
    public Contenedor getContenedorSeleccionado() {
        return contenedorSeleccionado;
    }
}