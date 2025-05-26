package EstructurasDeDatos.listaDoblementeEnlazada;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoDobleTest {

    @Test
    void getDato() {
        ElementoDoble<Integer> elem = new ElementoDoble<>(10);
        assertEquals(10, elem.getDato());
    }

    @Test
    void setDato() {
        ElementoDoble<String> elem = new ElementoDoble<>("hola");
        elem.setDato("mundo");
        assertEquals("mundo", elem.getDato());
    }

    @Test
    void getSiguiente() {
        ElementoDoble<Integer> elem1 = new ElementoDoble<>(1);
        ElementoDoble<Integer> elem2 = new ElementoDoble<>(2);
        elem1.setSiguiente(elem2);
        assertEquals(elem2, elem1.getSiguiente());
    }

    @Test
    void setSiguiente() {
        ElementoDoble<Integer> elem1 = new ElementoDoble<>(1);
        ElementoDoble<Integer> elem2 = new ElementoDoble<>(2);
        elem1.setSiguiente(elem2);
        assertEquals(elem2, elem1.getSiguiente());
    }

    @Test
    void getAnterior() {
        ElementoDoble<Integer> elem1 = new ElementoDoble<>(1);
        ElementoDoble<Integer> elem2 = new ElementoDoble<>(2);
        elem2.setAnterior(elem1);
        assertEquals(elem1, elem2.getAnterior());
    }

    @Test
    void setAnterior() {
        ElementoDoble<Integer> elem1 = new ElementoDoble<>(1);
        ElementoDoble<Integer> elem2 = new ElementoDoble<>(2);
        elem2.setAnterior(elem1);
        assertEquals(elem1, elem2.getAnterior());
    }
}