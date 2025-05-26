package EstructurasDeDatos.grafos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AristaTest {

    @Test
    void getPeso() {
        Arista<String> arista = new Arista<>(new Vertice<>("A"), new Vertice<>("B"), 3);
        assertEquals(3, arista.getPeso());
    }

    @Test
    void setPeso() {
        Arista<String> arista = new Arista<>(new Vertice<>("A"), new Vertice<>("B"), 1);
        arista.setPeso(2);
        assertEquals(2, arista.getPeso());
    }

    @Test
    void getDestino() {
        Arista<String> arista = new Arista<>(new Vertice<>("X"), new Vertice<>("Y"), 1);
        assertEquals("Y", arista.getDestino().getValor());
    }

    @Test
    void setDestino() {
        Arista<String> arista = new Arista<>(new Vertice<>("X"), new Vertice<>("Y"), 1);
        arista.setDestino(new Vertice<>("Z"));
        assertEquals("Z", arista.getDestino().getValor());
    }

    @Test
    void getOrigen() {
        Arista<String> arista = new Arista<>(new Vertice<>("Inicio"), new Vertice<>("Fin"), 5);
        assertEquals("Inicio", arista.getOrigen().getValor());
    }

    @Test
    void setOrigen() {
        Arista<String> arista = new Arista<>(new Vertice<>("Inicio"), new Vertice<>("Fin"), 5);
        arista.setOrigen(new Vertice<>("NuevoInicio"));
        assertEquals("NuevoInicio", arista.getOrigen().getValor());
    }
}