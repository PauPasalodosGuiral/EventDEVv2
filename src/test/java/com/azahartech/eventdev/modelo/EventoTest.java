package com.azahartech.eventdev.modelo;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class EventoTest {

    @Test
    void testConstructor() {
        Recinto recinto = new Recinto("Estadio", "Madrid", 50000);
        LocalDate fecha = LocalDate.of(2025, 5, 20);
        Concierto evento = new Concierto("CONCIERTO", fecha, recinto, 50.0, TipoEvento.CONCIERTO, "Banda", 5000.0, "Canción 1");

        assertEquals("CONCIERTO", evento.getNombre());
        assertEquals(fecha, evento.getFecha());
        assertEquals(recinto, evento.getRecinto());
        assertEquals(50.0, evento.getPrecio());
        assertEquals(EstadoEvento.PLANIFICADO, evento.getEstado());
        assertNotNull(evento.getId());
    }

    @Test
    void testGetNombre() {
        Recinto recinto = new Recinto("Estadio", "Madrid", 50000);
        LocalDate fecha = LocalDate.of(2025, 5, 20);
        Concierto evento = new Concierto("CONCIERTO", fecha, recinto, 50.0, TipoEvento.CONCIERTO, "Banda", 5000.0, "Canción 1");

        assertEquals("CONCIERTO", evento.getNombre());
    }

    @Test
    void testSetNombre() {
        Recinto recinto = new Recinto("Estadio", "Madrid", 50000);
        LocalDate fecha = LocalDate.of(2025, 5, 20);
        Concierto evento = new Concierto("CONCIERTO", fecha, recinto, 50.0, TipoEvento.CONCIERTO, "Banda", 5000.0, "Canción 1");

        evento.setNombre("Nuevo Concierto");
        assertEquals("Nuevo Concierto", evento.getNombre());
    }

    @Test
    void testGetFecha() {
        Recinto recinto = new Recinto("Estadio", "Madrid", 50000);
        LocalDate fecha = LocalDate.of(2025, 5, 20);
        Concierto evento = new Concierto("CONCIERTO", fecha, recinto, 50.0, TipoEvento.CONCIERTO, "Banda", 5000.0, "Canción 1");

        assertEquals(fecha, evento.getFecha());
    }

    @Test
    void testSetFecha() {
        Recinto recinto = new Recinto("Estadio", "Madrid", 50000);
        LocalDate fecha = LocalDate.of(2025, 5, 20);
        Concierto evento = new Concierto("CONCIERTO", fecha, recinto, 50.0, TipoEvento.CONCIERTO, "Banda", 5000.0, "Canción 1");

        LocalDate nuevaFecha = LocalDate.of(2025, 6, 15);
        evento.setFecha(nuevaFecha);
        assertEquals(nuevaFecha, evento.getFecha());
    }

    @Test
    void testGetPrecio() {
        Recinto recinto = new Recinto("Estadio", "Madrid", 50000);
        LocalDate fecha = LocalDate.of(2025, 5, 20);
        Concierto evento = new Concierto("CONCIERTO", fecha, recinto, 50.0, TipoEvento.CONCIERTO, "Banda", 5000.0, "Canción 1");

        assertEquals(50.0, evento.getPrecio());
    }

    @Test
    void testSetPrecio() {
        Recinto recinto = new Recinto("Estadio", "Madrid", 50000);
        LocalDate fecha = LocalDate.of(2025, 5, 20);
        Concierto evento = new Concierto("CONCIERTO", fecha, recinto, 50.0, TipoEvento.CONCIERTO, "Banda", 5000.0, "Canción 1");

        evento.setPrecio(75.0);
        assertEquals(75.0, evento.getPrecio());
    }

    @Test
    void testGetRecinto() {
        Recinto recinto = new Recinto("Estadio", "Madrid", 50000);
        LocalDate fecha = LocalDate.of(2025, 5, 20);
        Concierto evento = new Concierto("CONCIERTO", fecha, recinto, 50.0, TipoEvento.CONCIERTO, "Banda", 5000.0, "Canción 1");

        assertEquals(recinto, evento.getRecinto());
    }

    @Test
    void testSetRecinto() {
        Recinto recinto = new Recinto("Estadio", "Madrid", 50000);
        LocalDate fecha = LocalDate.of(2025, 5, 20);
        Concierto evento = new Concierto("CONCIERTO", fecha, recinto, 50.0, TipoEvento.CONCIERTO, "Banda", 5000.0, "Canción 1");

        Recinto nuevoRecinto = new Recinto("Pabellon", "Barcelona", 30000);
        evento.setRecinto(nuevoRecinto);
        assertEquals(nuevoRecinto, evento.getRecinto());
    }

    @Test
    void testGetEstado() {
        Recinto recinto = new Recinto("Estadio", "Madrid", 50000);
        LocalDate fecha = LocalDate.of(2025, 5, 20);
        Concierto evento = new Concierto("CONCIERTO", fecha, recinto, 50.0, TipoEvento.CONCIERTO, "Banda", 5000.0, "Canción 1");

        assertEquals(EstadoEvento.PLANIFICADO, evento.getEstado());
    }

    @Test
    void testSetEstado() {
        Recinto recinto = new Recinto("Estadio", "Madrid", 50000);
        LocalDate fecha = LocalDate.of(2025, 5, 20);
        Concierto evento = new Concierto("CONCIERTO", fecha, recinto, 50.0, TipoEvento.CONCIERTO, "Banda", 5000.0, "Canción 1");

        evento.setEstado(EstadoEvento.CANCELADO);
        assertEquals(EstadoEvento.CANCELADO, evento.getEstado());
    }

    @Test
    void testSetTipo() {
        Recinto recinto = new Recinto("Estadio", "Madrid", 50000);
        LocalDate fecha = LocalDate.of(2025, 5, 20);
        Concierto evento = new Concierto("CONCIERTO", fecha, recinto, 50.0, TipoEvento.CONCIERTO, "Banda", 5000.0, "Canción 1");

        evento.setTipo(TipoEvento.DEPORTE);
        assertEquals(TipoEvento.DEPORTE, evento.getTipo());
    }

    @Test
    void testGetId() {
        Recinto recinto = new Recinto("Estadio", "Madrid", 50000);
        LocalDate fecha = LocalDate.of(2025, 5, 20);
        Concierto evento = new Concierto("CONCIERTO", fecha, recinto, 50.0, TipoEvento.CONCIERTO, "Banda", 5000.0, "Canción 1");

        assertNotNull(evento.getId());
    }

    @Test
    void testCalcularPrecioVentaRecomendado() {
        Recinto recinto = new Recinto("Estadio", "Madrid", 50000);
        LocalDate fecha = LocalDate.of(2025, 5, 20);
        Concierto evento = new Concierto("CONCIERTO", fecha, recinto, 50.0, TipoEvento.CONCIERTO, "Banda", 5000.0, "Canción 1");

        // costeMontaje = 5000.0, entonces 5000.0 * 1.3 = 6500.0
        assertEquals(6500.0, evento.calcularPrecioVentaRecomendado());
    }

    @Test
    void testMostrarInformacion() {
        Recinto recinto = new Recinto("Estadio", "Madrid", 50000);
        LocalDate fecha = LocalDate.of(2025, 5, 20);
        Concierto evento = new Concierto("CONCIERTO", fecha, recinto, 50.0, TipoEvento.CONCIERTO, "Banda", 5000.0, "Canción 1");

        assertDoesNotThrow(() -> evento.mostrarInformacion());
    }
}