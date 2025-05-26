package org.example.juegogui;

import Unidades.Unidades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartidaTest {

    private Partida partida;

    @BeforeEach
    void setUp() {
        partida = new Partida(8, 8, true);
        // Configura aquí el estado inicial si es necesario
    }

    @Test
    void getTurno() {
    }

    @Test
    void setTurno() {
        partida.setTurno(2);
        assertEquals(2, partida.getTurno());
    }

    @Test
    void isTableroCuadrado() {
        assertDoesNotThrow(() -> partida.isTableroCuadrado());
    }

    @Test
    void getListaUnidades() {
        assertNotNull(partida.getListaUnidades(true));
    }

    @Test
    void getDiccionarioUnidadesImagen() {
        assertNotNull(partida.getDiccionarioUnidadesImagen());
    }

    @Test
    void generarCasillasEspeciales() {
        assertDoesNotThrow(() -> partida.generarCasillasEspeciales(8));
    }

    @Test
    void propiedadCasilla() {
        assertDoesNotThrow(() -> partida.propiedadCasilla(new int[]{4, 0}));
    }

}