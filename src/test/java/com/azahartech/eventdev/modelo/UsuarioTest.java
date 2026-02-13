package com.azahartech.eventdev.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void equals_DeveDevolverTrue_SiElObjetoEsLaMismaInstancia() {
        Usuario usuario = new Usuario("test", "test@email.com", "111222333", true);
        assertTrue(usuario.equals(usuario));
    }

    @Test
    void equals_DeveDevolverFalse_SiElObjetoEsNull() {
        Usuario usuario1 = new Usuario("test", "test@email.com", "111222333", true);
        Usuario usuario2 = null;
        assertFalse(usuario1.equals(usuario2));
    }

    @Test
    void equals_DeveDevolverFalse_SiLosCamposNoSonDelMismoTipo() {
        Usuario usuario = new Usuario("test", "test@email.com", "111222333", true);
        String otroObjeto = "ejemplo";

        assertFalse(usuario.equals(otroObjeto));
    }

    @Test
    void equals_DeveDevolverTrue_SiLosDosUsuariosTienenElMismoEmail() {
        Usuario usuario1 = new Usuario("test1", "test@email.com", "111222333", true);
        Usuario usuario2 = new Usuario("test2", "test@email.com", "111222333", true);
        assertTrue(usuario1.equals(usuario2));
    }

    @Test
    void equals_DeveDevolverFalse_SiLosDosUsuariosTienenDiferenteEmail() {
        Usuario usuario1 = new Usuario("test1", "test1@email.com", "111222333", true);
        Usuario usuario2 = new Usuario("test2", "test2@email.com", "111222333", true);
        assertFalse(usuario1.equals(usuario2));
    }
}