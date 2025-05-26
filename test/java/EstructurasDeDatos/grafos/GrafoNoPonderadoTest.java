package EstructurasDeDatos.grafos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GrafoNoPonderadoTest {

    private GrafoNoPonderado<String> grafo;

    @BeforeEach
    void setUp() {
        grafo = new GrafoNoPonderado<>();
        grafo.setPrimerVertice("A");
        grafo.addArista("A", "B");
        grafo.addArista("A", "C");
        grafo.addArista("B", "D");
    }

    @Test
    void getPrimerVertice() {
        assertEquals("A", grafo.getPrimerVertice());
    }

    @Test
    void setPrimerVertice() {
        grafo.setPrimerVertice("X");
        assertEquals("X", grafo.getPrimerVertice());
    }

    @Test
    void addArista() {
        grafo.addArista("C", "E");
        // Asumimos que recorrerEnProfundidad incluirá "E" si está conectado
        List<String> recorrido = grafo.recorrerEnProfundidad();
        assertTrue(recorrido.contains("E"));
    }

    @Test
    void deleteArista() {
        grafo.deleteArista("A", "C");
        List<String> recorrido = grafo.recorrerEnProfundidad();
        // Si eliminamos la arista, puede que "C" no esté conectada
        assertFalse(recorrido.contains("C"));
    }

    @Test
    void recorrerEnProfundidad() {
        List<String> recorrido = grafo.recorrerEnProfundidad();
        assertNotNull(recorrido);
        assertTrue(recorrido.contains("A"));
        assertTrue(recorrido.contains("B"));
        assertTrue(recorrido.contains("C"));
        assertTrue(recorrido.contains("D"));
        assertEquals(4, recorrido.size()); // A, B, C, D
    }
}