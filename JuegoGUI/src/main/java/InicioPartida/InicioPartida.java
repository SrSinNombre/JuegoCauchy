package InicioPartida;
import Unidades.*;
import Tablero.*;

public class InicioPartida {
    private Tablero tablero;
    private int T;

    public InicioPartida(Tablero tablero, int T) {
        this.tablero = tablero;
        this.T = T;
    }

    public void Iniciar() {
        ListaBasica<Unidades> listaCiencias = new ListaBasica(5);
        ListaBasica<Unidades> listaLetras = new ListaBasica(5);

        Ciencias cienciasa = new Ciencias();
        Letras letras = new Letras();

        listaCiencias.add(ciencias.quimico);
        listaCiencias.add(ciencias.biologo);
        listaCiencias.add(ciencias.matematico);
        listaCiencias.add(ciencias.fisico);
        listaCiencias.add(ciencias.ingeniero);

        listaLetras.add(letras.historiador);
        listaLetras.add(letras.filologo);
        listaLetras.add(letras.teologo);
        listaletras.add(letras.tradutor);
        listaLetras.add(letras.filosofo);

        int maxX = tablero.getLargo() -1;
        int maxY = tablero.getAlto() -1;

        colocarUnidad(listaCiencias.random(), 0, 0);
        colocarUnidad(listaLetras.random(), maxX, 0);
        colocarUnidad(listaLetras.random(), 0, maxY);
        colocarUnidad(listaCiencias.random(), maxX, maxY);
    }

    public void colocarUnidad(Unidades unidad, int x, int y){
        if(tablero.getTablero()[x][y] == null) {
            tablero.getTablero()[x][y] = unidad;
        }
        else {
            System.out.println("Posición ya ocupada en (" + x + "," + y + ")");
        }
    }
    public void generarYColocarUnidad(ListaBasica<Unidades> listaUnidades) {
        Unidades unidad = listaUnidades.random();

        ListaBasica<Integer> numeros = new ListaBasica<>(10);
        for (int i = 0; i <= 9; i++) {
            numeros.add(i);
        }

        int x = numeros.random();
        int y = numeros.random();

        colocarUnidad(unidad, x, y);
    }
}

