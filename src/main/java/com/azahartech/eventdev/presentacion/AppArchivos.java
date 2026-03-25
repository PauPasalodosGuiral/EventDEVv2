package com.azahartech.eventdev.presentacion;

import com.azahartech.eventdev.servicio.ServicioEvento;

public class AppArchivos {
    public static void main(String[] args) {
        ServicioEvento servicioEvento = new ServicioEvento();

        servicioEvento.importarEventosDesdeCSV("eventos_importar.csv");

        servicioEvento.listarTodosLosEventos();

    }
}
