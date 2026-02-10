package com.gestion_portuaria.Vistas.Patio;

import com.gestion_portuaria.Carga.Contenedor;
import com.gestion_portuaria.Carga.Producto;
import com.gestion_portuaria.Estructuras.Nodo;
import com.gestion_portuaria.Vistas.Estilos;
import com.gestion_portuaria.Vistas.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Vista para inspeccionar y gestionar el contenido de un contenedor.
 * Permite:
 * Visualizar la lista de productos con su ID, nombre y peso.
 * Agregar nuevos productos al contenedor.
 * Eliminar productos existentes.
 * Calcular el peso total del contenedor.
 */
public class InspeccionarContenedor extends Vista {
    /**
     * Contenedor cuyos productos se van a inspeccionar.
     */
    protected Contenedor contenedor;

    /**
     * Panel que muestra la lista de productos dentro del contenedor.
     */
    protected JPanel listaProductos;

    /**
     * Constructor de la vista.
     * @param contenedor Contenedor a inspeccionar.
     */
    public InspeccionarContenedor(Contenedor contenedor) {
        this.contenedor = contenedor;
    }

    /**
     * Actualiza la lista de productos mostrada en la interfaz.
     * Elimina los elementos existentes y genera un panel por cada producto
     * con su ID, nombre, peso y un botón para eliminarlo.
     */
    public void actualizarLista() {
        listaProductos.removeAll();

        Nodo<Producto> actual = contenedor.getInicio();
        while (actual != null) {
            JPanel fila = new JPanel(new GridLayout(1, 4));
            Producto producto = actual.getDato();
            fila.setPreferredSize(new Dimension(300, 40));
            fila.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

            fila.add(new JLabel(String.valueOf(producto.getId()), JLabel.CENTER));
            fila.add(new JLabel(producto.getNombre(), JLabel.CENTER));
            fila.add(new JLabel(producto.getPeso() + " kg", JLabel.CENTER));

            JButton eliminar = new JButton("X");
            eliminar.addActionListener(e -> {
                contenedor.eliminaProducto(producto.getNombre());
                actualizarLista();
            });

            fila.add(eliminar);
            listaProductos.add(fila);
            actual = actual.getSiguiente();
        }

        listaProductos.revalidate();
        listaProductos.repaint();
    }

    /**
     * Configura la interfaz gráfica de la vista.
     */
    @Override
    public void prepareGUI() {
        super.prepareGUI();
        window.setBounds(0, 0, 500, 500);

        Estilos.tituloCentrado(this, "Contenido contenedor", 10);

        listaProductos = new JPanel();
        listaProductos.setLayout(new BoxLayout(listaProductos, BoxLayout.Y_AXIS));

        JScrollPane scroll = new JScrollPane(listaProductos);
        scroll.setBounds(50, 60, 400, 200);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        window.add(scroll);

        Estilos.botonCentrado(this, "Calcular peso total", 280).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(window, "Peso total", true);
                dialog.setBounds(0, 0, 300, 100);
                dialog.add(new JLabel("El peso total es: " + contenedor.getPesoTotal()));
                dialog.setVisible(true);
            }
        });

        JButton agregar = Estilos.botonCentrado(this, "Agregar producto", 380);
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog(window, "Nombre del producto:");
                if (nombre == null || nombre.isEmpty()) return;

                double peso;
                try {
                    peso = Double.parseDouble(
                            JOptionPane.showInputDialog(window, "Peso en kilos:")
                    );
                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(window, "No se ha especificado un peso valido");
                    return;
                }

                int id = (int) (Math.random() * 10000);
                contenedor.insertaFinal(new Producto(id, nombre, peso));
                actualizarLista();
            }
        });

        actualizarLista();
    }
}