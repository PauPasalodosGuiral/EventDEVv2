package com.azahartech.eventdev.modelo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
class PartidoTest {

    @Test
    void calcularCosteOperativoDebeDar4000SiSeIntroduceUnValorDe2000() {
        Recinto recinto = new Recinto("Palacio", "Calle mayor", 500);
        Partido partido1 = new Partido("partido1", LocalDate.now(), recinto, 20, "equipo1", "equipo2", 2000);
        double total = partido1.calcularCosteOperativo();

        assertEquals(40000, total, "El Calculo es incorrecto");

    }
}