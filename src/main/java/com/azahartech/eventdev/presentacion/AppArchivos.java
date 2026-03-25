package com.azahartech.eventdev.presentacion;

import com.azahartech.eventdev.modelo.Niveles;
import com.azahartech.eventdev.servicio.ServicioEvento;
import com.azahartech.eventdev.util.UtilidadLog;

import java.util.Scanner;

public class AppArchivos {
    public static void main(String[] args) {
        ServicioEvento servicioEvento = new ServicioEvento();

        servicioEvento.importarEventosDesdeCSV("datos/eventos_importar.csv");

        servicioEvento.listarTodosLosEventos();

        servicioEvento.contarEventosGratuitos();

        UtilidadLog.registrar(Niveles.ERROR, "holi");
    }
}
