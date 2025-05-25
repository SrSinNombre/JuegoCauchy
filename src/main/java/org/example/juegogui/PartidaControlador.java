package org.example.juegogui;

import EstructurasDeDatos.Iterador;
import EstructurasDeDatos.diccionario.Diccionario;
import EstructurasDeDatos.diccionario.DiccionarioBasico;
import EstructurasDeDatos.grafos.GrafoPonderado;
import EstructurasDeDatos.grafos.Vertice;
import EstructurasDeDatos.lista.ListaBasica;
import Unidades.Unidades;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
import java.util.Arrays;

import org.apache.logging.log4j.*;

public class PartidaControlador {
    @FXML
    private CheckBox opcion8x8, opcion10x10, opcion15x15;
    @FXML
    private Label seleccionaTamanno;
    protected int tamannoTablero;
    protected int tamannoCasilla;

    private final Label labelTurno = new Label();
    Label labelUnidad = new Label();
    Label labelHP = new Label();
    Label labelAT = new Label();
    Label labelDF = new Label();
    Label labelRangoAtaque = new Label();
    Label labelRangoMovimiento = new Label();
    ProgressBar barraVida = new ProgressBar();
    Button btnMover = new Button("Mover");
    Button btnAtacar = new Button("Atacar");

    TextField textFieldCoordX = new TextField();
    TextField textFieldCoordY = new TextField();
    Button validarMovimiento = new Button();

    private Button botonPausa;

    protected Partida partida;
    protected DiccionarioBasico<CheckBox, int[]> diccionarioBotones = new DiccionarioBasico<>();
    boolean jugadorEsDeCiencias;
    private Unidades u;
    private CheckBox unidadSeleccionada;
    private GridPane tablero;

    protected static int turno;
    private static final Logger log = LogManager.getLogger(PartidaControlador.class);


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

