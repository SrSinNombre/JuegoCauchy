package Tablero;
import Unidades.*;
import Excepciones.*;

public class Tablero {
    private int largo;
    private int alto;
    private Unidades[][] tablero;

    public Tablero(int largo, int alto){
        this.alto = alto;
        this.largo = largo;
        tablero = new Unidades[largo][alto];
    }

    public int getAlto() {
        return alto;
    }
    public void setAlto(int alto) {
        this.alto = alto;
    }
    public int getLargo() {
        return largo;
    }
    public void setLargo(int largo) {
        this.largo = largo;
    }

    public boolean colocarUnidad(Unidades u, int x, int y) throws FueraDelTableroException{
        if(fueraDelTablero(x, y)) throw new FueraDelTableroException("Te sales del tablero");
        if(tablero[x][y] != null) return false;
        tablero[x][y] = u;
        return true;
    }
    public boolean fueraDelTablero(int x, int y){
        return x < 0 || y < 0 || x > largo || y > alto;
    }
}
