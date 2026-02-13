package com.azahartech.eventdev.pagos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PagoTarjetaTest {

    @Test
    void testTarjetaFormatoIncorrecto() {
        // El numero de tarjeta no tiene 16 dígitos
        PagoTarjeta pago = new PagoTarjeta("123", "12/25");
        boolean resultado = pago.procesarPago(100.0);

        assertFalse(resultado, "El pago no debería procesarse con un formato inválido");
    }

    @Test
    void testTarjetaFormatoCorrecto() {
        // Formato de 16 dígitos correcto
        PagoTarjeta pago = new PagoTarjeta("1234567812345678", "10/26");
        boolean resultado = pago.procesarPago(50.0);

        }
    }


