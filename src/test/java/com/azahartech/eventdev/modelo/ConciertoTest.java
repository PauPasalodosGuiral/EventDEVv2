package com.azahartech.eventdev.modelo;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class ConciertoTest {

    private Concierto concierto;
    private Recinto recinto;
    private LocalDate fecha;

    @Test
    void testConstructor() {
        assertEquals("Rock Fest", concierto.getNombre());
        assertEquals(fecha, concierto.getFecha());
        assertEquals(recinto, concierto.getRecinto());
        assertEquals(45.0, concierto.getPrecio());
        assertEquals(EstadoEvento.PLANIFICADO, concierto.getEstado());
        assertEquals("Rolling Stones", concierto.getBandaPrincipal());
        assertEquals(8000.0, concierto.getCosteMontaje());
        assertEquals("Paint It Black", concierto.getListaCanciones());
    }

    @Test
    void testGetBandaPrincipal() {
        assertEquals("Rolling Stones", concierto.getBandaPrincipal());
    }

    @Test
    void testSetBandaPrincipal() {
        concierto.setBandaPrincipal("Queen");
        assertEquals("Queen", concierto.getBandaPrincipal());
    }

    @Test
    void testGetCosteMontaje() {
        assertEquals(8000.0, concierto.getCosteMontaje());
    }

    @Test
    void testSetCosteMontaje() {
        concierto.setCosteMontaje(10000.0);
        assertEquals(10000.0, concierto.getCosteMontaje());
    }

    @Test
    void testGetListaCanciones() {
        assertEquals("Paint It Black", concierto.getListaCanciones());
    }

    @Test
    void testSetListaCanciones() {
        concierto.setListaCanciones("Angie, Wild Horses");
        assertEquals("Angie, Wild Horses", concierto.getListaCanciones());
    }

    @Test
    void testCalcularCosteOperativo() {
        assertEquals(8000.0, concierto.calcularCosteOperativo());
    }

    @Test
    void testCalcularPrecioVentaRecomendado() {
        assertEquals(10400.0, concierto.calcularPrecioVentaRecomendado());
    }


    @Test
    void testMostrarInformacion() {
        assertDoesNotThrow(() -> concierto.mostrarInformacion());
    }
}