    public boolean colocarUnidad(GridPane gridPane, Unidades u, int x, int y){ //este es el método bueno, el otro se quita
        if(partida.tablero[x][y] == null){
            partida.tablero[x][y] = u;
            ImageView spriteUnidad = partida.getDiccionarioUnidadesImagen().get(u.getNombre());
            AnchorPane anchorPane = new AnchorPane();
            anchorPane.setStyle("-fx-background-color: white");
            anchorPane.getChildren().add(spriteUnidad);
            CheckBox checkBox = new CheckBox();
            gridPane.add(checkBox, x, y);
            checkBox.setGraphic(anchorPane);
            checkBox.setOnAction(this::onUnidadClick);

            diccionarioBotones.agregar(checkBox, new int[]{x, y});
            System.out.println("Unidad agregada");


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

    public void iniciarPartida(GridPane gridPane, boolean jugadorEsDeCiencias){//este es el método bueno, el otro se quita
        partida = new Partida(tamannoTablero, tamannoTablero, jugadorEsDeCiencias);
        this.jugadorEsDeCiencias = jugadorEsDeCiencias;
        Unidades c1 = partida.getListaUnidades(true).random();
        Unidades c2 = partida.getListaUnidades(true).random();
        Unidades l1 = partida.getListaUnidades(false).random();
        Unidades l2 = partida.getListaUnidades(false).random();
        if(partida.turno == 0){
            colocarUnidad(gridPane, c1, 0, tamannoTablero-1);
            colocarUnidad(gridPane, c2, tamannoTablero-1, tamannoTablero-1);
            colocarUnidad(gridPane, l1, 0, 0);
            colocarUnidad(gridPane, l2, tamannoTablero-1, 0);
        }else if(partida.turno == 1){
            colocarUnidad(gridPane, l1, 0, tamannoTablero-1);
            colocarUnidad(gridPane, l2, tamannoTablero-1, tamannoTablero-1);
            colocarUnidad(gridPane, c1, 0, 0);
            colocarUnidad(gridPane, c2, tamannoTablero-1, 0);
        }
        turno = partida.turno;
    }

    public void onEmpezarPartidaCienciasClick(ActionEvent actionEvent){
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
        tablero = partida.gridPane;
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
        ImageView cementerio = new ImageView(new Image("file:src/main/java/Sprites/gvy.png"));
        cementerio.setFitWidth(tamannoCasilla);
        cementerio.setFitHeight(tamannoCasilla);
        tablero.add(cementerio, 3, tamannoTablero);

        iniciarPartida(tablero, true);
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
        labelTurno.setFont(new Font(35));
        labelTurno.setPrefSize(164, 55);
        labelTurno.setText(Integer.toString(turno));
        hboxTurno.getChildren().addAll(labelTurnoTexto, labelTurno);
        //tengo que bindear labelturno con partida.turno

        // HBox: Unidad seleccionada
        HBox hboxUnidad = new HBox();
        hboxUnidad.setPrefSize(470, 60);
        Label labelUnidadTexto = new Label("Unidad seleccionada:");
        labelUnidadTexto.setFont(new Font(30));
        labelUnidadTexto.setPrefSize(308, 55);
        labelUnidad.setFont(new Font(30));
        labelUnidad.setPrefSize(164, 55);
        hboxUnidad.getChildren().addAll(labelUnidadTexto, labelUnidad);
        //tengo que bindear labelUnidad con u.getNombre()

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
        barraVida.setPrefWidth(200);
        HBox hboxVida = new HBox(new AnchorPane(new ImageView(new Image("file:src/main/java/Sprites/hpt.png"))), barraVida, labelHP);
        hboxVida.setAlignment(Pos.CENTER);
        hboxVida.setPrefSize(470, 50);
        //bindear labelHP cpn u.getHP()

        // ATAQUE
        Label labelAtaque = new Label("ATAQUE");
        labelAtaque.setFont(Font.font("System Bold Italic", 23));
        labelAtaque.setTextFill(javafx.scene.paint.Color.LIME);
        labelAtaque.setPrefSize(256, 54);;
        HBox hboxAtaque = new HBox(new AnchorPane(new ImageView(new Image("file:src/main/java/Sprites/atq.png"))), labelAT);
        hboxAtaque.setAlignment(Pos.CENTER);
        hboxAtaque.setPrefSize(470, 50);
        //bindear labelAT con u.getAtaque()

        // DEFENSA
        Label labelDefensa = new Label("DEFENSA");
        labelDefensa.setFont(Font.font("System Bold Italic", 23));
        labelDefensa.setTextFill(javafx.scene.paint.Color.BLUE);
        labelDefensa.setPrefSize(256, 54);
        HBox hboxDefensa = new HBox(new AnchorPane(new ImageView(new Image("file:src/main/java/Sprites/def.png"))), labelDF);
        hboxDefensa.setAlignment(Pos.CENTER);
        hboxDefensa.setPrefSize(470, 50);
        //bindear labelDF con u.getDefensa()

        // Rango de ataque y movimiento + botones
        VBox vboxAtaque = new VBox(new Label("Rango de ataque:"), labelRangoAtaque);
        vboxAtaque.setPrefSize(109, 87);
        VBox vboxMovimiento = new VBox(new Label("Rango de movimiento:"), labelRangoMovimiento);//bindear labelRangos con u.getRango...
        vboxMovimiento.setPrefSize(129, 87);

        btnMover.setPrefSize(76, 26);
        HBox.setMargin(btnMover, new Insets(0, 20, 0, 20));

        btnAtacar.setPrefSize(76, 26);
        HBox hboxAcciones = new HBox(vboxAtaque, vboxMovimiento, btnMover, btnAtacar);
        hboxAcciones.setPrefSize(470, 87);
        hboxAcciones.setAlignment(Pos.CENTER_LEFT);

        // Agregar todo al VBox principal
        panelLateral.getChildren().addAll(
                hboxTurno, hboxUnidad,
                labelStats,
                labelVida, hboxVida,
                labelAtaque, hboxAtaque,
                labelDefensa, hboxDefensa,
                hboxAcciones
        );

        //campos de texto + boton validarMovimiento
        textFieldCoordX.setPromptText("Introduce coordenada X...");
        textFieldCoordX.setOpacity(0);
        textFieldCoordX.setLayoutX(650);
        textFieldCoordX.setLayoutY(6);
        textFieldCoordX.setDisable(true);

        textFieldCoordY.setPromptText("Introduce coordenada Y...");
        textFieldCoordY.setOpacity(0);
        textFieldCoordY.setLayoutX(834);
        textFieldCoordY.setLayoutY(6);
        textFieldCoordY.setDisable(true);

        validarMovimiento.setText("Validar movimiento");
        validarMovimiento.setOpacity(0);
        validarMovimiento.setDisable(true);
        validarMovimiento.setLayoutX(1033);
        validarMovimiento.setLayoutY(6);

        // Añadir todos los elementos al AnchorPane raíz
        marco.getChildren().addAll(panelLateral);
        marco.getChildren().add(tablero);
        marco.getChildren().add(botonPausa);
        marco.getChildren().addAll(textFieldCoordX, textFieldCoordY, validarMovimiento);
        Scene scene = new Scene(marco);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("CONQUISTA");
        stage.setScene(scene);
        stage.show();
    }//esto mismo que he hecho si el usuario elige ciencias hay que hacerlo si el usuario elige letras, que lo haga otro


    //metodo auxiliar
    public void soloSeleccionarUnaUnidad(DiccionarioBasico<CheckBox, int[]> diccionario, CheckBox opcionSeleccionada){
        for(int i = 0; i < diccionario.getNumElementos(); i++){
            CheckBox c = diccionario.getClaveIndice(i);
            if(c.isSelected() && !c.equals(opcionSeleccionada)){
                c.setSelected(false);
            }
        }
    }
    public void rollback(){
        labelUnidad.setText("");
        labelRangoMovimiento.setText("");
        labelDF.setText("");
        labelHP.setText("");
        labelAT.setText("");
        labelRangoAtaque.setText("");
        barraVida.setProgress(0);
        btnMover.setDisable(true);
        btnAtacar.setDisable(true);
        unidadSeleccionada = null;
        textFieldCoordX.setDisable(true);
        textFieldCoordX.setOpacity(0);
        textFieldCoordY.setDisable(true);
        textFieldCoordY.setOpacity(0);
        validarMovimiento.setDisable(true);
        validarMovimiento.setOpacity(0);
    }

    public void onUnidadClick(ActionEvent actionEvent){
        try {
            CheckBox miOpcion = null;
            for(int i = 0; i < diccionarioBotones.getNumElementos(); i++){
                CheckBox c = diccionarioBotones.getClaveIndice(i);
                if(c.isSelected()){
                    miOpcion = c;
                    soloSeleccionarUnaUnidad(diccionarioBotones, miOpcion);
                    break;
                }
            }
            unidadSeleccionada = miOpcion;
            if(Arrays.equals(diccionarioBotones.get(unidadSeleccionada), new int[]{3, tamannoTablero})){
                unidadSeleccionada.setSelected(false);
                return;
            }
            int[] coordenadas = diccionarioBotones.get(unidadSeleccionada);
            u = partida.tablero[coordenadas[0]][coordenadas[1]];
            labelAT.setText(Integer.toString(u.getAtaque()));
            labelDF.setText(Integer.toString(u.getDefensa()));
            labelHP.setText(Double.toString(u.getHP()));
            barraVida.setProgress(u.getHP()/150);
            labelRangoAtaque.setText(Integer.toString(u.getRango_ataque()));
            labelRangoMovimiento.setText(Integer.toString(u.getRango_movimiento()));
            labelUnidad.setText(u.getNombre());
            if(u.isDeCiencias() == jugadorEsDeCiencias){
                btnMover.setOnAction(this::onMoverClick);
                btnMover.setDisable(false);
                btnAtacar.setOnAction(this::onAtacarClick);
                btnAtacar.setDisable(false);
            }else{
                btnMover.setDisable(true);
                btnAtacar.setDisable(true);
            }
        } catch (NullPointerException e) {
            rollback();
        }
    }

    public ListaBasica<int[]> getCasillasEnRg(int x, int y, int rango){
        ListaBasica<int[]> lista = new ListaBasica<>(1);
        for(int i = -rango; i <= rango; i++){
            for(int j = -rango; j <= rango; j++){
                if(i == 0 && j == 0) continue;
                if((Math.abs(i) + Math.abs(j)) <= rango){
                    lista.add(new int[]{x+i, y+j});
                }
            }
        }
        return lista;
    }
    public ListaBasica<int[]> getListaCasillasEnRgBueno(ListaBasica<int[]> lista){
        ListaBasica<int[]> nuevaListaCasillas = new ListaBasica<>(1);

        int numeroCasillas = lista.getNumElementos();
        for(int i = 0; i < numeroCasillas; i++){
            int[] casilla = lista.get(i);
            if(!(casilla[0] < 0 || casilla[0] >= tamannoTablero || casilla[1] < 0 || casilla[1] >= tamannoTablero)){
                nuevaListaCasillas.add(casilla);
            }
        }
        return nuevaListaCasillas;
    }
    public void onMoverClick(ActionEvent actionEvent){

        textFieldCoordX.setDisable(false);
        textFieldCoordY.setDisable(false);
        textFieldCoordX.setOpacity(1);
        textFieldCoordY.setOpacity(1);
        validarMovimiento.setDisable(false);
        validarMovimiento.setOpacity(1);
        validarMovimiento.setOnAction(this::onValidarMovimientoClick);
        validarMovimiento.setText("Validar movimiento");

    }
    public boolean sePuedeMoverA(CheckBox opcionUnidad, int x, int y){//este es el método bueno, el otro se quita
        try {
            int[] uPos = diccionarioBotones.get(opcionUnidad);
            ListaBasica<int[]> lista = getCasillasEnRg(uPos[0], uPos[1], u.getRango_movimiento());
            ListaBasica<int[]> listaBuena = getListaCasillasEnRgBueno(lista);
            int numeroCasillas = listaBuena.getNumElementos();
            int[] nuevaCasilla = new int[]{x, y};
            for(int i = 0; i < numeroCasillas; i++){
                if(Arrays.equals(nuevaCasilla, listaBuena.get(i))) return true;
            }
            return false;
        } catch (NullPointerException e) {
            rollback();
            return false;
        }
    }
    public boolean moverUnidad(CheckBox opcionUnidad, int x, int y){//este es el método bueno, el otro se quita
        if(!sePuedeMoverA(opcionUnidad, x, y)) return false;
        int[] uPosInicial = diccionarioBotones.get(opcionUnidad);
        GridPane.setConstraints(opcionUnidad, x, y);
        partida.tablero[uPosInicial[0]][uPosInicial[1]] = null;
        diccionarioBotones.delete(opcionUnidad);
        diccionarioBotones.agregar(opcionUnidad, new int[]{x, y});
        return true;

    }
    public void onValidarMovimientoClick(ActionEvent actionEvent){
        String coordX = textFieldCoordX.getText().trim();
        String coordY = textFieldCoordY.getText().trim();
        try{
            int x = Integer.parseInt(coordX);
            int y = Integer.parseInt(coordY);
            unidadSeleccionada.setSelected(false);
            if(!sePuedeMoverA(unidadSeleccionada, x, y)){
                VBox pantalla = new VBox();
                Label label = new Label("No se puede mover la unidad a esa casilla, está fuera de rango");
                pantalla.getChildren().add(label);
                Stage stage = new Stage();
                Scene scene = new Scene(pantalla, 350, 100);
                stage.setTitle("Error");
                stage.setScene(scene);
                stage.show();
            }else {
                moverUnidad(unidadSeleccionada, x, y);
                colocarUnidad(partida.gridPane, u, x, y);
                if(ganadorJugador()){
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/example/juegogui/ganador-jugador.fxml"));
                        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
                        Stage stage = new Stage();
                        stage.setTitle("comojugar");
                        stage.setScene(scene);
                        stage.show();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                        System.err.println("Error al cargar la pantalla principal");
                    }//abrir nueva ventana con el endscreen de cuando gana el jugador
                }else if(ganadorIA()){
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/example/juegogui/ganador-ia.fxml"));
                        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
                        Stage stage = new Stage();
                        stage.setTitle("comojugar");
                        stage.setScene(scene);
                        stage.show();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                        System.err.println("Error al cargar la pantalla principal");
                    }//abrir nueva ventana con el endscreen de cuando gana la IA

                }else{
                    rollback();
                    turno++;
                    labelTurno.setText(Integer.toString(turno));
                    IA();
                    if(turno % 10 == 0) generarUnidadRandom();
                }
            }
        }catch(NumberFormatException e){
            VBox pantalla = new VBox();
            Label label = new Label("Introduce un número");
            pantalla.getChildren().add(label);
            Stage stage = new Stage();
            Scene scene = new Scene(pantalla, 200, 100);
            stage.setTitle("Error");
            stage.setScene(scene);
            stage.show();
        }
    }

