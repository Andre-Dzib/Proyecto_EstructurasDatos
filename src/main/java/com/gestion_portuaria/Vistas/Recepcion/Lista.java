package com.gestion_portuaria.Vistas.Recepcion;

import com.gestion_portuaria.Controladores.Recepcion;
import com.gestion_portuaria.Recepcion.Camion;
import com.gestion_portuaria.Recepcion.ColaCamiones;
import com.gestion_portuaria.Vistas.Estilos;
import com.gestion_portuaria.Vistas.Vista;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa la vista para mostrar la lista de camiones que se encuentran actualmente en la cola de recepción.
 * Permite visualizar todas las placas de los camiones en una ventana con scroll, manteniendo el orden original de la cola.
 */
public class Lista extends Vista {

    /**
     * Prepara la interfaz gráfica de la lista de camiones.
     * Se crea un panel con scroll donde se muestran todas las placas
     * de los camiones de la cola de recepción.
     */
    @Override
    public void prepareGUI() {
        super.prepareGUI();
        window.setBounds(0, 0, 500, 500);

        // Título centrado de la ventana
        Estilos.tituloCentrado(this, "Lista de camiones", 10);

        // Panel vertical que contendrá todos los labels de placas
        JPanel listaCamiones = new JPanel();
        listaCamiones.setLayout(new BoxLayout(listaCamiones, BoxLayout.Y_AXIS));

        {
            // Cola auxiliar para no alterar la cola original
            ColaCamiones auxiliar = new ColaCamiones();
            int size = Recepcion.colaCamiones.size();

            // Recorre la cola original, crea un JLabel para cada camión
            for (int i = 0; i < size; i++) {
                Camion actual = Recepcion.colaCamiones.front();
                auxiliar.enqueue(Recepcion.colaCamiones.dequeue());

                JLabel placa = new JLabel(actual.getPlaca(), JLabel.CENTER);
                placa.setFont(new Font(placa.getFont().getName(), Font.PLAIN, 40));
                placa.setPreferredSize(new Dimension(400, 60));
                placa.setMaximumSize(new Dimension(400, 80));

                listaCamiones.add(placa);
            }

            // Vuelve a insertar los camiones en la cola original
            for (int i = 0; i < size; i++) {
                Recepcion.colaCamiones.enqueue(auxiliar.dequeue());
            }
        }

        // Scroll para la lista de placas
        JScrollPane scroll = new JScrollPane(listaCamiones);
        scroll.setBounds(50, 50, 400, 400);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        window.add(scroll);
    }
}