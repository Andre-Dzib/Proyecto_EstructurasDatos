package com.gestion_portuaria.Vistas.Reporte;

import com.gestion_portuaria.Almacenamiento.ColumnaContenedores;
import com.gestion_portuaria.Controladores.Distribucion;
import com.gestion_portuaria.Controladores.Patio;
import com.gestion_portuaria.Controladores.Recepcion;
import com.gestion_portuaria.Distribucion.Ruta;
import com.gestion_portuaria.Estructuras.Nodo;
import com.gestion_portuaria.Vistas.Estilos;
import com.gestion_portuaria.Vistas.Vista;

import javax.swing.*;
import java.awt.*;

/**
 * Vista para mostrar el reporte general del sistema portuario.
 * Incluye información sobre:
 *  Estado de recepción (colas de camiones)
 *  Estado de logística en el patio (pilas de contenedores)
 *  Estado de rutas de distribución (listas dobles)
 */
public class Inicio extends Vista {
    /**
     * Configura la interfaz gráfica de la ventana de reporte.
     * Se crean paneles separados para cada sección del reporte y se muestran
     * datos en etiquetas y tablas usando JScrollPane cuando es necesario.
     */
    @Override
    public void prepareGUI() {
        super.prepareGUI();
        window.setBounds(0, 0, 500, 700);
        Estilos.tituloCentrado(this, "Reporte general", 10);

        prepararRecepcion();
        prepararLogistica();
        prepararDistribucion();
    }

    /**
     * Prepara la sección de recepción de camiones.
     * Muestra:
     * Cantidad de camiones en espera.
     * El próximo camión en turno (si hay alguno).
     */
    private void prepararRecepcion() {
        JPanel contenedor = new JPanel(null);
        contenedor.setBounds(5, 50, 490, 100);

        JLabel titulo = new JLabel("Estado recepción", JLabel.CENTER);
        titulo.setBounds(0, 0, contenedor.getWidth(), 30);
        contenedor.add(titulo);

        JLabel espera = new JLabel("Camiones en espera: " + Recepcion.colaCamiones.size());
        espera.setBounds(0, 30, contenedor.getWidth(), 30);
        contenedor.add(espera);

        // Muestra el próximo camión en turno, si existe
        if (!Recepcion.colaCamiones.isEmpty()) {
            JLabel proximo = new JLabel(
                    "Próximo en turno: Placa[" + Recepcion.colaCamiones.front().getPlaca() + "]");
            proximo.setBounds(0, 60, contenedor.getWidth(), 40);
            contenedor.add(proximo);
        }

        window.add(contenedor);
    }

    /**
     * Prepara la sección de logística (Patio de contenedores).
     * Muestra:
     * Número de contenedor.
     * Cantidad de contenedores actuales / capacidad máxima.
     * Peso total de los contenedores.
     * Estado crítico si la columna está llena.
     */
    private void prepararLogistica() {
        JPanel contenedor = new JPanel(null);
        contenedor.setBounds(10, 150, 480, 200);

        JLabel titulo = new JLabel("Estado logística", JLabel.CENTER);
        titulo.setBounds(0, 0, contenedor.getWidth(), 30);
        contenedor.add(titulo);

        // Panel que contendrá las filas de cada columna de contenedores
        JPanel listaPilas = new JPanel();
        listaPilas.setLayout(new BoxLayout(listaPilas, BoxLayout.Y_AXIS));

        Nodo<ColumnaContenedores> actual = Patio.columnasContenedores.getInicio();
        int contador = 1;

        // Recorre todas las columnas de contenedores
        while (actual != null) {
            JPanel fila = new JPanel(new GridLayout(1, 4));
            fila.setPreferredSize(new Dimension(460, 40));
            fila.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

            ColumnaContenedores columna = actual.getDato();
            fila.add(new JLabel("Contenedor " + (contador++)));
            fila.add(new JLabel(String.format("(%d/%d)", columna.size(), columna.getMax())));

            // Calcula el peso total de los contenedores
            double pesoTotal = 0.0d;
            ColumnaContenedores auxiliar = new ColumnaContenedores(columna.getMax());

            // Va sacando cada contenedor individualmente sumando su peso en el proceso
            while (!columna.isEmpty()) {
                pesoTotal += columna.top().getPesoTotal();
                auxiliar.push(columna.pop());
            }

            // Vuelve a ingresar los contenedores a la pila original
            while (!auxiliar.isEmpty()) {
                columna.push(auxiliar.pop());
            }

            fila.add(new JLabel("Peso total: " + pesoTotal));
            fila.add(new JLabel(columna.isFull() ? "Crítico: Llena" : ""));

            listaPilas.add(fila);
            actual = actual.getSiguiente();
        }

        JScrollPane scroll = new JScrollPane(listaPilas);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(10, 30, 460, 120);
        contenedor.add(scroll);
        window.add(contenedor);
    }

    /**
     * Prepara la sección de distribución (Rutas de reparto).
     * Muestra:
     * Parada actual.
     * Próxima parada (o "Fin" si es la última).
     * Cantidad de paradas restantes en la ruta.
     */
    private void prepararDistribucion() {
        JPanel contenedor = new JPanel(null);
        contenedor.setBounds(10, 350, 480, 200);

        JLabel titulo = new JLabel("Estado logística", JLabel.CENTER);
        titulo.setBounds(0, 0, contenedor.getWidth(), 30);
        contenedor.add(titulo);

        JPanel listaRutas = new JPanel();
        listaRutas.setLayout(new BoxLayout(listaRutas, BoxLayout.Y_AXIS));

        Nodo<Ruta> actual = Distribucion.rutas.getInicio();

        while (actual != null) {
            JPanel fila = new JPanel(new GridLayout(1, 3));
            fila.setPreferredSize(new Dimension(460, 40));
            fila.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

            Ruta rutaActual = actual.getDato();

            if (rutaActual.getParadaActual() == null) {
                fila.add(new JLabel("Ruta"));
                fila.add(new JLabel("no"));
                fila.add(new JLabel("inicializada"));
            } else {
                fila.add(new JLabel(rutaActual.getParadaActual().getDato().getNombre()));
                fila.add(new JLabel(rutaActual.getParadaActual().getSiguiente() == null
                        ? "Fin"
                        : rutaActual.getParadaActual().getSiguiente().getDato().getNombre()));
                fila.add(new JLabel(String.valueOf(rutaActual.size())));
            }

            listaRutas.add(fila);
            actual = actual.getSiguiente();
        }

        JScrollPane scroll = new JScrollPane(listaRutas);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(10, 30, 460, 120);
        contenedor.add(scroll);
        window.add(contenedor);
    }
}