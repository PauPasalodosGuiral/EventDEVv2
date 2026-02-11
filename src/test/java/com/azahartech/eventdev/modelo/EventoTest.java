package com.azahartech.eventdev.modelo;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class EventoTest {

    private Concierto evento;
    private Recinto recinto;
    private LocalDate fecha;


    @Test
    void testConstructor() {
        assertEquals("Concierto", evento.getNombre());
        assertEquals(fecha, evento.getFecha());
        assertEquals(recinto, evento.getRecinto());
        assertEquals(50.0, evento.getPrecio());
        assertEquals(EstadoEvento.PLANIFICADO, evento.getEstado());
        assertNotNull(evento.getId());
    }

    @Test
    void testGetNombre() {
        assertEquals("Concierto", evento.getNombre());
    }

    @Test
    void testSetNombre() {
        evento.setNombre("Nuevo Concierto");
        assertEquals("Nuevo Concierto", evento.getNombre());
    }

    @Test
    void testGetFecha() {
        assertEquals(fecha, evento.getFecha());
    }

    @Test
    void testSetFecha() {
        LocalDate nuevaFecha = LocalDate.of(2025, 6, 15);
        evento.setFecha(nuevaFecha);
        assertEquals(nuevaFecha, evento.getFecha());
    }

    @Test
    void testGetPrecio() {
        assertEquals(50.0, evento.getPrecio());
    }

    @Test
    void testSetPrecio() {
        evento.setPrecio(75.0);
        assertEquals(75.0, evento.getPrecio());
    }

    @Test
    void testGetRecinto() {
        assertEquals(recinto, evento.getRecinto());
    }

    @Test
    void testSetRecinto() {
        Recinto nuevoRecinto = new Recinto("Pabellon", "Barcelona", 30000);
        evento.setRecinto(nuevoRecinto);
        assertEquals(nuevoRecinto, evento.getRecinto());
    }

    @Test
    void testGetEstado() {
        assertEquals(EstadoEvento.PLANIFICADO, evento.getEstado());
    }

    @Test
    void testSetEstado() {
        evento.setEstado(EstadoEvento.CANCELADO);
        assertEquals(EstadoEvento.CANCELADO, evento.getEstado());
    }


    @Test
    void testSetTipo() {
        evento.setTipo(TipoEvento.DEPORTE);
        assertEquals(TipoEvento.DEPORTE, evento.getTipo());
    }

    @Test
    void testGetId() {
        assertNotNull(evento.getId());
    }

    @Test
    void testCalcularPrecioVentaRecomendado() {
        assertEquals(6500.0, evento.calcularPrecioVentaRecomendado());
    }

    @Test
    void testMostrarInformacion() {
        assertDoesNotThrow(() -> evento.mostrarInformacion());
    }
}