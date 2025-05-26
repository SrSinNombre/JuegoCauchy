package EstructurasDeDatos.grafos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GrafoPonderadoTest {

    private GrafoPonderado<String> grafo;

    @BeforeEach
    void setUp() {
        grafo = new GrafoPonderado<>();
        grafo.setPrimerVertice("A");
        grafo.addArista("A", "B", 2.5);
        grafo.addArista("A", "C", 1.0);
        grafo.addArista("B", "D", 3.0);
        grafo.addArista("C", "D", 1.0);
    }

    @Test
    void getPrimerVertice() {
        assertEquals("A", grafo.getPrimerVertice());
    }

    @Test
    void setPrimerVertice() {
        grafo.setPrimerVertice("Z");
        assertEquals("Z", grafo.getPrimerVertice());
    }

    @Test
    void getAristasTotales() {
        assertEquals(4, grafo.getAristasTotales());
    }

    @Test
    void setAristasTotales() {
        grafo.setAristasTotales(10);
        assertEquals(10, grafo.getAristasTotales());
    }

    @Test
    void addArista() {
        grafo.addArista("D", "E", 4.0);
        assertEquals(5, grafo.getAristasTotales());
    }

    @Test
    void deleteArista() {
        grafo.deleteArista("A", "B");
        assertEquals(3, grafo.getAristasTotales());
    }

    @Test
    void recorrerEnProfundidad() {
        List<String> recorrido = grafo.recorrerEnProfundidad();
        assertNotNull(recorrido);
        assertTrue(recorrido.contains("A"));
        assertTrue(recorrido.contains("B"));
        assertTrue(recorrido.contains("C"));
        assertTrue(recorrido.contains("D"));
    }

    @Test
    void getAristasMenorPeso() {
        List<Arista<String>> aristas = grafo.getAristasMenorPeso();
        assertNotNull(aristas);
        assertFalse(aristas.isEmpty());
        for (Arista<String> a : aristas) {
            assertEquals(1.0, a.getPeso());
        }
    }
}