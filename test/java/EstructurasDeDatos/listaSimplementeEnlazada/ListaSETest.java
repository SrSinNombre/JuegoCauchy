package EstructurasDeDatos.listaSimplementeEnlazada;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaSETest {

    private ListaSE<Integer> lista;

    @BeforeEach
    void setUp() {
        lista = new ListaSE<>();
    }

    @Test
    void getCabeza() {
        assertNull(lista.getCabeza());
        lista.add(5);
        assertNotNull(lista.getCabeza());
        assertEquals(5, lista.getCabeza().getDato());
    }

    @Test
    void add() {
        lista.add(1);
        lista.add(2);
        lista.add(3);
        assertEquals(3, lista.getNumElementos());
        assertEquals(1, lista.getCabeza().getDato());
    }

    @Test
    void delete() {
        lista.add(10);
        lista.add(20);
        lista.add(30);
        lista.delete(1); // suponiendo elimina por índice
        assertEquals(2, lista.getNumElementos());
        assertFalse(lista.contains(20));
    }

    @Test
    void getNumElementos() {
        assertEquals(0, lista.getNumElementos());
        lista.add(1);
        lista.add(2);
        assertEquals(2, lista.getNumElementos());
    }

    @Test
    void getIterador() {
        lista.add(1);
        lista.add(2);
        assertNotNull(lista.getIterador());
    }

    @Test
    void imprimir() {
        lista.add(1);
        lista.add(2);
        lista.add(3);
        assertDoesNotThrow(() -> lista.imprimir());
    }

    @Test
    void estaVacia() {
        assertTrue(lista.estaVacia());
        lista.add(1);
        assertFalse(lista.estaVacia());
    }

    @Test
    void contains() {
        lista.add(5);
        lista.add(10);
        assertTrue(lista.contains(5));
        assertFalse(lista.contains(20));
    }
}