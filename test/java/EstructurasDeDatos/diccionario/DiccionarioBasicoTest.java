package EstructurasDeDatos.diccionario;

import EstructurasDeDatos.Iterador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiccionarioBasicoTest {

    private DiccionarioBasico<String, Integer> diccionario;

    @BeforeEach
    void setUp() {
        diccionario = new DiccionarioBasico<>();
        diccionario.agregar("uno", 1);
        diccionario.agregar("dos", 2);
        diccionario.agregar("tres", 3);
    }

    @Test
    void getCabeza() {
        assertNotNull(diccionario.getCabeza());  // Asumiendo que devuelve el primer nodo o entrada
    }

    @Test
    void agregar() {
        diccionario.agregar("cuatro", 4);
        assertEquals(4, diccionario.get("cuatro"));
    }

    @Test
    void get() {
        assertEquals(1, diccionario.get("uno"));
        assertEquals(2, diccionario.get("dos"));
        assertNull(diccionario.get("no-existe"));
    }

    @Test
    void delete() {
        diccionario.delete("dos");
        assertFalse(diccionario.hasKey("dos"));
        assertNull(diccionario.get("dos"));
    }

    @Test
    void hasKey() {
        assertTrue(diccionario.hasKey("uno"));
        assertFalse(diccionario.hasKey("cinco"));
    }

    @Test
    void getIterador() {
        Iterador<Diccionario<String, Integer>> iter = diccionario.getIterador();
        assertNotNull(iter);
        int contador = 0;
        while (iter.hasNext()) {
            String clave = iter.next().getClave();
            assertTrue(diccionario.hasKey(clave));
            contador++;
        }
        assertEquals(diccionario.getNumElementos(), contador);
    }

    @Test
    void getClaveIndice() {
        String clave = diccionario.getClaveIndice(1); // Asumimos que el índice 1 es válido
        assertNotNull(clave);
        assertTrue(diccionario.hasKey(clave));
    }

    @Test
    void getNumElementos() {
        assertEquals(3, diccionario.getNumElementos());
        diccionario.agregar("cuatro", 4);
        assertEquals(4, diccionario.getNumElementos());
    }

    @Test
    void buscar() {
        String valor = diccionario.buscar(3);
        assertEquals("tres", valor);
    }
}