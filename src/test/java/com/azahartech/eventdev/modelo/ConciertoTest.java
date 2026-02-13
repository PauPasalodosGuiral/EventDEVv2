package com.azahartech.eventdev.modelo;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class ConciertoTest {

    @Test
    void testConstructor() {
        Recinto recinto = new Recinto("Palacio de Deportes", "Madrid", 15000);
        LocalDate fecha = LocalDate.of(2025, 7, 10);
        Concierto concierto = new Concierto("Rock Fest", fecha, recinto, 45.0, TipoEvento.CONCIERTO, "Rolling Stones", 8000.0, "Paint It Black");

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
        Recinto recinto = new Recinto("Palacio de Deportes", "Madrid", 15000);
        LocalDate fecha = LocalDate.of(2025, 7, 10);
        Concierto concierto = new Concierto("Rock Fest", fecha, recinto, 45.0, TipoEvento.CONCIERTO, "Rolling Stones", 8000.0, "Paint It Black");

        assertEquals("Rolling Stones", concierto.getBandaPrincipal());
    }

    @Test
    void testSetBandaPrincipal() {
        Recinto recinto = new Recinto("Palacio de Deportes", "Madrid", 15000);
        LocalDate fecha = LocalDate.of(2025, 7, 10);
        Concierto concierto = new Concierto("Rock Fest", fecha, recinto, 45.0, TipoEvento.CONCIERTO, "Rolling Stones", 8000.0, "Paint It Black");

        concierto.setBandaPrincipal("Queen");
        assertEquals("Queen", concierto.getBandaPrincipal());
    }

    @Test
    void testGetCosteMontaje() {
        Recinto recinto = new Recinto("Palacio de Deportes", "Madrid", 15000);
        LocalDate fecha = LocalDate.of(2025, 7, 10);
        Concierto concierto = new Concierto("Rock Fest", fecha, recinto, 45.0, TipoEvento.CONCIERTO, "Rolling Stones", 8000.0, "Paint It Black");

        assertEquals(8000.0, concierto.getCosteMontaje());
    }

    @Test
    void testSetCosteMontaje() {
        Recinto recinto = new Recinto("Palacio de Deportes", "Madrid", 15000);
        LocalDate fecha = LocalDate.of(2025, 7, 10);
        Concierto concierto = new Concierto("Rock Fest", fecha, recinto, 45.0, TipoEvento.CONCIERTO, "Rolling Stones", 8000.0, "Paint It Black");

        concierto.setCosteMontaje(10000.0);
        assertEquals(10000.0, concierto.getCosteMontaje());
    }

    @Test
    void testGetListaCanciones() {
        Recinto recinto = new Recinto("Palacio de Deportes", "Madrid", 15000);
        LocalDate fecha = LocalDate.of(2025, 7, 10);
        Concierto concierto = new Concierto("Rock Fest", fecha, recinto, 45.0, TipoEvento.CONCIERTO, "Rolling Stones", 8000.0, "Paint It Black");

        assertEquals("Paint It Black", concierto.getListaCanciones());
    }

    @Test
    void testSetListaCanciones() {
        Recinto recinto = new Recinto("Palacio de Deportes", "Madrid", 15000);
        LocalDate fecha = LocalDate.of(2025, 7, 10);
        Concierto concierto = new Concierto("Rock Fest", fecha, recinto, 45.0, TipoEvento.CONCIERTO, "Rolling Stones", 8000.0, "Paint It Black");

        concierto.setListaCanciones("Angie, Wild Horses");
        assertEquals("Angie, Wild Horses", concierto.getListaCanciones());
    }

    @Test
    void testCalcularCosteOperativo() {
        Recinto recinto = new Recinto("Palacio de Deportes", "Madrid", 15000);
        LocalDate fecha = LocalDate.of(2025, 7, 10);
        Concierto concierto = new Concierto("Rock Fest", fecha, recinto, 45.0, TipoEvento.CONCIERTO, "Rolling Stones", 8000.0, "Paint It Black");

        assertEquals(8000.0, concierto.calcularCosteOperativo());
    }

    @Test
    void testCalcularPrecioVentaRecomendado() {
        Recinto recinto = new Recinto("Palacio de Deportes", "Madrid", 15000);
        LocalDate fecha = LocalDate.of(2025, 7, 10);
        Concierto concierto = new Concierto("Rock Fest", fecha, recinto, 45.0, TipoEvento.CONCIERTO, "Rolling Stones", 8000.0, "Paint It Black");

        // costeMontaje = 8000.0, entonces 8000.0 * 1.3 = 10400.0
        assertEquals(10400.0, concierto.calcularPrecioVentaRecomendado());
    }

    @Test
    void testMostrarInformacion() {
        Recinto recinto = new Recinto("Palacio de Deportes", "Madrid", 15000);
        LocalDate fecha = LocalDate.of(2025, 7, 10);
        Concierto concierto = new Concierto("Rock Fest", fecha, recinto, 45.0, TipoEvento.CONCIERTO, "Rolling Stones", 8000.0, "Paint It Black");

        assertDoesNotThrow(() -> concierto.mostrarInformacion());
    }
}