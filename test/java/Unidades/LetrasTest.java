package Unidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LetrasTest {

    private Letras letras;

    @BeforeEach
    void setUp() {
        letras = new Letras();
    }

    @Test
    void getFilologo() {
        assertNotNull(letras.getFilologo(), "getFilologo no debería ser null");
    }

    @Test
    void getFilosofo() {
        assertNotNull(letras.getFilosofo(), "getFilosofo no debería ser null");
    }

    @Test
    void getHistoriador() {
        assertNotNull(letras.getHistoriador(), "getHistoriador no debería ser null");
    }

    @Test
    void getTeologo() {
        assertNotNull(letras.getTeologo(), "getTeologo no debería ser null");
    }

    @Test
    void getTraductor() {
        assertNotNull(letras.getTraductor(), "getTraductor no debería ser null");
    }
}