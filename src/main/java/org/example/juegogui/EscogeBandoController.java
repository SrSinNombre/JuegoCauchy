package org.example.juegogui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class EscogeBandoController {
    @FXML
    private Button Ciencias;
    @FXML
    private Button Letras;
    @FXML
    private Button SalirAlMenu;
    @FXML
    private Label cabecera;

    @FXML
    public void onCienciasClick(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/example/juegogui/bando-ciencias.fxml"));
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
    public void onLetrasClick(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/example/juegogui/bando-letras.fxml"));
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
    public void onSalirClick(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/example/juegogui/pantalla-principal.fxml"));
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
}
