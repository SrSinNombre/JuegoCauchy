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
    public int[] buscarUnidad(Unidades u){
        return listaTodasLasUnidades.get(u);
    }
    public boolean sePuedeMoverA(Unidades u, int x, int y){
        int[] uPos = buscarUnidad(u);
        if(Math.abs(x - uPos[0]) > u.getRango_movimiento()) return false;
        if(Math.abs(y - uPos[1]) > u.getRango_movimiento()) return false;

        return true;
    }
    public boolean moverUnidad(Unidades u, int x, int y){
        if(!sePuedeMoverA(u, x, y)) return false;
        int[] uPosInicial = buscarUnidad(u);
        colocarUnidad(u, x, y);
        tablero[uPosInicial[0]][uPosInicial[1]] = null;
        log.info("El {} se ha movido a la casilla {},{} en el turno {}", u, x, y, turno);
        return true;

    }
    public boolean puedeAtacarA(Unidades atacante, Unidades atacado){
        int[] posAtacante = buscarUnidad(atacante);
        int[] posAtacado = buscarUnidad(atacado);
        if(Math.abs(posAtacante[0] - posAtacado[0]) > atacante.getRango_ataque()) return false;
        if(Math.abs(posAtacante[1] - posAtacado[1]) > atacante.getRango_ataque()) return false;

        return true;
    }
    public boolean puedeAtacarA(Unidades atacante, int x, int y){
        int[] posAtacante = buscarUnidad(atacante);
        if(Math.abs(posAtacante[0] - x) > atacante.getRango_ataque()) return false;
        if(Math.abs(posAtacante[1] - y) > atacante.getRango_ataque()) return false;

        return true;
    }
    public boolean atacar(Unidades atacante, Unidades atacado){
        if(!puedeAtacarA(atacante, atacado)) return false;
        double factorAleatorio = Math.random() * 2;
        double danoInfligido = Math.abs(factorAleatorio*atacante.getAtaque() - atacado.getDefensa());
        atacado.subirHP(-danoInfligido);
        log.info("El {} le ha infligido un daño de {} al {}", atacante, danoInfligido, atacado);
        if(atacado.isUnidadMuerta()){
            int[] atacadoPos = buscarUnidad(atacado);
            tablero[atacadoPos[0]][atacadoPos[1]] = null;
            listaTodasLasUnidades.delete(atacado);
            gridPane.add(null, buscarUnidad(atacado)[0], buscarUnidad(atacado)[1]);
            log.info("El {} ha muerto", atacado);
        }
        else{
            log.info("El {} tiene {} de vida", atacado, atacado.getHP());
        }
        return true;
    }
    public boolean generarUnidadRandom(boolean esDeCiencias){
        ListaBasica<Unidades> lista = getListaUnidades(esDeCiencias);
        Unidades u = lista.random();
        int randX = Math.round((float) Math.random()*(tableroAncho-1));
        int randY = Math.round((float) Math.random()*(tableroAlto-1));
        log.info("Se ha generado un {} en la casilla {},{}", u, randX, randY);
        return colocarUnidad(u, randX, randY);
    }

    public void iniciarPartida(){
        Unidades c1 = getListaUnidades(true).random();
        Unidades c2 = getListaUnidades(true).random();
        Unidades l1 = getListaUnidades(false).random();
        Unidades l2 = getListaUnidades(false).random();
        if(turno == 0){
            colocarUnidad(c1, 0, tableroAlto-1);
            colocarUnidad(c2, tableroAncho-1, tableroAlto-1);
            colocarUnidad(l1, 0, 0);
            colocarUnidad(l2, tableroAncho-1, 0);
        }else if(turno == 1){
            colocarUnidad(l1, 0, tableroAlto-1);
            colocarUnidad(l2, tableroAncho-1, tableroAlto-1);
            colocarUnidad(c1, 0, 0);
            colocarUnidad(c2, tableroAncho-1, 0);
        }
        log.info("La partida ha comenzado");
        log.info("El tablero es {}x{}", tableroAncho, tableroAlto);
    }
    public boolean finPartida(){
        if(generarGrafoUnidades(true) == null || generarGrafoUnidades(false) == null){
            log.info("Fin de partida");
            return true;
        }
        return false;
    }


    public int getDistancia(Unidades u, Unidades v){
        int[] uPos = listaTodasLasUnidades.get(u);
        int[] vPos = listaTodasLasUnidades.get(v);
        return Math.abs(uPos[0] - vPos[0]) + Math.abs(uPos[1] - vPos[1]);
    }
    public DiccionarioBasico<Unidades, int[]> getDiccionarioUnidadesTablero(boolean esDeCiencias){
        Iterador<Diccionario<Unidades, int[]>> it = listaTodasLasUnidades.getIterador();
        DiccionarioBasico<Unidades, int[]> diccionarioUnidadesTablero = new DiccionarioBasico<>();

        if(listaTodasLasUnidades.getCabeza().getClave().isDeCiencias() == esDeCiencias) {
            diccionarioUnidadesTablero.agregar(listaTodasLasUnidades.getCabeza().getClave(),
                    listaTodasLasUnidades.getCabeza().getValor());
        }
        while(it.hasNext()){
            Unidades u = it.next().getClave();
            if(u.isDeCiencias() == esDeCiencias) diccionarioUnidadesTablero.agregar(u, listaTodasLasUnidades.get(u));
        }
        return diccionarioUnidadesTablero;
    }
    public Arista<Unidades> elegirAristaIA(ListaBasica<Arista<Unidades>> listaAristas){
        if(listaAristas.getNumElementos() == 1) return listaAristas.get(0);
        else return listaAristas.random();
    }
    public Unidades elegirUnidadIA(Arista<Unidades> arista, boolean iaEsDeCiencias){
        if(arista.getOrigen().getValor().isDeCiencias() == iaEsDeCiencias) return arista.getOrigen().getValor();
        else return arista.getDestino().getValor();
    }
    public int[] elegirMejorCasilla(Arista<Unidades> arista, boolean iaEsDeCiencias){
        Unidades unidadIA = elegirUnidadIA(arista, iaEsDeCiencias);
        Unidades unidadJugador = elegirUnidadIA(arista, !iaEsDeCiencias);
        int[] casillaUnidadIA = buscarUnidad(unidadIA);
        int[] casillaUnidadJugador = buscarUnidad(unidadJugador);
        int xDiff = casillaUnidadJugador[0] - casillaUnidadIA[0]; //Si unidadIA está a la derecha xDiff < 0, bien para cuando se quiera alejarse
        int yDiff = casillaUnidadJugador[1] - casillaUnidadIA[1];
        int deltaX = 0;
        int deltaY = 0;
        if(arista.getPeso() > unidadIA.getRango_ataque()){ //Si la unidad del jugador está fuera del rango de ataque, que se mueva

            if(unidadIA.getHP() >= 30){  //Si unidadIA tiene suficiente vida, que se acerque, pero si unidadIA tiene poca vida, que huya
                if(xDiff != 0) deltaX = unidadIA.getRango_movimiento()*(xDiff/Math.abs(xDiff)); //xDiff/Math.abs(xDiff) da 1 0 -1
                if(yDiff != 0) deltaY = unidadIA.getRango_movimiento()*(yDiff/Math.abs(yDiff));

            }else{
                if(xDiff != 0) deltaX = -unidadIA.getRango_movimiento()*(xDiff/Math.abs(xDiff));
                if(yDiff != 0) deltaY = -unidadIA.getRango_movimiento()*(yDiff/Math.abs(yDiff));

            }
        }else if(arista.getPeso() <= unidadIA.getRango_ataque()){
            if(unidadIA.getHP() >= 30) {
                return null; //no elijo casilla a la que moverme y ataco
                //retorna null si la otra está dentro del rango de ataque y unidadIA tiene más de 30 de vida
            }
            else{ //Igual que en el anterior if
                if(xDiff != 0) deltaX = unidadIA.getRango_movimiento()*(xDiff/Math.abs(xDiff));
                if(yDiff != 0) deltaY = unidadIA.getRango_movimiento()*(yDiff/Math.abs(yDiff));
            }
        }
        return new int[]{casillaUnidadIA[0] + deltaX, casillaUnidadIA[1] + deltaY}; //imposible que los dos deltas sigan siendo 0 por los diffs
    }
    public GrafoPonderado<Unidades> generarGrafoUnidades(boolean iaEsDeCiencias){
            DiccionarioBasico<Unidades, int[]> diccionarioUnidadesTableroIA = getDiccionarioUnidadesTablero(iaEsDeCiencias);
            Unidades cabezaIA = diccionarioUnidadesTableroIA.getCabeza().getClave();
            DiccionarioBasico<Unidades, int[]> diccionarioUnidadesTableroJugador = getDiccionarioUnidadesTablero(!iaEsDeCiencias);
            Unidades cabezaJugador = diccionarioUnidadesTableroJugador.getCabeza().getClave();

            Vertice<Unidades> primerVertice = new Vertice<>(cabezaIA);
            GrafoPonderado<Unidades> grafoUnidades = new GrafoPonderado<>(primerVertice);

            grafoUnidades.addArista(primerVertice, new Vertice<>(cabezaJugador),
                    getDistancia(primerVertice.getValor(), cabezaJugador));

            Iterador<Diccionario<Unidades, int[]>> itJ1 = diccionarioUnidadesTableroJugador.getIterador();
            while(itJ1.hasNext()){
                Unidades u = itJ1.next().getClave();
                grafoUnidades.addArista(primerVertice, new Vertice<>(u), getDistancia(primerVertice.getValor(), u));
            }
            Iterador<Diccionario<Unidades, int[]>> itIA1 = diccionarioUnidadesTableroIA.getIterador();
            while(itIA1.hasNext()){
                Unidades u = itIA1.next().getClave();
                grafoUnidades.addArista(new Vertice<>(u), new Vertice<>(cabezaJugador), getDistancia(u, cabezaJugador));
                Iterador<Diccionario<Unidades, int[]>> itJ2 = diccionarioUnidadesTableroJugador.getIterador();
                while(itJ2.hasNext()){
                    Unidades v = itJ2.next().getClave();
                    grafoUnidades.addArista(new Vertice<>(u), new Vertice<>(v), getDistancia(u, v));
                }
            }
            return grafoUnidades;
    }

    public void IA(boolean iaEsDeCiencias){

        GrafoPonderado<Unidades> grafoUnidades = generarGrafoUnidades(iaEsDeCiencias);
        //grafoUnidades conecta todas las unidades del jugador con las de la ia PERO NO ENTRE SÍ

        ListaBasica<Arista<Unidades>> listaAristasMenorPeso = grafoUnidades.getAristasMenorPeso();
        Arista<Unidades> aristaElegida = elegirAristaIA(listaAristasMenorPeso);
        int[] casillaElegida = elegirMejorCasilla(aristaElegida, iaEsDeCiencias);
        if(casillaElegida == null) atacar(elegirUnidadIA(aristaElegida, iaEsDeCiencias), elegirUnidadIA(aristaElegida, !iaEsDeCiencias));
        else {
            while (puedeAtacarA(elegirUnidadIA(aristaElegida, !iaEsDeCiencias), casillaElegida[0], casillaElegida[1]) && listaAristasMenorPeso.getNumElementos() != 1) {
                aristaElegida = elegirAristaIA(listaAristasMenorPeso);
                casillaElegida = elegirMejorCasilla(aristaElegida, iaEsDeCiencias);
            }
            moverUnidad(elegirUnidadIA(aristaElegida, iaEsDeCiencias), casillaElegida[0], casillaElegida[1]);
        }

    }

    public void guardar(Partida partida, String filename) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(partida, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Partida cargar(String filename) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filename)) {
            return gson.fromJson(reader, Partida.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
