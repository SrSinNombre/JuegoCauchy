package Unidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnidadesTest {

    private Unidades unidad;

    @BeforeEach
    void setUp() {
        unidad = new Unidades("Soldado", 100, 20, 10, 5, 3);
        // Asumo un constructor: Unidades(String nombre, int hp, int ataque, int defensa, int rangoMovimiento, int rangoAtaque)
    }

    @Test
    void getNombre() {
        assertEquals("Soldado", unidad.getNombre());
    }

    @Test
    void getHP() {
        assertEquals(100, unidad.getHP());
    }

    @Test
    void setHP() {
        unidad.setHP(80);
        assertEquals(80, unidad.getHP());
    }

    @Test
    void getAtaque() {
        assertEquals(20, unidad.getAtaque());
    }

    @Test
    void getDefensa() {
        assertEquals(10, unidad.getDefensa());
    }

    @Test
    void getRango_movimiento() {
        assertEquals(5, unidad.getRango_movimiento());
    }

    @Test
    void setRango_movimiento() {
        unidad.setRango_movimiento(7);
        assertEquals(7, unidad.getRango_movimiento());
    }

    @Test
    void getRango_ataque() {
        assertEquals(3, unidad.getRango_ataque());
    }

    @Test
    void setRango_ataque() {
        unidad.setRango_ataque(4);
        assertEquals(4, unidad.getRango_ataque());
    }

    @Test
    void isDeCiencias() {
        // Supongo que esta unidad no es de ciencias (ajusta según implementación)
        assertFalse(unidad.isDeCiencias());
    }

    @Test
    void isUnidadMuerta() {
        assertFalse(unidad.isUnidadMuerta());
        unidad.setHP(0);
        assertTrue(unidad.isUnidadMuerta());
    }

    @Test
    void subirHP() {
        unidad.subirHP(10);
        assertEquals(110, unidad.getHP());
    }

    @Test
    void subirAtaque() {
        unidad.subirAtaque(5);
        assertEquals(25, unidad.getAtaque());
    }

    @Test
    void subirDefensa() {
        unidad.subirDefensa(3);
        assertEquals(13, unidad.getDefensa());
    }
}