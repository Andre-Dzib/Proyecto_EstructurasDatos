package com.gestion_portuaria.Vistas.Patio;

import com.gestion_portuaria.Almacenamiento.ColumnaContenedores;
import com.gestion_portuaria.Carga.Contenedor;
import com.gestion_portuaria.Controladores.Distribucion;
import com.gestion_portuaria.Controladores.Patio;
import com.gestion_portuaria.Estructuras.ListaSimple;
import com.gestion_portuaria.Vistas.Estilos;
import com.gestion_portuaria.Vistas.Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Vista principal del patio de contenedores.
 * Permite realizar operaciones sobre las pilas de contenedores asociadas a los camiones
 * que han ingresado al patio, incluyendo:
 * Ingresar contenedores en las pilas (Push).
 * Retirar contenedores para su distribución (Pop).
 * Inspeccionar el contenedor superior de cada pila (Peek).
 * Inspeccionar cualquier contenedor del patio.
 */
public class Inicio extends Vista {
    /**
     * Etiqueta para mostrar mensajes de estado al usuario.
     */
    public JLabel status;

    /**
     * Configura la interfaz gráfica del patio de contenedores.
     */
    @Override
    public void prepareGUI() {
        super.prepareGUI();
        window.setBounds(0, 0, 500, 500);

        status = new JLabel("", JLabel.CENTER);
        status.setBounds(0, 35, window.getWidth(), 50);
        window.add(status);

        Estilos.tituloCentrado(this, "Patio de contenedores", 10);

        Estilos.botonCentrado(this, "Ingresar contenedor (Push)", 80)
                .addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(Patio.entrante == null) {
                            status.setText("No hay un camión en el patio de contenedores");
                            return;
                        }

                        SeleccionarPila seleccionarPila = new SeleccionarPila(window);
                        seleccionarPila.setVisible(true);

                        if( seleccionarPila.numeroPila == null ) {
                            return;
                        }

                        Patio.columnasContenedores.get(seleccionarPila.numeroPila)
                                .push(Patio.entrante.getContenedor());
                        Patio.entrante = null;
                        status.setText("Se ha agregado el contenedor a la pila " + (seleccionarPila.numeroPila + 1));
                    }
                });

        Estilos.botonCentrado(this, "Retirar contenedor para ruta (Pop)", 170)
                .addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SeleccionarContenedor seleccionarContenedor = new SeleccionarContenedor(window);
                        seleccionarContenedor.setVisible(true);

                        Contenedor contenedor = seleccionarContenedor.getContenedorSeleccionado();

                        if( contenedor == null ) {
                            return;
                        }

                        if(Distribucion.contenedoresCargados == null) {
                            Distribucion.contenedoresCargados = new ListaSimple<>();
                        }

                        ColumnaContenedores columnaContenedores = Patio.columnasContenedores.get(seleccionarContenedor.columna);
                        ColumnaContenedores auxiliar = new ColumnaContenedores(columnaContenedores.getMax());

                        while( columnaContenedores.top() != contenedor ) {
                            auxiliar.push(columnaContenedores.pop());
                        }

                        Distribucion.contenedoresCargados.insertaFinal(columnaContenedores.pop());

                        while( ! auxiliar.isEmpty() ) {
                            columnaContenedores.push(auxiliar.pop());
                        }

                        status.setText("El contenedor ha salido para envío");
                    }
                });

        Estilos.botonCentrado(this, "Ver tope de las pilas (Peek)", 260)
                .addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SeleccionarPila seleccionarPila = new SeleccionarPila(window, false);
                        seleccionarPila.setVisible(true);

                        if( seleccionarPila.numeroPila == null ) {
                            return;
                        }

                        InspeccionarContenedor inspeccionarContenedor =
                                new InspeccionarContenedor(Patio.columnasContenedores.get(seleccionarPila.numeroPila).top());
                        inspeccionarContenedor.run();
                    }
                });

        Estilos.botonCentrado(this, "Inspeccionar contenedor", 350)
                .addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SeleccionarContenedor seleccionarContenedor = new SeleccionarContenedor(window);
                        seleccionarContenedor.setVisible(true);
                        Contenedor contenedor = seleccionarContenedor.getContenedorSeleccionado();

                        if(contenedor == null) {
                            return;
                        }

                        new InspeccionarContenedor(contenedor).run();
                    }
                });
    }
}