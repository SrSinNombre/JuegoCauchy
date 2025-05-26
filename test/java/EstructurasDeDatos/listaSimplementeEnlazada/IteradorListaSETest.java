package EstructurasDeDatos.listaSimplementeEnlazada;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IteradorListaSETest {

    private ListaSE<Integer> lista;
    private IteradorListaSE<Integer> iterador;

    @BeforeEach
    void setUp() {
        lista = new ListaSE<>();
        lista.add(10);
        lista.add(20);
        lista.add(30);
        iterador = lista.getIterador();
    }

    @Test
    void hasNext() {
        assertTrue(iterador.hasNext());
        iterador.next();
        assertTrue(iterador.hasNext());
        iterador.next();
        assertTrue(iterador.hasNext());
        iterador.next();
        assertFalse(iterador.hasNext());
    }

    @Test
    void next() {
        assertEquals(10, iterador.next());
        assertEquals(20, iterador.next());
        assertEquals(30, iterador.next());
        assertThrows(java.util.NoSuchElementException.class, () -> iterador.next());
    }

    @Test
    void delete() {
        assertEquals(10, iterador.next());
        iterador.delete();
        assertEquals(2, lista.getNumElementos());
        assertEquals(20, lista.get(0));

        assertEquals(20, iterador.next());
        iterador.delete();
        assertEquals(1, lista.getNumElementos());
        assertEquals(30, lista.get(0));
    }
}