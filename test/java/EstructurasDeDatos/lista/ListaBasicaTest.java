package EstructurasDeDatos.lista;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaBasicaTest {

    private ListaBasica<Integer> lista;

    @BeforeEach
    void setUp() {
        lista = new ListaBasica<>();
    }

    @Test
    void add() {
        lista.add(10);
        lista.add(20);
        assertEquals(2, lista.getNumElementos());
        assertEquals(10, lista.get(0));
        assertEquals(20, lista.get(1));
    }

    @Test
    void delete() {
        lista.add(10);
        lista.add(20);
        lista.delete(0); // Asumiendo que elimina por índice
        assertEquals(1, lista.getNumElementos());
        assertEquals(20, lista.get(0));
    }

    @Test
    void estaVacia() {
        assertTrue(lista.estaVacia());
        lista.add(5);
        assertFalse(lista.estaVacia());
    }

    @Test
    void reverse() {
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.reverse();
        assertEquals(3, lista.get(0));
        assertEquals(2, lista.get(1));
        assertEquals(1, lista.get(2));
    }

    @Test
    void contains() {
        lista.add(5);
        lista.add(10);
        assertTrue(lista.contains(5));
        assertFalse(lista.contains(15));
    }

    @Test
    void get() {
        lista.add(7);
        assertEquals(7, lista.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> lista.get(1));
    }

    @Test
    void setElemento() {
        lista.add(10);
        lista.setElemento(0, 20);
        assertEquals(20, lista.get(0));
    }
}