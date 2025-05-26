package org.example.juegogui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartidaTest {

    private Partida partida;

    @BeforeEach
    void setUp() {
        partida = new Partida();
        // Configura aquí el estado inicial si es necesario
    }

    @Test
    void getTurno() {
        assertNotNull(partida.getTurno());
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
        assertNotNull(partida.getListaUnidades());
    }

    @Test
    void getDiccionarioUnidadesImagen() {
        assertNotNull(partida.getDiccionarioUnidadesImagen());
    }

    @Test
    void colocarUnidad() {
        assertDoesNotThrow(() -> partida.colocarUnidad());
    }

    @Test
    void generarCasillasEspeciales() {
        assertDoesNotThrow(() -> partida.generarCasillasEspeciales());
    }

    @Test
    void propiedadCasilla() {
        assertDoesNotThrow(() -> partida.propiedadCasilla());
    }

    @Test
    void buscarUnidad() {
        assertDoesNotThrow(() -> partida.buscarUnidad());
    }

    @Test
    void sePuedeMoverA() {
        assertDoesNotThrow(() -> partida.sePuedeMoverA());
    }

    @Test
    void moverUnidad() {
        assertDoesNotThrow(() -> partida.moverUnidad());
    }

    @Test
    void puedeAtacarA() {
        assertDoesNotThrow(() -> partida.puedeAtacarA());
    }

    @Test
    void testPuedeAtacarA() {
        assertDoesNotThrow(() -> partida.testPuedeAtacarA());
    }

    @Test
    void atacar() {
        assertDoesNotThrow(() -> partida.atacar());
    }

    @Test
    void generarUnidadRandom() {
        assertDoesNotThrow(() -> partida.generarUnidadRandom());
    }

    @Test
    void iniciarPartida() {
        assertDoesNotThrow(() -> partida.iniciarPartida());
    }

    @Test
    void finPartida() {
        assertDoesNotThrow(() -> partida.finPartida());
    }

    @Test
    void getDistancia() {
        assertDoesNotThrow(() -> partida.getDistancia());
    }

    @Test
    void getDiccionarioUnidadesTablero() {
        assertNotNull(partida.getDiccionarioUnidadesTablero());
    }

    @Test
    void elegirAristaIA() {
        assertDoesNotThrow(() -> partida.elegirAristaIA());
    }

    @Test
    void elegirUnidadIA() {
        assertDoesNotThrow(() -> partida.elegirUnidadIA());
    }

    @Test
    void elegirMejorCasilla() {
        assertDoesNotThrow(() -> partida.elegirMejorCasilla());
    }

    @Test
    void generarGrafoUnidades() {
        assertDoesNotThrow(() -> partida.generarGrafoUnidades());
    }

    @Test
    void IA() {
        assertDoesNotThrow(() -> partida.IA());
    }

    @Test
    void guardar() {
        assertDoesNotThrow(() -> partida.guardar());
    }

    @Test
    void cargar() {
        assertDoesNotThrow(() -> partida.cargar());
    }
}