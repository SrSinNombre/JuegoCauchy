package EstructurasDeDatos.grafos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AristaTest {

    @Test
    void getPeso() {
        Arista<String> arista = new Arista<>("A", "B", 3.5);
        assertEquals(3.5, arista.getPeso());
    }

    @Test
    void setPeso() {
        Arista<String> arista = new Arista<>("A", "B", 1.0);
        arista.setPeso(2.5);
        assertEquals(2.5, arista.getPeso());
    }

    @Test
    void getDestino() {
        Arista<String> arista = new Arista<>("X", "Y", 1.0);
        assertEquals("Y", arista.getDestino());
    }

    @Test
    void setDestino() {
        Arista<String> arista = new Arista<>("X", "Y", 1.0);
        arista.setDestino("Z");
        assertEquals("Z", arista.getDestino());
    }

    @Test
    void getOrigen() {
        Arista<String> arista = new Arista<>("Inicio", "Fin", 5.0);
        assertEquals("Inicio", arista.getOrigen());
    }

    @Test
    void setOrigen() {
        Arista<String> arista = new Arista<>("Inicio", "Fin", 5.0);
        arista.setOrigen("NuevoInicio");
        assertEquals("NuevoInicio", arista.getOrigen());
    }
}