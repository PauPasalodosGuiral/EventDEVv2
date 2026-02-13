package com.azahartech.eventdev.pagos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PagoBizumTest {

    @Test
    void testTelefonoFormatoIncorrecto() {
        // El teléfono debe tener exactamente 9 dígitos
        PagoBizum pago = new PagoBizum("12345", 1234);
        boolean resultado = pago.procesarPago(5.0);

        assertFalse(resultado, "El pago debería fallar si el teléfono no tiene 9 dígitos");
    }

    @Test
    void testTelefonoConLetras() {
        // El teléfono SOLO debe contener números
        PagoBizum pago = new PagoBizum("600A00B00", 1234);
        boolean resultado = pago.procesarPago(2.0);

        assertFalse(resultado, "El pago debería fallar si el teléfono contiene caracteres no numéricos");
    }

    @Test
    void testPagoExitosoFormatoCorrecto() {
        // Formato correcto de 9 dígitos
        PagoBizum pago = new PagoBizum("600123456", 1111);

        boolean resultado = pago.procesarPago(1.0);

    }
}