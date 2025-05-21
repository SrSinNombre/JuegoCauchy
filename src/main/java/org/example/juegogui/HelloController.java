package org.example.juegogui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label cabecera;

    @FXML
    private Button botonNuevaPartida;
    @FXML
    private Button botonCargarPartida;
    @FXML
    private Button botonSalirDelJuego;

    @FXML
    private Button ciencias;
    @FXML
    private Button letras;
    @FXML
    private Button salirAlMenu;

    @FXML
    private Button siSalida;
    @FXML
    private Button noSalida;

    @FXML
    private Button salirBando;
    @FXML
    private CheckBox opcion8x8, opcion10x10, opcion15x15;
    @FXML
    private Label seleccionaTamanno;
    @FXML
    private Button empezarPartidaCiencias;
    @FXML
    private Button empezarPartidaLetras;


    //pantalla principal
    @FXML
    public void onBotonNuevaPartidaClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/example/juegogui/escoge-bando.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 640, 480);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("EscogeBando");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar la pantalla principal");
        }
    }
    @FXML
    public void onBotonSalirDelJuegoClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/example/juegogui/preguntar-salida.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 640, 480);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("PreguntaSalida");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar la pantalla principal");
        }
    }

    //escoge bando
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
    @FXML
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
    @FXML
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

    //preguntar salida
    @FXML
    public void onSiClick() {
        System.exit(0);
    }

    @FXML
    public void onNoClick(ActionEvent actionEvent) {
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

    //bando
    @FXML
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
    public void onOpcion8x8Click(){
        opcion10x10.setSelected(false);
        opcion15x15.setSelected(false);
    }
    public void onOpcion10x10Click(){
        opcion8x8.setSelected(false);
        opcion15x15.setSelected(false);
    }
    public void onOpcion15x15Click(){
        opcion10x10.setSelected(false);
        opcion8x8.setSelected(false);
    }

    public void onEmpezarPartidaCienciasClick(ActionEvent actionEvent){
        int tamannoTablero = 0;
        int tamannoCasilla = 0;
        if(opcion8x8.isSelected()) {
            tamannoTablero = 8;
            tamannoCasilla = 75;
        }
        if(opcion10x10.isSelected()) {
            tamannoTablero = 10;
            tamannoCasilla = 60;
        }
        if(opcion15x15.isSelected()) {
            tamannoTablero = 15;
            tamannoCasilla = 40;
        }
        if(tamannoTablero == 0) {
            seleccionaTamanno.setTextFill(Paint.valueOf("000000"));
            return;
        }

        AnchorPane marco = new AnchorPane();
        marco.setPrefSize(1350, 768);

        GridPane tablero = new GridPane();
        for(int i = 0; i < tamannoTablero; i++){
            for(int j = 0; j < tamannoTablero; j++){
                int suma = i+j;
                Image image;
                if(suma % 2 == 0){
                    image = new Image("file:src/main/java/Sprites/blt.png");
                }else{
                    image = new Image("file:src/main/java/Sprites/wht.png");
                }
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(tamannoCasilla);
                imageView.setFitHeight(tamannoCasilla);
                tablero.add(imageView, i, j);
            }
        }
        tablero.setGridLinesVisible(true);
        tablero.setLayoutX(650);
        tablero.setLayoutY(84);

        Partida partida = new Partida(tamannoTablero, tamannoTablero, true);
        partida.iniciarPartida();

        marco.getChildren().add(tablero);
        Scene scene = new Scene(marco);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("CONQUISTA");
        stage.setScene(scene);
        stage.show();
    }
}