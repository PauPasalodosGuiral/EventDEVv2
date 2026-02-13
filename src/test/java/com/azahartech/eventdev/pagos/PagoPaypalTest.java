package com.azahartech.eventdev.pagos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PagoPaypalTest {

    @Test
    void testProcesarPagoExitoso() {
        // Camino correcto de pago
        PagoPaypal pago = new PagoPaypal("test@usuario.com");
        boolean resultado = pago.procesarPago(1.0);

        assertTrue(resultado, "El pago por PayPal debería devolver siempre true con correo correcto");
    }

    @Test
    void testPagoConCantidadCero() {
        // Pago con cantidad 0
        PagoPaypal pago = new PagoPaypal("admin@tienda.com");
        boolean resultado = pago.procesarPago(0.0);

        assertTrue(resultado);
    }
}