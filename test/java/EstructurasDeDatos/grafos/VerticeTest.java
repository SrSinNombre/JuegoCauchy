package EstructurasDeDatos.grafos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerticeTest {

    @Test
    void getGrado() {
        Vertice v = new Vertice(5);
        assertEquals(0, v.getGrado(), "Grado inicial debería ser 0");

        v.incrementarGrado();
        assertEquals(1, v.getGrado(), "Grado después de incrementar debería ser 1");

        v.incrementarGrado();
        assertEquals(2, v.getGrado(), "Grado después de incrementar nuevamente debería ser 2");

        v.decrementarGrado();
        assertEquals(1, v.getGrado(), "Grado después de decrementar debería ser 1");
    }

    @Test
    void getValor() {
        Vertice v = new Vertice(10);
        assertEquals(10, v.getValor(), "Valor del vértice debería ser 10");
    }
}