package EstructurasDeDatos.listaDoblementeEnlazada;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaDETest {

    private ListaDE<Integer> lista;

    @BeforeEach
    void setUp() {
        lista = new ListaDE<>();
    }

    @Test
    void getCabeza() {
        assertNull(lista.getCabeza());
        lista.add(10);
        assertNotNull(lista.getCabeza());
        assertEquals(10, lista.getCabeza().getDato());
    }

    @Test
    void getCola() {
        assertNull(lista.getCola());
        lista.add(20);
        assertNotNull(lista.getCola());
        assertEquals(20, lista.getCola().getDato());
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
    void add() {
        lista.add(5);
        lista.add(15);
        assertEquals(2, lista.getNumElementos());
        assertEquals(5, lista.getCabeza().getDato());
        assertEquals(15, lista.getCola().getDato());
    }

    @Test
    void estaVacia() {
        assertTrue(lista.estaVacia());
        lista.add(7);
        assertFalse(lista.estaVacia());
    }

    @Test
    void deleteCabeza() {
        lista.add(1);
        lista.add(2);
        lista.deleteCabeza();
        assertEquals(1, lista.getNumElementos());
        assertEquals(2, lista.getCabeza().getDato());
    }

    @Test
    void deleteCola() {
        lista.add(3);
        lista.add(4);
        lista.deleteCola();
        assertEquals(1, lista.getNumElementos());
        assertEquals(3, lista.getCola().getDato());
    }

    @Test
    void delete() {
        lista.add(10);
        lista.add(20);
        lista.add(30);
        lista.delete(1); // suponiendo elimina por índice
        assertEquals(2, lista.getNumElementos());
        assertEquals(30, lista.getCabeza().getSiguiente().getDato());
    }

    @Test
    void imprimir() {
        lista.add(1);
        lista.add(2);
        lista.add(3);
        // Solo comprobar que no lance excepción
        assertDoesNotThrow(() -> lista.imprimir());
    }

    @Test
    void reverse() {
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.reverse();
        assertEquals(3, lista.getCabeza().getDato());
        assertEquals(1, lista.getCola().getDato());
    }

    @Test
    void contains() {
        lista.add(10);
        lista.add(20);
        assertTrue(lista.contains(10));
        assertFalse(lista.contains(30));
    }
}