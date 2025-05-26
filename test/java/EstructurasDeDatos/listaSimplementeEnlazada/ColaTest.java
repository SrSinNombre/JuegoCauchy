package EstructurasDeDatos.listaSimplementeEnlazada;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColaTest {

    private Cola<Integer> cola;

    @BeforeEach
    void setUp() {
        cola = new Cola<>();
    }

    @Test
    void enqueue() {
        assertTrue(cola.isEmpty());
        cola.enqueue(10);
        assertFalse(cola.isEmpty());
        cola.enqueue(20);
        // Aquí podrías comprobar tamaño si tienes método o comportamiento esperado
    }

    @Test
    void dequeue() {
        cola.enqueue(5);
        cola.enqueue(15);
        assertEquals(5, cola.dequeue());
        assertEquals(15, cola.dequeue());
        assertTrue(cola.isEmpty());
        // Comprobar que al hacer dequeue en cola vacía lanza excepción (por ejemplo NoSuchElementException)
        assertThrows(java.util.NoSuchElementException.class, () -> cola.dequeue());
    }

    @Test
    void isEmpty() {
        assertTrue(cola.isEmpty());
        cola.enqueue(1);
        assertFalse(cola.isEmpty());
        cola.dequeue();
        assertTrue(cola.isEmpty());
    }
}