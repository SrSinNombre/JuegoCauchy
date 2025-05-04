package Tablero;
import Unidades.*;

public class Tablero {
    private int largo;
    private int alto;
    public Unidades[][] tablero;

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

}
