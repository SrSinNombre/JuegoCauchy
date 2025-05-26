package EstructurasDeDatos.grafos;

import EstructurasDeDatos.Lista;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class GrafoNoPonderadoTest {

    private GrafoNoPonderado<String> grafo;

    @BeforeEach
    void setUp() {
        Vertice<String> primerVertice = new Vertice<>("A");
        grafo = new GrafoNoPonderado<>(primerVertice);

        Vertice<String> segundoVertice = new Vertice<>("B");
        grafo.addArista(primerVertice, segundoVertice);
        grafo.addArista(primerVertice, new Vertice<>("C"));
        grafo.addArista(segundoVertice, new Vertice<>("D"));
    }

    @Test
    void getPrimerVertice() {
        assertEquals("A", grafo.getPrimerVertice().getValor());
    }

    @Test
    void setPrimerVertice() {
        grafo.setPrimerVertice(new Vertice<>("X"));
        assertEquals("X", grafo.getPrimerVertice().getValor());
    }

    @Test
    void addArista() {
        grafo.addArista(new Vertice<>("C"), new Vertice<>("E"));
        // Asumimos que recorrerEnProfundidad incluirá "E" si está conectado
        Lista<Vertice<String>> recorrido = grafo.recorrerEnProfundidad();
        assertTrue(recorrido.contains(new Vertice<>("E")));
    }

    @Test
    void deleteArista() {
        grafo.deleteArista(new Vertice<>("A"), new Vertice<>("C"));
        Lista<Vertice<String>> recorrido = grafo.recorrerEnProfundidad();
        // Si eliminamos la arista, puede que "C" no esté conectada
        assertFalse(recorrido.contains(new Vertice<>("C")));
    }

    @Test
    void recorrerEnProfundidad() {
        Lista<Vertice<String>> recorrido = grafo.recorrerEnProfundidad();
        assertNotNull(recorrido);
        assertTrue(recorrido.contains(new Vertice<>("A")));
        assertTrue(recorrido.contains(new Vertice<>("B")));
        assertTrue(recorrido.contains(new Vertice<>("C")));
        assertTrue(recorrido.contains(new Vertice<>("D")));
        assertEquals(4, recorrido.getNumElementos()); // A, B, C, D
    }
}