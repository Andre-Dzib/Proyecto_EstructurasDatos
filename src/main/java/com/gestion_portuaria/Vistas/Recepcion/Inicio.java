package com.gestion_portuaria.Vistas.Recepcion;

import com.gestion_portuaria.Vistas.Estilos;
import com.gestion_portuaria.Vistas.Vista;

public class Principal extends Vista {
    @Override
    public void prepareGUI() {
        super.prepareGUI();
        window.setBounds(0, 0, 500, 500);
        Estilos.tituloCentrado(this, "Recepción", 10);
        Estilos.botonCentrado(this, "Registrar llegada camión (Enqueue)", 80);
        Estilos.botonCentrado(this, "Dar ingreso a patio (Dequeue)", 170);
        Estilos.botonCentrado(this, "Ver próximo camión (Peek)", 260);
        Estilos.botonCentrado(this, "Listar todos los camiones", 350);
    }
}
