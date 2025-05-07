package controlPartida;

import EstructurasDeDatos.Iterador;
import EstructurasDeDatos.diccionario.Diccionario;
import EstructurasDeDatos.diccionario.DiccionarioBasico;
import EstructurasDeDatos.lista.ListaBasica;
import Unidades.*;

public class Partida {
    private int turno;
    private int tableroAncho;
    private int tableroAlto;
    private Unidades[][] tablero;
    private DiccionarioBasico<Unidades, int[]> listaUnidades = new DiccionarioBasico<>();

    public Partida(int tableroAncho, int tableroAlto, boolean jugadorEsDeCiencias){
        this.tableroAncho = tableroAncho;
        this.tableroAlto = tableroAlto;

        if(jugadorEsDeCiencias) turno = 0;
        else turno = 1;

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

    public ListaBasica<Unidades> getLista(boolean esDeCiencias){
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

    public boolean colocarUnidad(Unidades u, int x, int y){
        if(tablero[x][y] == null){
            tablero[x][y] = u;
            int[] casilla = new int[]{x, y};
            listaUnidades.agregar(u, casilla);
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
        return null;
    }
    public int[] buscarUnidad(Unidades u){
        return listaUnidades.get(u);
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
        tablero[x][y] = u;
        tablero[uPosInicial[0]][uPosInicial[1]] = null;
        return true;
    }
    public boolean puedeAtacarA(Unidades atacante, Unidades atacado){
        int[] posAtacante = buscarUnidad(atacante);
        int[] posAtacado = buscarUnidad(atacado);
        if(Math.abs(posAtacante[0] - posAtacado[0]) > atacante.getRango_ataque()) return false;
        if(Math.abs(posAtacante[1] - posAtacado[1]) > atacante.getRango_ataque()) return false;

        return true;
    }
    public boolean atacar(Unidades atacante, Unidades atacado){
        if(!puedeAtacarA(atacante, atacado)) return false;
        double factorAleatorio = Math.random() * 2;
        double danoInfligido = factorAleatorio*atacante.getAtaque() - atacado.getDefensa();
        atacado.subirHP(-danoInfligido);
        if(atacado.isUnidadMuerta()){
            int[] atacadoPos = buscarUnidad(atacado);
            tablero[atacadoPos[0]][atacadoPos[1]] = null;
            listaUnidades.delete(atacado);
        }
        return true;
    }
    public boolean generarUnidadRandom(boolean esDeCiencias){
        ListaBasica<Unidades> lista = getLista(esDeCiencias);
        Unidades u = lista.random();
        int randX = Math.round((float) Math.random()*(tableroAncho-1));
        int randY = Math.round((float) Math.random()*(tableroAlto-1));

        return colocarUnidad(u, randX, randY);
    }

    public void iniciarPartida(){
        Unidades c1 = getLista(true).random();
        Unidades c2 = getLista(true).random();
        Unidades l1 = getLista(false).random();
        Unidades l2 = getLista(false).random();
        if(turno == 0){
            colocarUnidad(c1, 0, 0);
            colocarUnidad(c2, 0, tableroAlto-1);
            colocarUnidad(l1, tableroAncho-1, 0);
            colocarUnidad(l2, tableroAncho-1, tableroAlto-1);
        }else if(turno == 1){
            colocarUnidad(l1, 0, 0);
            colocarUnidad(l2, 0, tableroAlto-1);
            colocarUnidad(c1, tableroAncho-1, 0);
            colocarUnidad(c2, tableroAncho-1, tableroAlto-1);
        }
    }
    public boolean finPartida(){
        Diccionario<Unidades, int[]> cabeza = listaUnidades.getCabeza();
        Iterador<Unidades> it = listaUnidades.getIterador();
        if(it.next().isDeCiencias() != cabeza.getClave().isDeCiencias()) return false;
        while(it.hasNext()){
            if(it.next().isDeCiencias() != cabeza.getClave().isDeCiencias()) return false;
        }
        return true;
    }

    public void transcursoPartida(){ //esto iría en el controlador
        while(!finPartida()){
            iniciarPartida();
            if(turno % 2 == 0){ //turno del jugador de ciencias

                if(turno % 10 == 0) {
                    while(!generarUnidadRandom(true)) generarUnidadRandom(true);
                    while(!generarUnidadRandom(false)) generarUnidadRandom(false);
                }
                turno++;
            }else if(turno % 2 == 1){ //turno del jugador de letras

                turno++;
            }
        }
    }

}
