package com.gestion_portuaria;

import com.formdev.flatlaf.FlatLightLaf;
import com.gestion_portuaria.Almacenamiento.ColumnaContenedores;
import com.gestion_portuaria.Carga.Contenedor;
import com.gestion_portuaria.Carga.Producto;
import com.gestion_portuaria.Controladores.Patio;
import com.gestion_portuaria.Vistas.MenuPrincipal;

/**
 * Clase principal de la aplicación del sistema de gestión portuaria.
 * Se encarga de inicializar las estructuras de datos del patio de contenedores,
 * realizar pruebas de llenado de pilas de contenedores y ejecutar la interfaz gráfica
 */
public class Main {

    /**
     * Inicializa las columnas de contenedores en el patio.
     * Crea 6 columnas de contenedores con alturas decrecientes
     */
    public static void inicializarPilaContenedores() {
        for(int i = 0; i < 6; i++) {
            Patio.columnasContenedores.insertaFinal(new ColumnaContenedores(5 - i));
        }
    }

    /**
     * Realiza una prueba de llenado de contenedores en la primera columna del patio.
     * Crea contenedores de manzanas y peras, los llena con productos y los apila en la primera columna de contenedores.
     */
    public static void testPilaContenedores() {
        // Obtiene la primera columna de contenedores
        ColumnaContenedores columna = Patio.columnasContenedores.get(0);

        // Crea y llena un contenedor de manzanas
        Contenedor contenedorManzanas = new Contenedor();
        contenedorManzanas.insertaFinal(new Producto(0, "Manzana", 0.1));
        contenedorManzanas.insertaFinal(new Producto(1, "Manzana", 0.1));
        contenedorManzanas.insertaFinal(new Producto(2, "Manzana", 0.1));
        contenedorManzanas.insertaFinal(new Producto(3, "Manzana", 0.1));
        contenedorManzanas.insertaFinal(new Producto(4, "Manzana", 0.1));
        columna.push(contenedorManzanas);

        // Agrega un contenedor vacío adicional
        columna.push(new Contenedor());

        // Crea y llena un contenedor de peras
        Contenedor contenedorPeras = new Contenedor();
        contenedorPeras.insertaInicio(new Producto(0, "Pera", 0.2));
        contenedorPeras.insertaInicio(new Producto(1, "Pera", 0.2));
        contenedorPeras.insertaInicio(new Producto(2, "Pera", 0.2));
        contenedorPeras.insertaInicio(new Producto(3, "Pera", 0.2));
        contenedorPeras.insertaInicio(new Producto(4, "Pera", 0.2));
        contenedorPeras.insertaInicio(new Producto(5, "Pera", 0.2));

        // Apila el contenedor de peras en la columna
        columna.push(contenedorPeras);
    }

    /**
     * Método principal
     * Inicializa las columnas de contenedores, realiza pruebas de llenado de contenedores,
     * configura el tema de la interfaz gráfica y ejecuta el menú principal.
     */
    public static void main(String[] args) {
        // Inicializa las columnas en el patio
        inicializarPilaContenedores();

        // Realiza prueba de llenado de contenedores
        testPilaContenedores();

        // Configura el tema de la interfaz gráfica
        FlatLightLaf.setup();

        // Ejecuta la ventana principal del sistema
        new MenuPrincipal().run();
    }
}