package com.azahartech.eventdev.presentacion;

import com.azahartech.eventdev.modelo.Niveles;
import com.azahartech.eventdev.modelo.Usuario;
import com.azahartech.eventdev.servicio.ServicioEvento;
import com.azahartech.eventdev.servicio.ServicioUsuario;
import com.azahartech.eventdev.util.UtilidadLog;

import java.util.Scanner;

public class AppArchivos {
    public static void main(String[] args) {
        ServicioEvento servicioEvento = new ServicioEvento();

        servicioEvento.importarEventosDesdeCSV("datos/eventos_importar.csv");

        servicioEvento.guardar();

        ServicioUsuario servicioUsuario = new ServicioUsuario();
        servicioUsuario.registrarUsuario(new Usuario("pepe", "pepe@gmail.com", "111222333", false));
        servicioUsuario.guardar();


    }
}
