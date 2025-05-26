package EstructurasDeDatos.grafos;

import EstructurasDeDatos.Lista;
import EstructurasDeDatos.lista.ListaBasica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrafoPonderadoTest {

    private GrafoPonderado<String> grafo;

    @BeforeEach
    void setUp() {
        Vertice<String> primerVertice = new Vertice<>("A");
        grafo = new GrafoPonderado<>(primerVertice);

        grafo.addArista(new Vertice<>("A"), new Vertice<>("B"), 2);
        grafo.addArista(new Vertice<>("A"), new Vertice<>("C"), 1);
        grafo.addArista(new Vertice<>("B"), new Vertice<>("D"), 3);
        grafo.addArista(new Vertice<>("C"), new Vertice<>("D"), 1);
    }

    @Test
    void getPrimerVertice() {
        assertEquals("A", grafo.getPrimerVertice().getValor());
    }

    @Test
    void setPrimerVertice() {
        grafo.setPrimerVertice(new Vertice<>("Z"));
        assertEquals("Z", grafo.getPrimerVertice().getValor());
    }

    @Test
    void getAristasTotales() {
        assertEquals(4, grafo.getAristasTotales().getNumElementos());
    }

    @Test
    void addArista() {
        grafo.addArista(new Vertice<>("D"), new Vertice<>("E"), 4);
        assertEquals(5, grafo.getAristasTotales().getNumElementos());
    }

    @Test
    void deleteArista() {
        Arista<String> arista = new Arista<>(new Vertice<>("A"), new Vertice<>("B"), 2);
        grafo.deleteArista(arista);
        assertEquals(3, grafo.getAristasTotales().getNumElementos());
    }

    @Test
    void recorrerEnProfundidad() {
        Lista<Vertice<String>> recorrido = grafo.recorrerEnProfundidad();
        assertNotNull(recorrido);
        assertTrue(recorrido.contains(new Vertice<>("A")));
        assertTrue(recorrido.contains(new Vertice<>("B")));
        assertTrue(recorrido.contains(new Vertice<>("C")));
        assertTrue(recorrido.contains(new Vertice<>("D")));
    }

    @Test
    void getAristasMenorPeso() {
        ListaBasica<Arista<String>> aristas = grafo.getAristasMenorPeso();
        assertNotNull(aristas);
        assertNotEquals(0, aristas.getNumElementos());
        for (int i = 0; i < aristas.getNumElementos(); i++) {
            assertEquals(1.0, aristas.get(i).getPeso());
        }
    }
}