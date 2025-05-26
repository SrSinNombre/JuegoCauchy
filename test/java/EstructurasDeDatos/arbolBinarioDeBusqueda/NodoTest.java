package EstructurasDeDatos.arbolBinarioDeBusqueda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodoTest {

    @Test
    void getDato() {
        Nodo<Integer> nodo = new Nodo<>(42);
        assertEquals(42, nodo.getDato());
    }

    @Test
    void setDato() {
        Nodo<String> nodo = new Nodo<>("Hola");
        nodo.setDato("Mundo");
        assertEquals("Mundo", nodo.getDato());
    }

    @Test
    void obtenerGrado() {
        Nodo<Integer> nodo = new Nodo<>(10);
        assertEquals(0, nodo.obtenerGrado());

        nodo.setIzquierdo(new Nodo<>(5));
        assertEquals(1, nodo.obtenerGrado());

        nodo.setDerecho(new Nodo<>(15));
        assertEquals(2, nodo.obtenerGrado());
    }

    @Test
    void esHoja() {
        Nodo<Integer> nodo = new Nodo<>(8);
        assertTrue(nodo.esHoja());

        nodo.setIzquierdo(new Nodo<>(4));
        assertFalse(nodo.esHoja());

        nodo.setDerecho(new Nodo<>(12));
        assertFalse(nodo.esHoja());
    }
}