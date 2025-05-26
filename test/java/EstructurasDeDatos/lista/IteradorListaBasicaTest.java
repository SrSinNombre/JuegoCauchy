package EstructurasDeDatos.lista;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IteradorListaBasicaTest {

    private ListaBasica<Integer> lista;
    private IteradorListaBasica<Integer> iterador;

    @BeforeEach
    void setUp() {
        lista = new ListaBasica<>();
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        iterador = lista.iterador();
    }

    @Test
    void hasNext() {
        assertTrue(iterador.hasNext(), "Debe tener elemento al inicio");
        iterador.next();
        assertTrue(iterador.hasNext(), "Debe tener otro elemento");
        iterador.next();
        assertTrue(iterador.hasNext(), "Debe tener otro elemento");
        iterador.next();
        assertFalse(iterador.hasNext(), "No debe tener más elementos");
    }

    @Test
    void next() {
        assertEquals(1, iterador.next());
        assertEquals(2, iterador.next());
        assertEquals(3, iterador.next());
        assertThrows(java.util.NoSuchElementException.class, () -> iterador.next());
    }

    @Test
    void delete() {
        // Avanzar al primer elemento y borrarlo
        assertEquals(1, iterador.next());
        iterador.delete();
        assertEquals(2, lista.get(0)); // El primer elemento debe ser ahora 2

        // Avanzar al siguiente elemento y borrarlo
        assertEquals(2, iterador.next());
        iterador.delete();
        assertEquals(3, lista.get(0)); // Ahora el primero debe ser 3

        // Borrar el último elemento
        assertEquals(3, iterador.next());
        iterador.delete();
        assertTrue(lista.estaVacia(), "La lista debería quedar vacía");
    }
}