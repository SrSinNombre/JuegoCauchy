package org.example.juegogui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import controlPartida.*;

import java.io.IOException;

public class PartidaController {
    private boolean esDeCiencias;
    private int Ancho;
    private int obtenerAnchoDesdeBandoController() {
        BandoControllerLetras bandoControllerLetras = new BandoControllerLetras();
        return bandoControllerLetras.Ancho;
    }
    private int obtenerAnchoDesdeBandoController2() {
        BandoControllerCiencias bandoControllerCiencias = new BandoControllerCiencias();
        return bandoControllerCiencias.Ancho;
    }
    private boolean obtenerEsDeCienciasDesdeBandoController() {
        BandoControllerLetras bandoControllerLetras = new BandoControllerLetras();
        return bandoControllerLetras.esDeCiencias;
    }
    private boolean obtenerEsDeCienciasDesdeBandoController2() {
        BandoControllerCiencias bandoControllerCiencias = new BandoControllerCiencias();
        return bandoControllerCiencias.esDeCiencias;
    }
    @FXML
    protected void iniciarPartida() {
        Ancho = obtenerAnchoDesdeBandoController();
        Partida partida = new Partida(Ancho, Ancho, esDeCiencias);
        partida.iniciarPartida();
    }
    @FXML
    protected void pausarPartida(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/example/juegogui/pantalla-pausa.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 640, 480);
            Stage stage = new Stage();
            stage.setTitle("PAUSA");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar la pantalla principal");
        }
    }
}
