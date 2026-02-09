package com.gestion_portuaria.Vistas;

import com.gestion_portuaria.Controladores.Vistas;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public abstract class Vista {
    protected final JFrame window;
    protected boolean isReady;

    public Vista() {
        this("Gestión portuaria");
    }

    public Vista(String nombre) {
        window = new JFrame(nombre);
        isReady = false;
    }

    public void prepareGUI() {
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}

            @Override
            public void windowClosing(WindowEvent e) {
                window.setVisible(false);
                Vistas.vistaActual = Vistas.vistasAnteriores.pop();

                if( Vistas.vistaActual == null ) {
                    return;
                }
                Vistas.vistaActual.window.setVisible(true);
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

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

    public void run() {
        if( ! isReady ) {
            prepareGUI();
        }

        if( Vistas.vistaActual != null ) {
            Vistas.vistaActual.window.setVisible(false);
            Vistas.vistasAnteriores.push(Vistas.vistaActual);
        }

        Vistas.vistaActual = this;
        window.setVisible(true);
    }

    public void closeWindow() {
        window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
    }
}
