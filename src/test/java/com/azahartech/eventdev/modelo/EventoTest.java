package com.azahartech.eventdev.modelo;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class EventoTest {

    @Test
    void debeDeVolverElNombreDelEvento() {
        Recinto recinto = new Recinto("Estadio", "Madrid", 50000);
        LocalDate fecha = LocalDate.of(2025, 5, 20);
        Concierto evento = new Concierto("CONCIERTO", fecha, recinto, 50.0, TipoEvento.CONCIERTO, "Banda", 5000.0, "Canción 1");

        assertEquals("CONCIERTO", evento.getNombre());
    }

    @Test
    void debeDeCambiarElNombreDelEvento() {
        Recinto recinto = new Recinto("Estadio", "Madrid", 50000);
        LocalDate fecha = LocalDate.of(2025, 5, 20);
        Concierto evento = new Concierto("CONCIERTO", fecha, recinto, 50.0, TipoEvento.CONCIERTO, "Banda", 5000.0, "Canción 1");

        evento.setNombre("Nuevo Concierto");
        assertEquals("Nuevo Concierto", evento.getNombre());
    }

    @Test
    void DebeDeVolverLaFechaDelEvento() {
        Recinto recinto = new Recinto("Estadio", "Madrid", 50000);
        LocalDate fecha = LocalDate.of(2025, 5, 20);
        Concierto evento = new Concierto("CONCIERTO", fecha, recinto, 50.0, TipoEvento.CONCIERTO, "Banda", 5000.0, "Canción 1");

        assertEquals(fecha, evento.getFecha());
    }

    @Test
    void DebeDeCambiarLaFechaDelEvento() {
        Recinto recinto = new Recinto("Estadio", "Madrid", 50000);
        LocalDate fecha = LocalDate.of(2025, 5, 20);
        Concierto evento = new Concierto("CONCIERTO", fecha, recinto, 50.0, TipoEvento.CONCIERTO, "Banda", 5000.0, "Canción 1");

        LocalDate nuevaFecha = LocalDate.of(2025, 6, 15);
        evento.setFecha(nuevaFecha);
        assertEquals(nuevaFecha, evento.getFecha());
    }

}