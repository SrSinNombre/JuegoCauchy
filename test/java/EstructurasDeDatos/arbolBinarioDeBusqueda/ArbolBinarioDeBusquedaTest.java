package EstructurasDeDatos.arbolBinarioDeBusqueda;

import EstructurasDeDatos.lista.ListaBasica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        ListaBasica<Integer> nivel1 = arbol.getListaDatosNivel(1);
        ListaBasica<Integer> expectedlist = new ListaBasica<>(1);
        expectedlist.add(5);
        expectedlist.add(15);
        assertEquals(expectedlist, nivel1);
    }

    @Test
    void getCamino() {
        ListaBasica<Integer> camino = arbol.getCamino(7);
        ListaBasica<Integer> expectedlist = new ListaBasica<>(1);
        expectedlist.add(10);
        expectedlist.add(5);
        expectedlist.add(7);
        assertEquals(expectedlist, camino);
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
        assertEquals(20, arbol.getSubArbolDerecha().getSubArbolDerecha().getRaiz().getDato());
    }

    @Test
    void getSubArbolIzquierda() {
        assertEquals(5, arbol.getSubArbolIzquierda().getRaiz().getDato());
    }

    @Test
    void getSubArbolDerecha() {
        assertEquals(15, arbol.getSubArbolDerecha().getRaiz().getDato());
    }

    @Test
    void getListaPreOrden() {
        ListaBasica<Integer> esperado = new ListaBasica<>(1);
        esperado.add(10);
        esperado.add(5);
        esperado.add(3);
        esperado.add(7);
        esperado.add(15);
        assertEquals(esperado, arbol.getListaPreOrden());
    }

    @Test
    void getListaPostOrden() {
        ListaBasica<Integer> esperado = new ListaBasica<>(1);
        esperado.add(3);
        esperado.add(7);
        esperado.add(5);
        esperado.add(10);
        esperado.add(15);
        assertEquals(esperado, arbol.getListaPostOrden());
    }

    @Test
    void getListaOrdenCentral() {
        ListaBasica<Integer> esperado =new ListaBasica<>(1);
        esperado.add(3);
        esperado.add(5);
        esperado.add(7);
        esperado.add(10);
        esperado.add(15);
        assertEquals(esperado, arbol.getListaOrdenCentral());
    }
}