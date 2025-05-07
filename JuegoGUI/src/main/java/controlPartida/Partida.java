package controlPartida;

import EstructurasDeDatos.Lista;
import EstructurasDeDatos.lista.ListaBasica;
import Unidades.*;

public class Partida {
    private int turno;
    private int tableroAncho;
    private int tableroAlto;
    private Unidades[][] tablero;
    private boolean finPartida;

    public Partida(int tableroAncho, int tableroAlto, boolean jugadorEsDeCiencias){
        this.tableroAncho = tableroAncho;
        this.tableroAlto = tableroAlto;

        if(jugadorEsDeCiencias) turno = 0;
        else turno = 1;

        tablero = new Unidades[tableroAncho][tableroAlto];
        finPartida = false;
    }

    public int getTurno(){
        return turno;
    }
    public void setTurno(int turno){
        this.turno = turno;
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
            return true;
        }else return false;
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
            tablero[0][0] = c1;
            tablero[0][tableroAlto-1] = c2;
            tablero[tableroAncho-1][0] = l1;
            tablero[tableroAncho-1][tableroAlto-1] = l2;
        }else if(turno == 1){
            tablero[0][0] = l1;
            tablero[0][tableroAlto-1] = l2;
            tablero[tableroAncho-1][0] = c1;
            tablero[tableroAncho-1][tableroAlto-1] = c2;
        }
    }

}
