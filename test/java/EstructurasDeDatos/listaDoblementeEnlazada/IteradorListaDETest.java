package EstructurasDeDatos.listaDoblementeEnlazada;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IteradorListaDETest {

    private ListaDE<Integer> lista;
    private IteradorListaDE<Integer> iterador;

    @BeforeEach
    void setUp() {
        lista = new ListaDE<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        iterador = (IteradorListaDE<Integer>) lista.getIterador();
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
    void hasPrevious() {
        assertFalse(iterador.hasPrevious());
        iterador.next();
        assertTrue(iterador.hasPrevious());
        iterador.next();
        assertTrue(iterador.hasPrevious());
    }

    @Test
    void next() {
        assertEquals(1, iterador.next());
        assertEquals(2, iterador.next());
        assertEquals(3, iterador.next());
        assertThrows(java.util.NoSuchElementException.class, () -> iterador.next());
    }

    @Test
    void previous() {
        // Avanzar al final
        iterador.next();
        iterador.next();
        iterador.next();

        assertEquals(3, iterador.previous());
        assertEquals(2, iterador.previous());
        assertEquals(1, iterador.previous());
        assertThrows(java.util.NoSuchElementException.class, () -> iterador.previous());
    }

    @Test
    void delete() {
        // Eliminar primer elemento
        assertEquals(1, iterador.next());
        iterador.delete();
        assertEquals(2, lista.getCabeza().getDato());
        assertEquals(2, iterador.next());

        // Eliminar último elemento
        iterador.next();
        iterador.delete();
        assertEquals(1, lista.getNumElementos());
    }
}