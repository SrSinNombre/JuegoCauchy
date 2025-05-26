package EstructurasDeDatos.grafos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerticeTest {

    @Test
    void getGrado() {
        Vertice<Integer> v = new Vertice<>(5);
        assertEquals(0, v.getGrado(), "Grado inicial debería ser 0");
    }

    @Test
    void getValor() {
        Vertice<Integer> v = new Vertice<>(10);
        assertEquals(10, v.getValor(), "Valor del vértice debería ser 10");
    }
}