    public void onAtacarClick(ActionEvent actionEvent){
        int[] coordenadas = diccionarioBotones.get(unidadSeleccionada);
        ListaBasica<int[]> listaCasillas = getCasillasEnRg(coordenadas[0], coordenadas[1], u.getRango_ataque());
        ListaBasica<int[]> listaCasillasBuenas = getListaCasillasEnRgBueno(listaCasillas);
        int longitudLista = listaCasillasBuenas.getNumElementos();
        for(int i = 0; i < longitudLista; i++){
            int[] casilla = listaCasillasBuenas.get(i);
            if(partida.tablero[casilla[0]][casilla[1]] != null && partida.tablero[casilla[0]][casilla[1]].isDeCiencias() != jugadorEsDeCiencias){
                textFieldCoordX.setDisable(false);
                textFieldCoordY.setDisable(false);
                validarMovimiento.setDisable(false);
                textFieldCoordX.setOpacity(1);
                textFieldCoordY.setOpacity(1);
                validarMovimiento.setOpacity(1);
                validarMovimiento.setText("Validar ataque");
                validarMovimiento.setOnAction(this::onValidarAtaqueClick);
            }
        }
    }

    public CheckBox buscarOpcionEn(int[] casilla){

        if(Arrays.equals(diccionarioBotones.getCabeza().getValor(), casilla)) return diccionarioBotones.getCabeza().getClave();
        Iterador<Diccionario<CheckBox, int[]>> it = diccionarioBotones.getIterador();
        while(it.hasNext()){
            Diccionario<CheckBox, int[]> elemento = it.next();
            if(Arrays.equals(elemento.getValor(), casilla)) return elemento.getClave();
        }
        return null;
    }
    public void atacar(Unidades atacante, int x, int y){
        Unidades atacado = partida.tablero[x][y];
        double factorAleatorio = Math.random() * 2;
        double danoInfligido = Math.abs(factorAleatorio*atacante.getAtaque() - atacado.getDefensa());
        atacado.subirHP(-danoInfligido);
        if(atacado.isUnidadMuerta()){
            CheckBox opcionAtacado = buscarOpcionEn(new int[]{x, y});
            GridPane.setConstraints(opcionAtacado, 3, tamannoTablero);
            partida.listaTodasLasUnidades.delete(atacado);
            partida.tablero[x][y] = null;
        }
    }
    public void onValidarAtaqueClick(ActionEvent actionEvent){
        String coordX = textFieldCoordX.getText().trim();
        String coordY = textFieldCoordY.getText().trim();
        try{
            int x = Integer.parseInt(coordX);
            int y = Integer.parseInt(coordY);
            int[] casillaAtacado = new int[]{x, y};
            ListaBasica<int[]> listaCasillas = getCasillasEnRg(diccionarioBotones.get(unidadSeleccionada)[0], diccionarioBotones.get(unidadSeleccionada)[1], u.getRango_ataque());
            ListaBasica<int[]> listaCasillasBuenas = getListaCasillasEnRgBueno(listaCasillas);
            int longitudLista = listaCasillasBuenas.getNumElementos();
            for(int i = 0; i < longitudLista; i++){
                if(Arrays.equals(casillaAtacado, listaCasillasBuenas.get(i))){
                    if(partida.tablero[casillaAtacado[0]][casillaAtacado[1]] != null && partida.tablero[casillaAtacado[0]][casillaAtacado[1]].isDeCiencias() != jugadorEsDeCiencias){
                        atacar(partida.tablero[casillaAtacado[0]][casillaAtacado[1]], casillaAtacado[0], casillaAtacado[1]);
                    }
                }
            }
            if(ganadorJugador()){
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/example/juegogui/ganador-jugador.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 640, 480);
                    Stage stage = new Stage();
                    stage.setTitle("comojugar");
                    stage.setScene(scene);
                    stage.show();
                }
                catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("Error al cargar la pantalla principal");//abrir nueva ventana con el endscreen de cuando gana el jugador
            }else if(ganadorIA()){
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/example/juegogui/ganador-ia.fxml"));
                        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
                        Stage stage = new Stage();
                        stage.setTitle("comojugar");
                        stage.setScene(scene);
                        stage.show();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                        System.err.println("Error al cargar la pantalla principal");//abrir nueva ventana con el endscreen de cuando gana la IA
            }else{
                rollback();
                turno++;
                labelTurno.setText(Integer.toString(turno));
                IA();
                if(turno % 10 == 0) generarUnidadRandom();
            }
        }catch(NumberFormatException e){
            VBox pantalla = new VBox();
            Label label = new Label("Introduce un número");
            pantalla.getChildren().add(label);
            Stage stage = new Stage();
            Scene scene = new Scene(pantalla, 200, 100);
            stage.setTitle("Error");
            stage.setScene(scene);
            stage.show();
        }
    }

    //DETECCIÓN DE VICTORIA O DERROTA
    public boolean ganadorJugador(){
        int[] casillaCabeza = diccionarioBotones.getCabeza().getValor();
        Unidades unidadCabeza = partida.tablero[casillaCabeza[0]][casillaCabeza[1]];
        if(unidadCabeza != null && unidadCabeza.isDeCiencias() != jugadorEsDeCiencias) return false;
        Iterador<Diccionario<CheckBox, int[]>> it = diccionarioBotones.getIterador();
        while(it.hasNext()){
            int[] casilla = it.next().getValor();
            if(partida.tablero[casilla[0]][casilla[1]] != null && partida.tablero[casilla[0]][casilla[1]].isDeCiencias() != jugadorEsDeCiencias) return false;
        }
        return true;
    }
    public boolean ganadorIA(){
        int[] casillaCabeza = diccionarioBotones.getCabeza().getValor();
        Unidades unidadCabeza = partida.tablero[casillaCabeza[0]][casillaCabeza[1]];
        if(unidadCabeza != null && unidadCabeza.isDeCiencias() == jugadorEsDeCiencias) return false;
        Iterador<Diccionario<CheckBox, int[]>> it = diccionarioBotones.getIterador();
        while(it.hasNext()){
            int[] casilla = it.next().getValor();
            if(partida.tablero[casilla[0]][casilla[1]] != null && partida.tablero[casilla[0]][casilla[1]].isDeCiencias() == jugadorEsDeCiencias) return false;
        }
        return true;
    }
    //GENERAR UNIDAD RANDOM CADA 10 TURNOS
    public void generarUnidadRandom(){
        if(isTableroLleno()){
            return;
        }
        ListaBasica<Unidades> lista1 = partida.getListaUnidades(true);
        ListaBasica<Unidades> lista2 = partida.getListaUnidades(false);
        Unidades u1 = lista1.random();
        Unidades u2 = lista2.random();
        int randX1 = Math.round((float) Math.random()*(tamannoTablero-1));
        int randY1 = Math.round((float) Math.random()*(tamannoTablero-1));
        int randX2 = Math.round((float) Math.random()*(tamannoTablero-1));
        int randY2 = Math.round((float) Math.random()*(tamannoTablero-1));

        while(!colocarUnidad(tablero, u1, randX1, randY1)){
            randX1 = Math.round((float) Math.random()*(tamannoTablero-1));
            randY1 = Math.round((float) Math.random()*(tamannoTablero-1));
        }
        while(!colocarUnidad(tablero, u2, randX2, randY2)){
            randX2 = Math.round((float) Math.random()*(tamannoTablero-1));
            randY2 = Math.round((float) Math.random()*(tamannoTablero-1));
        }

    }
    public boolean isTableroLleno(){
        return diccionarioBotones.getNumElementos() == tamannoTablero*tamannoTablero;
    }
    public ListaBasica<Diccionario<CheckBox, int[]>> getSublistaOpcionesTablero(boolean ciencias){
        ListaBasica<Diccionario<CheckBox, int[]>> sublista = new ListaBasica<>(1);
        int[] casillaCabeza = diccionarioBotones.getCabeza().getValor();
        Unidades unidadCabeza = partida.tablero[casillaCabeza[0]][casillaCabeza[1]];
        if(unidadCabeza.isDeCiencias() == ciencias) sublista.add(diccionarioBotones.getCabeza());
        Iterador<Diccionario<CheckBox, int[]>> it = diccionarioBotones.getIterador();
        while(it.hasNext()){
            Diccionario<CheckBox, int[]> dict = it.next();
            int[] casillaDict = dict.getValor();
            if(partida.tablero[casillaDict[0]][casillaDict[1]] != null && partida.tablero[casillaDict[0]][casillaDict[1]].isDeCiencias() == ciencias) sublista.add(dict);
        }
        return sublista;
    }
    public int getDistancia(int[] uPos, int[] vPos){
        return Math.abs(uPos[0] - vPos[0]) + Math.abs(uPos[1] - vPos[1]);
    }

    public GrafoPonderado<CheckBox> generarGrafoUnidades(){
        ListaBasica<Diccionario<CheckBox, int[]>> sublistaUnidadesJugador = getSublistaOpcionesTablero(jugadorEsDeCiencias);
        ListaBasica<Diccionario<CheckBox, int[]>> sublistaUnidadesIA = getSublistaOpcionesTablero(!jugadorEsDeCiencias);
        Vertice<CheckBox> primerVertice = new Vertice<>(sublistaUnidadesJugador.get(0).getClave());
        GrafoPonderado<CheckBox> grafo = new GrafoPonderado<>(primerVertice);
        int numUnidadesJugador = sublistaUnidadesJugador.getNumElementos();
        int numUnidadesIA = sublistaUnidadesIA.getNumElementos();
        for(int i = 0; i < numUnidadesJugador; i++){
            if(i == 0){
                for(int j = 0; j < numUnidadesIA; j++){
                    Vertice<CheckBox> v = new Vertice<>(sublistaUnidadesIA.get(j).getClave());
                    grafo.addArista(primerVertice, v, getDistancia(sublistaUnidadesJugador.get(0).getValor(), sublistaUnidadesIA.get(j).getValor()));
                }
            }
            for(int j = 0; j < numUnidadesIA; j++){
                Vertice<CheckBox> v1 = new Vertice<>(sublistaUnidadesJugador.get(i).getClave());
                Vertice<CheckBox> v = new Vertice<>(sublistaUnidadesIA.get(j).getClave());
                grafo.addArista(v1, v, getDistancia(sublistaUnidadesJugador.get(i).getValor(), sublistaUnidadesIA.get(j).getValor()));
            }
        }
        return grafo;
    }

    public void IA(){

        ListaBasica<Diccionario<CheckBox, int[]>> listaOpcionesIA = getSublistaOpcionesTablero(!jugadorEsDeCiencias);
        Diccionario<CheckBox, int[]> dicRandom = listaOpcionesIA.random();
        CheckBox opcionRandom = dicRandom.getClave();
        int[] casillaOpcionRandom = dicRandom.getValor();

        int rangoMov = partida.tablero[casillaOpcionRandom[0]][casillaOpcionRandom[1]].getRango_movimiento();
        ListaBasica<int[]> listaCasillasBuenasMover = getListaCasillasEnRgBueno(getCasillasEnRg(casillaOpcionRandom[0], casillaOpcionRandom[1], rangoMov));

        int[] casillaAMoverse = listaCasillasBuenasMover.random();

        if(partida.tablero[casillaAMoverse[0]][casillaAMoverse[1]] != null) {
            if(partida.tablero[casillaAMoverse[0]][casillaAMoverse[1]].isDeCiencias() != jugadorEsDeCiencias){
                atacar(partida.tablero[casillaOpcionRandom[0]][casillaOpcionRandom[1]], casillaAMoverse[0], casillaAMoverse[1]);
                return;
            }else {
                while (partida.tablero[casillaAMoverse[0]][casillaAMoverse[1]] != null && partida.tablero[casillaAMoverse[0]][casillaAMoverse[1]].isDeCiencias() == jugadorEsDeCiencias) {
                    casillaAMoverse = listaCasillasBuenasMover.random();
                }
            }
        }

        partida.tablero[casillaAMoverse[0]][casillaAMoverse[1]] = partida.tablero[casillaOpcionRandom[0]][casillaOpcionRandom[1]];
        moverUnidad(opcionRandom, casillaAMoverse[0], casillaAMoverse[1]);

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
    public void onBotonComoJugarClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/example/juegogui/funcionamiento-juego.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("comojugar");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar la pantalla principal");
        }
    }
}