package com.azahartech.eventdev.modelo;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class ConciertoTest {
    @Test
    void DebeDeVolver8000AlCalcularElCosteOperrativoDelEvento() {
        Recinto recinto = new Recinto("Palacio de Deportes", "Madrid", 15000);
        LocalDate fecha = LocalDate.of(2025, 7, 10);
        Concierto concierto = new Concierto("Rock Fest", fecha, recinto, 45.0, TipoEvento.CONCIERTO, "Rolling Stones", 8000.0, "Paint It Black");

        assertEquals(8000.0, concierto.calcularCosteOperativo());
    }

    @Test
    void DebeDeVolver10400DelCalculoDelPrecioDeVentRecomendado() {
        Recinto recinto = new Recinto("Palacio de Deportes", "Madrid", 15000);
        LocalDate fecha = LocalDate.of(2025, 7, 10);
        Concierto concierto = new Concierto("Rock Fest", fecha, recinto, 45.0, TipoEvento.CONCIERTO, "Rolling Stones", 8000.0, "Paint It Black");

        // costeMontaje = 8000.0, entonces 8000.0 * 1.3 = 10400.0
        assertEquals(10400.0, concierto.calcularPrecioVentaRecomendado());
    }

}