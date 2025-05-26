package Unidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CienciasTest {

    private Ciencias ciencias;

    @BeforeEach
    void setUp() {
        ciencias = new Ciencias();
    }

    @Test
    void getBiologo() {
        assertNotNull(ciencias.getBiologo(), "getBiologo no debería ser null");
    }

    @Test
    void getFisico() {
        assertNotNull(ciencias.getFisico(), "getFisico no debería ser null");
    }

    @Test
    void getIngeniero() {
        assertNotNull(ciencias.getIngeniero(), "getIngeniero no debería ser null");
    }

    @Test
    void getMatematico() {
        assertNotNull(ciencias.getMatematico(), "getMatematico no debería ser null");
    }

    @Test
    void getQuimico() {
        assertNotNull(ciencias.getQuimico(), "getQuimico no debería ser null");
    }
}