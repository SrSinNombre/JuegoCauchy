package EstructurasDeDatos.arbolBinarioDeBusqueda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArbolBinarioDeBusquedaTest {

    ArbolBinarioDeBusqueda<Integer> arbol;

    @BeforeEach
    void setUp() {
        arbol = new ArbolBinarioDeBusqueda<>();
        arbol.add(10);
        arbol.add(5);
        arbol.add(15);
        arbol.add(3);
        arbol.add(7);
    }

    @Test
    void getRaiz() {
        assertEquals(10, arbol.getRaiz().getDato());
    }

    @Test
    void getAltura() {
        assertEquals(2, arbol.getAltura());
    }

    @Test
    void getListaDatosNivel() {
        List<Integer> nivel1 = arbol.getListaDatosNivel(1);
        assertEquals(List.of(5, 15), nivel1);
    }

    @Test
    void getCamino() {
        List<Integer> camino = arbol.getCamino(7);
        assertEquals(List.of(10, 5, 7), camino);
    }

    @Test
    void isArbolHomogeneo() {
        assertFalse(arbol.isArbolHomogeneo());
    }

    @Test
    void isArbolCompleto() {
        assertTrue(arbol.isArbolCompleto());
    }

    @Test
    void isArbolCasiCompleto() {
        assertTrue(arbol.isArbolCasiCompleto());
    }

    @Test
    void add() {
        arbol.add(20);
        assertEquals(20, arbol.getSubArbolDerecha().getSubArbolDerecha().getDato());
    }

    @Test
    void getSubArbolIzquierda() {
        assertEquals(5, arbol.getSubArbolIzquierda().getDato());
    }

    @Test
    void getSubArbolDerecha() {
        assertEquals(15, arbol.getSubArbolDerecha().getDato());
    }

    @Test
    void getListaPreOrden() {
        List<Integer> esperado = List.of(10, 5, 3, 7, 15);
        assertEquals(esperado, arbol.getListaPreOrden());
    }

    @Test
    void getListaPostOrden() {
        List<Integer> esperado = List.of(3, 7, 5, 15, 10);
        assertEquals(esperado, arbol.getListaPostOrden());
    }

    @Test
    void getListaOrdenCentral() {
        List<Integer> esperado = List.of(3, 5, 7, 10, 15);
        assertEquals(esperado, arbol.getListaOrdenCentral());
    }
}