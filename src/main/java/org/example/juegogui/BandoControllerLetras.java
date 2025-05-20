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
public class BandoControllerLetras {
    int Ancho;
    Boolean esDeCiencias;
    @FXML
    private Button EmpezarPartida;
    @FXML
    private Button SalirBando;
    @FXML
    private Button ocho;
    @FXML
    private Button diez;
    @FXML
    private Button quince;
    @FXML
    private Label cabecera;

    @FXML
    public void onEmpezarPartidaClick(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/example/juegogui/pantalla-partida.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 640, 480);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("CONQUISTA");
            stage.setScene(scene);
            stage.show();
            this.esDeCiencias = false;
        }
        catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar la pantalla principal");
        }
    }
    public void onSalirBandoClick(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/example/juegogui/escoge-bando.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 640, 480);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("CONQUISTA");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar la pantalla principal");
        }
    }
    public void onOchoClick(){
        this.Ancho = 8;
    }
    public void onDiezClick(){
        this.Ancho = 10;
    }
    public void onQuinceClick(){
        this.Ancho = 15;
    }
}