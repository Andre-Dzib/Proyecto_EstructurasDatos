package com.gestion_portuaria.Vistas;

import com.gestion_portuaria.Controladores.Vistas;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Clase abstracta que representa una ventana del sistema de gestión portuaria.
 * Proporciona la estructura base para todas las vistas de la aplicación,
 * y maneja la visibilidad de las vistas
 */
public abstract class Vista {
    /** Ventana principal asociada a esta vista */
    protected final JFrame window;
    /** Indica si la interfaz de la vista está lista para mostrarse */
    protected boolean isReady;

    /**
     * Constructor por defecto.
     * Crea una ventana con el título por defecto "Gestión portuaria".
     */
    public Vista() {
        this("Gestión portuaria");
    }

    /**
     * Constructor con título personalizado.
     * @param nombre Título de la ventana
     */
    public Vista(String nombre) {
        window = new JFrame(nombre);
        isReady = false;
    }

    /**
     * Prepara la interfaz gráfica de la vista.
     * Configura la posición de la ventana, el layout, el comportamiento
     * al cerrar y agrega un listener para manejar el cambio de vistas.
     */
    public void prepareGUI() {
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Manejo del cierre de ventana y navegación hacia la vista anterior
        window.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}

            @Override
            public void windowClosing(WindowEvent e) {
                window.setVisible(false);

                // Retrocede a la vista anterior en la pila
                Vistas.vistaActual = Vistas.vistasAnteriores.pop();

                if (Vistas.vistaActual == null) {
                    return; // No hay vista anterior, se termina
                }

                // Muestra la vista anterior
                Vistas.vistaActual.window.setVisible(true);
            }

            @Override
            public void windowClosed(WindowEvent e) {}

            @Override
            public void windowIconified(WindowEvent e) {}

            @Override
            public void windowDeiconified(WindowEvent e) {}

            @Override
            public void windowActivated(WindowEvent e) {}

            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
        isReady = true;
    }

    /**
     * Ejecuta la vista.
     * Si la vista no está lista, la prepara. Oculta la vista actual (si existe)
     * y la agrega a la pila de vistas anteriores antes de mostrar esta vista.
     */
    public void run() {
        if (!isReady) {
            prepareGUI();
        }

        if (Vistas.vistaActual != null) {
            Vistas.vistaActual.window.setVisible(false);
            Vistas.vistasAnteriores.push(Vistas.vistaActual);
        }

        Vistas.vistaActual = this;
        window.setVisible(true);
    }

    /**
     * Cierra la ventana de la vista.
     * Simula un evento de cierre de ventana para que se ejecute el manejo de navegación hacia la vista anterior.
     */
    public void closeWindow() {
        window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
    }
}