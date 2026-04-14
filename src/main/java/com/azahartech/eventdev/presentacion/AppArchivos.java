package com.azahartech.eventdev.presentacion;

import com.azahartech.eventdev.modelo.*;
import com.azahartech.eventdev.servicio.ServicioEvento;
import com.azahartech.eventdev.servicio.ServicioUsuario;
import com.azahartech.eventdev.util.UtilidadLog;

import java.time.LocalDate;
import java.util.Scanner;

public class AppArchivos {
    public static void main(String[] args) {
        ServicioEvento servicioEvento = new ServicioEvento();
        for (Evento evento : servicioEvento.listarTodosLosEventos()) {
            System.out.println(evento.getNombre());
        }


        servicioEvento.guardar();



        ServicioUsuario servicioUsuario = new ServicioUsuario();
        servicioUsuario.registrarUsuario(new Usuario("pepe", "pepe@gmail.com", "111222333", false));
        servicioUsuario.guardar();


    }
}
