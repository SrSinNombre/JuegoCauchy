package EstructurasDeDatos.listaSimplementeEnlazada;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilaTest {

    private Pila<Integer> pila;

    @BeforeEach
    void setUp() {
        pila = new Pila<>();
    }

    @Test
    void push() {
        pila.push(10);
        pila.push(20);
        // Asumiendo que tienes un método para consultar tamaño o tope, si no, solo que no falle
        assertFalse(pila.estaVacia());
    }

    @Test
    void pop() {
        pila.push(5);
        pila.push(15);
        assertEquals(15, pila.pop());
        assertEquals(5, pila.pop());
        assertThrows(java.util.NoSuchElementException.class, () -> pila.pop());
    }
}