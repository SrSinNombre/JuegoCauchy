package org.example.juegogui;

import EstructurasDeDatos.Iterador;
import EstructurasDeDatos.Lista;
import EstructurasDeDatos.diccionario.*;
import EstructurasDeDatos.grafos.*;
import EstructurasDeDatos.lista.ListaBasica;
import Unidades.*;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import org.apache.logging.log4j.*;

public class Partida {
    private static final Logger log = LogManager.getLogger(Partida.class);
    protected int turno;
    protected int tableroAncho;
    protected int tableroAlto;
    protected Unidades[][] tablero;
    protected DiccionarioBasico<Unidades, int[]> listaTodasLasUnidades = new DiccionarioBasico<>();


    @FXML
    protected GridPane gridPane = new GridPane();

    public Partida(int tableroAncho, int tableroAlto, boolean jugadorEsDeCiencias){
        this.tableroAncho = tableroAncho;
        this.tableroAlto = tableroAlto;

        if(jugadorEsDeCiencias) {
            turno = 0;
        }
        else {
            turno = 1;
        }
        tablero = new Unidades[tableroAncho][tableroAlto];
        //tamaños del tablero: 8x8, 10x10, 15x15
    }

    public int getTurno(){
        return turno;
    }
    public void setTurno(int turno){
        this.turno = turno;
    }
    public boolean isTableroCuadrado(){
        return tableroAlto == tableroAncho;
    }

    public ListaBasica<Unidades> getListaUnidades(boolean esDeCiencias){
        ListaBasica<Unidades> lista = new ListaBasica<>(5);
        if(esDeCiencias){
            Ciencias c = new Ciencias();
            lista.add(c.getIngeniero());
            lista.add(c.getFisico());
            lista.add(c.getBiologo());
            lista.add(c.getQuimico());
            lista.add(c.getMatematico());
        }else{
            Letras l = new Letras();
            lista.add(l.getFilologo());
            lista.add(l.getFilosofo());
            lista.add(l.getHistoriador());
            lista.add(l.getTeologo());
            lista.add(l.getTraductor());
        }
        return lista;
    }
    public DiccionarioBasico<String, ImageView> getDiccionarioUnidadesImagen(){
        DiccionarioBasico<String, ImageView> diccionario = new DiccionarioBasico<>();

        Ciencias c = new Ciencias();
        Letras l = new Letras();
        diccionario.agregar    (c.getBiologo().getNombre(), new ImageView(new Image("file:src/main/java/Sprites/bio.png")));
        diccionario.agregar     (c.getFisico().getNombre(), new ImageView(new Image("file:src/main/java/Sprites/fis.png")));
        diccionario.agregar    (c.getQuimico().getNombre(), new ImageView(new Image("file:src/main/java/Sprites/qui.png")));
        diccionario.agregar  (c.getIngeniero().getNombre(), new ImageView(new Image("file:src/main/java/Sprites/ing.png")));
        diccionario.agregar (c.getMatematico().getNombre(), new ImageView(new Image("file:src/main/java/Sprites/mat.png")));
        diccionario.agregar   (l.getFilologo().getNombre(), new ImageView(new Image("file:src/main/java/Sprites/fil.png")));
        diccionario.agregar   (l.getFilosofo().getNombre(), new ImageView(new Image("file:src/main/java/Sprites/phi.png")));
        diccionario.agregar    (l.getTeologo().getNombre(), new ImageView(new Image("file:src/main/java/Sprites/teo.png")));
        diccionario.agregar(l.getHistoriador().getNombre(), new ImageView(new Image("file:src/main/java/Sprites/his.png")));
        diccionario.agregar  (l.getTraductor().getNombre(), new ImageView(new Image("file:src/main/java/Sprites/tra.png")));

        return diccionario;
    }

    public boolean colocarUnidad(Unidades u, int x, int y){
        if(tablero[x][y] == null){
            tablero[x][y] = u;
            ImageView spriteUnidad = getDiccionarioUnidadesImagen().get(u.getNombre());
            Button botonUnidad = new Button();
            gridPane.add(botonUnidad, x, y);
            botonUnidad.setPrefSize(30, 30);
            botonUnidad.setGraphic(spriteUnidad);

            int[] casilla = new int[]{x, y};
            listaTodasLasUnidades.agregar(u, casilla);
            if(propiedadCasilla(casilla).equals("+10HP")) u.subirHP(10);
            if(propiedadCasilla(casilla).equals("+20HP")) u.subirHP(20);
            if(propiedadCasilla(casilla).equals("+50HP")) u.subirHP(50);
            if(propiedadCasilla(casilla).equals("+5AT")) u.subirAtaque(5);
            if(propiedadCasilla(casilla).equals("+10AT")) u.subirAtaque(10);
            if(propiedadCasilla(casilla).equals("+5DF")) u.subirDefensa(5);
            if(propiedadCasilla(casilla).equals("+10DF")) u.subirDefensa(10);
            return true;
        }else return false;
    }
    public ListaBasica<CasillaEspecial> generarCasillasEspeciales(int ladoTablero){
        if(!isTableroCuadrado()) return null;
        ListaBasica<CasillaEspecial> lista = new ListaBasica<>(8);
        lista.add(new CasillaEspecial(new int[]{0, 1}, "+10HP"));
        lista.add(new CasillaEspecial(new int[]{1, 5}, "+20HP"));
        lista.add(new CasillaEspecial(new int[]{2, 3}, "+10AT"));
        lista.add(new CasillaEspecial(new int[]{3, 6}, "+5DF"));
        lista.add(new CasillaEspecial(new int[]{4, 0}, "+10HP"));
        lista.add(new CasillaEspecial(new int[]{5, 2}, "+5AT"));
        lista.add(new CasillaEspecial(new int[]{7, 4}, "+50HP"));
        lista.add(new CasillaEspecial(new int[]{6, 7}, "+10DF"));

        if(ladoTablero == 10){
            lista.add(new CasillaEspecial(new int[]{8, 9}, "+20HP"));
            lista.add(new CasillaEspecial(new int[]{9, 8}, "+10DF"));
        }
        if(ladoTablero == 15){
            lista.add(new CasillaEspecial(new int[]{8, 14}, "+10HP"));
            lista.add(new CasillaEspecial(new int[]{9, 10}, "+50HP"));
            lista.add(new CasillaEspecial(new int[]{10, 13}, "+10AT"));
            lista.add(new CasillaEspecial(new int[]{11, 9}, "+10DF"));
            lista.add(new CasillaEspecial(new int[]{12, 11}, "+5DF"));
            lista.add(new CasillaEspecial(new int[]{13, 8}, "+5AT"));
            lista.add(new CasillaEspecial(new int[]{14, 12}, "+20HP"));
        }
        return lista;
    }
    public String propiedadCasilla(int[] casilla){
        ListaBasica<CasillaEspecial> lista = generarCasillasEspeciales(tableroAncho);
        if(lista.get(0).getCoordenadas() == casilla) return lista.get(0).getPropiedad();
        Iterador<CasillaEspecial> it = lista.getIterador();
        while(it.hasNext()){
            if(it.next().getCoordenadas() == casilla) return it.next().getPropiedad();
        }
        return "null";
    }



}
