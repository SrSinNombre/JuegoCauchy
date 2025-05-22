package org.example.juegogui;

import Unidades.Unidades;
import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PartidaControlador {
    @FXML
    private CheckBox opcion8x8, opcion10x10, opcion15x15;
    @FXML
    private Label seleccionaTamanno;
    protected int tamannoTablero;

    private final Label labelTurno = new Label();

    private Button botonPausa;

    Partida partida;

    ObjectProperty<Unidades> unidad = new SimpleObjectProperty<>();


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
            System.out.println("Error al cargar la pantalla principal");
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
            System.out.println("Error al cargar la pantalla principal");
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
            System.out.println("Error al cargar la pantalla principal");
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
            System.out.println("Error al cargar la pantalla principal");
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
            System.out.println("Error al cargar la pantalla principal");
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
            System.out.println("Error al cargar la pantalla principal");
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
            System.out.println("Error al cargar la pantalla principal");
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

    public boolean colocarUnidad(Unidades u, int x, int y){
        if(partida.tablero[x][y] == null){
            partida.tablero[x][y] = u;
            ImageView spriteUnidad = partida.getDiccionarioUnidadesImagen().get(u.getNombre());
            Button botonUnidad = new Button();
            partida.gridPane.add(botonUnidad, x, y);
            botonUnidad.setPrefSize(30, 30);
            botonUnidad.setGraphic(spriteUnidad);
            botonUnidad.setOnAction(this::onUnidadClick);


            int[] casilla = new int[]{x, y};
            partida.listaTodasLasUnidades.agregar(u, casilla);
            if(partida.propiedadCasilla(casilla).equals("+10HP")) u.subirHP(10);
            if(partida.propiedadCasilla(casilla).equals("+20HP")) u.subirHP(20);
            if(partida.propiedadCasilla(casilla).equals("+50HP")) u.subirHP(50);
            if(partida.propiedadCasilla(casilla).equals("+5AT")) u.subirAtaque(5);
            if(partida.propiedadCasilla(casilla).equals("+10AT")) u.subirAtaque(10);
            if(partida.propiedadCasilla(casilla).equals("+5DF")) u.subirDefensa(5);
            if(partida.propiedadCasilla(casilla).equals("+10DF")) u.subirDefensa(10);
            return true;
        }else return false;
    }

    public void iniciarPartida(boolean jugadorEsDeCiencias){
        partida = new Partida(tamannoTablero, tamannoTablero, jugadorEsDeCiencias);
        Unidades c1 = partida.getListaUnidades(true).random();
        Unidades c2 = partida.getListaUnidades(true).random();
        Unidades l1 = partida.getListaUnidades(false).random();
        Unidades l2 = partida.getListaUnidades(false).random();
        if(partida.turno == 0){
            partida.colocarUnidad(c1, 0, tamannoTablero-1);
            partida.colocarUnidad(c2, tamannoTablero-1, tamannoTablero-1);
            partida.colocarUnidad(l1, 0, 0);
            partida.colocarUnidad(l2, tamannoTablero-1, 0);
        }else if(partida.turno == 1){
            partida.colocarUnidad(l1, 0, tamannoTablero-1);
            partida.colocarUnidad(l2, tamannoTablero-1, tamannoTablero-1);
            partida.colocarUnidad(c1, 0, 0);
            partida.colocarUnidad(c2, tamannoTablero-1, 0);
        }
    }

    public void onEmpezarPartidaCienciasClick(ActionEvent actionEvent){
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

        Partida partida = new Partida(tamannoTablero, tamannoTablero, true);
        GridPane tablero = partida.gridPane;
        for(int i = 0; i < tamannoTablero; i++){
            for(int j = 0; j < tamannoTablero; j++){
                int suma = i+j;
                Image image;
                if(suma % 2 == 0) image = new Image("file:src/main/java/Sprites/blt.png");
                else image = new Image("file:src/main/java/Sprites/wht.png");
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(tamannoCasilla);
                imageView.setFitHeight(tamannoCasilla);
                tablero.add(imageView, j, i);
            }
        }

        partida.iniciarPartida();
        tablero.setGridLinesVisible(true);
        tablero.setLayoutX(650);
        tablero.setLayoutY(84);

        //boton pausa
        botonPausa = new Button("| |");
        botonPausa.setPrefSize(69, 69);
        botonPausa.setLayoutX(10);
        botonPausa.setLayoutY(10);
        botonPausa.setFont(new Font("System Bold", 30));
        botonPausa.setOnAction(this::onBotonPausaClick);

        // VBox (Panel lateral izquierdo)
        VBox panelLateral = new VBox();
        panelLateral.setLayoutX(50);
        panelLateral.setLayoutY(90);
        panelLateral.setPrefSize(470, 600);
        panelLateral.setAlignment(Pos.TOP_CENTER);
        panelLateral.setSpacing(10);

        // HBox: Turno
        HBox hboxTurno = new HBox();
        hboxTurno.setPrefSize(470, 64);
        Label labelTurnoTexto = new Label("Turno número: ");
        labelTurnoTexto.setFont(new Font(35));
        labelTurnoTexto.setPrefSize(308, 55);
        Label labelTurno = new Label("Turno");
        labelTurno.setFont(new Font(35));
        labelTurno.setPrefSize(164, 55);
        hboxTurno.getChildren().addAll(labelTurnoTexto, labelTurno);

        // HBox: Unidad seleccionada
        HBox hboxUnidad = new HBox();
        hboxUnidad.setPrefSize(470, 60);
        Label labelUnidadTexto = new Label("Unidad seleccionada:");
        labelUnidadTexto.setFont(new Font(31));
        labelUnidadTexto.setPrefSize(308, 55);
        Label labelUnidad = new Label("Unidad");
        labelUnidad.setFont(new Font(35));
        labelUnidad.setPrefSize(164, 55);
        hboxUnidad.getChildren().addAll(labelUnidadTexto, labelUnidad);

        // Estadísticas
        Label labelStats = new Label("ESTADÍSTICAS:");
        labelStats.setFont(Font.font("System Bold", 49));
        labelStats.setTextFill(javafx.scene.paint.Color.web("#c4e505"));
        labelStats.setPrefSize(364, 75);

        // VIDA
        Label labelVida = new Label("VIDA");
        labelVida.setFont(Font.font("System Bold Italic", 23));
        labelVida.setTextFill(javafx.scene.paint.Color.RED);
        labelVida.setPrefSize(256, 54);
        ProgressBar barraVida = new ProgressBar(0.0);
        barraVida.setPrefWidth(200);
        HBox hboxVida = new HBox(new AnchorPane(new ImageView(new Image("file:src/main/java/Sprites/hpt.png"))), barraVida);
        hboxVida.setAlignment(Pos.CENTER);
        hboxVida.setPrefSize(470, 50);

        // ATAQUE
        Label labelAtaque = new Label("ATAQUE");
        labelAtaque.setFont(Font.font("System Bold Italic", 23));
        labelAtaque.setTextFill(javafx.scene.paint.Color.LIME);
        labelAtaque.setPrefSize(256, 54);
        ProgressBar barraAtaque = new ProgressBar(0.0);
        barraAtaque.setPrefWidth(200);
        HBox hboxAtaque = new HBox(new AnchorPane(new ImageView(new Image("file:src/main/java/Sprites/atq.png"))), barraAtaque);
        hboxAtaque.setAlignment(Pos.CENTER);
        hboxAtaque.setPrefSize(470, 50);

        // DEFENSA
        Label labelDefensa = new Label("DEFENSA");
        labelDefensa.setFont(Font.font("System Bold Italic", 23));
        labelDefensa.setTextFill(javafx.scene.paint.Color.BLUE);
        labelDefensa.setPrefSize(256, 54);
        ProgressBar barraDefensa = new ProgressBar(0.0);
        barraDefensa.setPrefWidth(200);
        HBox hboxDefensa = new HBox(new AnchorPane(new ImageView(new Image("file:src/main/java/Sprites/def.png"))), barraDefensa);
        hboxDefensa.setAlignment(Pos.CENTER);
        hboxDefensa.setPrefSize(470, 50);

        // Rango de ataque y movimiento + botones
        VBox vboxAtaque = new VBox(new Label("Rango de ataque:"), new Label("rango"));
        vboxAtaque.setPrefSize(109, 87);
        VBox vboxMovimiento = new VBox(new Label("Rango de movimiento:"), new Label("rango"));
        vboxMovimiento.setPrefSize(129, 87);
        Button btnMover = new Button("Mover");
        btnMover.setPrefSize(76, 26);
        HBox.setMargin(btnMover, new Insets(0, 20, 0, 20));
        Button btnAtacar = new Button("Atacar");
        btnAtacar.setPrefSize(76, 26);
        HBox hboxAcciones = new HBox(vboxAtaque, vboxMovimiento, btnMover, btnAtacar);
        hboxAcciones.setPrefSize(470, 87);
        hboxAcciones.setAlignment(Pos.CENTER_LEFT);

        // Botón de pausa
        Button btnPausa = new Button("| |");
        btnPausa.setFont(Font.font("System Bold", 30));
        btnPausa.setPrefSize(69, 69);
        btnPausa.setLayoutX(14);
        btnPausa.setLayoutY(14);

        // Agregar todo al VBox principal
        panelLateral.getChildren().addAll(
                hboxTurno, hboxUnidad,
                labelStats,
                labelVida, hboxVida,
                labelAtaque, hboxAtaque,
                labelDefensa, hboxDefensa,
                hboxAcciones
        );

        // Añadir todos los elementos al AnchorPane raíz
        marco.getChildren().addAll(panelLateral);
        marco.getChildren().add(tablero);
        marco.getChildren().add(botonPausa);
        Scene scene = new Scene(marco);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("CONQUISTA");
        stage.setScene(scene);
        stage.show();
    }//esto mismo que he hecho si el usuario elige ciencias hay que hacerlo si el usuario elige letras, que lo haga otro

    public void onUnidadClick(ActionEvent actionEvent){

    }



    //pantalla pausa, todo lo demás que hay que hacer que lo haga otro
    public void onBotonPausaClick(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/example/juegogui/pantalla-pausa.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 640, 480);
            Stage stage = new Stage();
            stage.setTitle("Pausa");
            stage.setScene(scene);
            stage.show();

        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar la pantalla principal");
        }
    }
}