package InicioPartida;
import Unidades.*;
import Tablero.*;
import EstructurasDeDatos.lista.*;

public class InicioPartida {
    private Tablero tableroPartida;
    private int T;

    public InicioPartida(Tablero tableroPartida, int T) {
        this.tableroPartida = tableroPartida;
        this.T = T;
    }
    public void setTableroPartida(int largo, int alto){
        tableroPartida = new Tablero(largo, alto);
    }

    public void Iniciar() {
        ListaBasica<Unidades> listaCiencias = new ListaBasica<>(5);
        ListaBasica<Unidades> listaLetras = new ListaBasica<>(5);

        Ciencias ciencias = new Ciencias();
        Letras letras = new Letras();

        listaCiencias.add(ciencias.getQuimico());
        listaCiencias.add(ciencias.getBiologo());
        listaCiencias.add(ciencias.getMatematico());
        listaCiencias.add(ciencias.getFisico());
        listaCiencias.add(ciencias.getIngeniero());

        listaLetras.add(letras.getHistoriador());
        listaLetras.add(letras.getFilologo());
        listaLetras.add(letras.getTeologo());
        listaLetras.add(letras.getTraductor());
        listaLetras.add(letras.getFilosofo());

        int maxX = tableroPartida.getLargo() -1;
        int maxY = tableroPartida.getAlto() -1;

        colocarUnidad(listaCiencias.random(), 0, 0);
        colocarUnidad(listaCiencias.random(), maxX, 0);
        colocarUnidad(listaLetras.random(), 0, maxY);
        colocarUnidad(listaLetras.random(), maxX, maxY);
    }

    public boolean colocarUnidad(Unidades unidad, int x, int y){
        if(tableroPartida.tablero[x][y] == null) {
            tableroPartida.tablero[x][y] = unidad;
            return true;
        }
        else return false;
    }
    public boolean generarYColocarUnidad(ListaBasica<Unidades> listaUnidades) {
        Unidades unidad = listaUnidades.random();
        int x = Math.round((float) Math.random() * tableroPartida.getLargo());
        int y = Math.round((float) Math.random() * tableroPartida.getAlto());

        return colocarUnidad(unidad, x, y);
    }
}

