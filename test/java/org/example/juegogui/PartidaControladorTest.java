package org.example.juegogui;

import javafx.event.ActionEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartidaControladorTest {

    private PartidaControlador controlador;

    @BeforeEach
    void setUp() {
        controlador = new PartidaControlador();
        // Aquí puedes inicializar el controlador con mocks o setup necesario
    }

    @Test
    void onBotonNuevaPartidaClick() {
        assertDoesNotThrow(() -> controlador.onBotonNuevaPartidaClick());
    }

    @Test
    void onBotonSalirDelJuegoClick() {
        assertDoesNotThrow(() -> controlador.onBotonSalirDelJuegoClick());
    }

    @Test
    void onCienciasClick() {
        assertDoesNotThrow(() -> controlador.onCienciasClick());
    }

    @Test
    void onLetrasClick() {
        assertDoesNotThrow(() -> controlador.onLetrasClick());
    }

    @Test
    void onSalirClick() {
        assertDoesNotThrow(() -> controlador.onSalirClick());
    }

    @Test
    void onSiClick() {
        assertDoesNotThrow(() -> controlador.onSiClick());
    }

    @Test
    void onNoClick() {
        assertDoesNotThrow(() -> controlador.onNoClick());
    }

    @Test
    void onSalirBandoClick() {
        assertDoesNotThrow(() -> controlador.onSalirBandoClick());
    }

    @Test
    void onOpcion8x8Click() {
        assertDoesNotThrow(() -> controlador.onOpcion8x8Click());
    }

    @Test
    void onOpcion10x10Click() {
        assertDoesNotThrow(() -> controlador.onOpcion10x10Click());
    }

    @Test
    void onOpcion15x15Click() {
        assertDoesNotThrow(() -> controlador.onOpcion15x15Click());
    }

    @Test
    void colocarUnidad() {
        assertDoesNotThrow(() -> controlador.colocarUnidad());
    }

    @Test
    void iniciarPartida() {
        assertDoesNotThrow(() -> controlador.iniciarPartida());
    }

    @Test
    void onEmpezarPartidaCienciasClick() {
        assertDoesNotThrow(() -> controlador.onEmpezarPartidaCienciasClick());
    }

    @Test
    void onEmpezarPartidaLetrasClick() {
        assertDoesNotThrow(() -> controlador.onEmpezarPartidaLetrasClick());
    }

    @Test
    void soloSeleccionarUnaUnidad() {
        assertDoesNotThrow(() -> controlador.soloSeleccionarUnaUnidad());
    }

    @Test
    void rollback() {
        assertDoesNotThrow(() -> controlador.rollback());
    }

    @Test
    void onUnidadClick() {
        assertDoesNotThrow(() -> controlador.onUnidadClick());
    }

    @Test
    void getCasillasEnRg() {
        assertDoesNotThrow(() -> controlador.getCasillasEnRg());
    }

    @Test
    void getListaCasillasEnRgBueno() {
        assertDoesNotThrow(() -> controlador.getListaCasillasEnRgBueno());
    }

    @Test
    void onMoverClick() {
        assertDoesNotThrow(() -> controlador.onMoverClick());
    }

    @Test
    void sePuedeMoverA() {
        assertDoesNotThrow(() -> controlador.sePuedeMoverA());
    }

    @Test
    void moverUnidad() {
        assertDoesNotThrow(() -> controlador.moverUnidad());
    }

    @Test
    void onValidarMovimientoClick() {
        assertDoesNotThrow(() -> controlador.onValidarMovimientoClick());
    }

    @Test
    void onAtacarClick() {
        assertDoesNotThrow(() -> controlador.onAtacarClick());
    }

    @Test
    void buscarOpcionEn() {
        assertDoesNotThrow(() -> controlador.buscarOpcionEn());
    }

    @Test
    void atacar() {
        assertDoesNotThrow(() -> controlador.atacar());
    }

    @Test
    void onValidarAtaqueClick() {
        assertDoesNotThrow(() -> controlador.onValidarAtaqueClick());
    }

    @Test
    void ganadorJugador() {
        assertDoesNotThrow(() -> controlador.ganadorJugador());
    }

    @Test
    void ganadorIA() {
        assertDoesNotThrow(() -> controlador.ganadorIA());
    }

    @Test
    void generarUnidadRandom() {
        assertDoesNotThrow(() -> controlador.generarUnidadRandom());
    }

    @Test
    void isTableroLleno() {
        assertDoesNotThrow(() -> controlador.isTableroLleno());
    }

    @Test
    void getSublistaOpcionesTablero() {
        assertDoesNotThrow(() -> controlador.getSublistaOpcionesTablero());
    }

    @Test
    void getDistancia() {
        assertDoesNotThrow(() -> controlador.getDistancia());
    }

    @Test
    void generarGrafoUnidades() {
        assertDoesNotThrow(() -> controlador.generarGrafoUnidades());
    }

    @Test
    void IA() {
        assertDoesNotThrow(() -> controlador.IA());
    }

    @Test
    void onBotonPausaClick() {
        assertDoesNotThrow(() -> controlador.onBotonPausaClick());
    }

    @Test
    void onBotonComoJugarClick() {
        assertDoesNotThrow(() -> controlador.onBotonComoJugarClick());
    }

    @Test
    void onBotonReanudarClick() {
        assertDoesNotThrow(() -> controlador.onBotonReanudarClick());
    }

    @Test
    void onBotonGuardarClick() {
        assertDoesNotThrow(() -> controlador.onBotonGuardarClick());
    }

    @Test
    void onBotonSalirMenuPausaClick() {
        assertDoesNotThrow(() -> controlador.onBotonSalirMenuPausaClick());
    }

    @Test
    void onSiVolverClick() {
        assertDoesNotThrow(() -> controlador.onSiVolverClick());
    }

    @Test
    void onNoVolverClick() {
        assertDoesNotThrow(() -> controlador.onNoVolverClick());
    }
}