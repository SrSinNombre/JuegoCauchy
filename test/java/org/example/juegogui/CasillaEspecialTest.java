package org.example.juegogui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CasillaEspecialTest {

    private CasillaEspecial casilla;

    @BeforeEach
    void setUp() {
        // Suponiendo constructor con coordenadas y propiedad
        casilla = new CasillaEspecial(3, 5, "Barrera");
    }

    @Test
    void getCoordenadas() {
        // Dependiendo de cómo devuelva las coordenadas:
        int[] coords = casilla.getCoordenadas();
        assertEquals(3, coords[0]);
        assertEquals(5, coords[1]);
    }

    @Test
    void getPropiedad() {
        assertEquals("Barrera", casilla.getPropiedad());
    }
}