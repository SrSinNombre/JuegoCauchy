package EstructurasDeDatos.listaSimplementeEnlazada;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoTest {

    @Test
    void getDato() {
        Elemento<Integer> elem = new Elemento<>(42);
        assertEquals(42, elem.getDato());
    }

    @Test
    void setDato() {
        Elemento<String> elem = new Elemento<>("hola");
        elem.setDato("mundo");
        assertEquals("mundo", elem.getDato());
    }

    @Test
    void getSiguiente() {
        Elemento<Integer> elem1 = new Elemento<>(1);
        Elemento<Integer> elem2 = new Elemento<>(2);
        elem1.setSiguiente(elem2);
        assertEquals(elem2, elem1.getSiguiente());
    }

    @Test
    void setSiguiente() {
        Elemento<Integer> elem1 = new Elemento<>(1);
        Elemento<Integer> elem2 = new Elemento<>(2);
        elem1.setSiguiente(elem2);
        assertEquals(elem2, elem1.getSiguiente());
    }
}