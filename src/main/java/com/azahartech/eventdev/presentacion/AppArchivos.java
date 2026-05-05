package com.azahartech.eventdev.presentacion;

import com.azahartech.eventdev.modelo.*;
import com.azahartech.eventdev.servicio.ServicioEvento;
import com.azahartech.eventdev.servicio.ServicioUsuario;
import com.azahartech.eventdev.util.UtilidadLog;

import java.time.LocalDate;
import java.util.Scanner;

public class AppArchivos {
    public static void main(String[] args) {
        ServicioEvento servicio = new ServicioEvento();

        Evento evento = new Concierto("Concierto Evento 1", LocalDate.of(2021, 12, 31), new Recinto("recinto1", "direccion1", 100), 100, TipoEvento.CONCIERTO, "Banda1", 2000,"Cancion1, Cancion2, Cancion23");

        servicio.registrarEvento(new Concierto("Concierto Evento 1", LocalDate.of(2021, 12, 31), new Recinto("recinto1", "direccion1", 100), 100, TipoEvento.CONCIERTO, "Banda1", 2000,"Cancion1, Cancion2, Cancion23"));
        servicio.registrarEvento(new Concierto("Concierto Evento 3", LocalDate.of(2033, 12, 31), new Recinto("recinto3", "direccion3", 120), 120, TipoEvento.CONCIERTO, "Banda2", 4000,"Cancion5, Cancion6, Cancion31"));
        servicio.registrarEvento(new Concierto("Concierto Evento 5", LocalDate.of(2026, 12, 31), new Recinto("recinto5", "direccion5", 140), 140, TipoEvento.CONCIERTO, "Banda3", 20000,"Cancion2, Cancion23, Cancion13"));
        servicio.registrarEvento(new Concierto("Concierto Evento 7", LocalDate.of(2027, 12, 31), new Recinto("recinto7", "direccion7", 160), 160, TipoEvento.CONCIERTO, "Banda4", 7000,"Cancion6, Cancion23, Cancion35"));


        servicio.exportarCatalogoAXML( "datos/agenda_export.xml");
        servicio.importarCatalogoDesdeXML("datos/agenda_export.xml");

    }
}
