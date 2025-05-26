package EstructurasDeDatos.diccionario;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiccionarioTest {

    @Test
    void getClave() {
        Diccionario<String, Integer> entrada = new Diccionario<>("id", 42);
        assertEquals("id", entrada.getClave());
    }

    @Test
    void getValor() {
        Diccionario<String, String> entrada = new Diccionario<>("nombre", "Juan");
        assertEquals("Juan", entrada.getValor());
    }

    @Test
    void setValor() {
        Diccionario<String, Double> entrada = new Diccionario<>("precio", 10.5);
        entrada.setValor(12.99);
        assertEquals(12.99, entrada.getValor());
    }

    @Test
    void testEquals() {
        Diccionario<String, Integer> a = new Diccionario<>("clave", 100);
        Diccionario<String, Integer> b = new Diccionario<>("clave", 200);
        Diccionario<String, Integer> c = new Diccionario<>("otra", 100);

        assertEquals(a, b);     // misma clave → iguales
        assertNotEquals(a, c);  // distinta clave → distintos
    }

    @Test
    void testHashCode() {
        Diccionario<String, String> a = new Diccionario<>("clave", "A");
        Diccionario<String, String> b = new Diccionario<>("clave", "B");

        assertEquals(a.hashCode(), b.hashCode()); // misma clave → mismo hash
    }
}