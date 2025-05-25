package EstructurasDeDatos.grafos;

public class Arista<T> {
    protected Vertice<T> origen;
    protected Vertice<T> destino;
    protected int peso;

    public Arista(Vertice<T> origen, Vertice<T> destino, int peso){
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public Vertice<T> getDestino() {
        return destino;
    }
    public void setDestino(Vertice<T> destino) {
        this.destino = destino;
    }
    public Vertice<T> getOrigen() {
        return origen;
    }
    public void setOrigen(Vertice<T> origen) {
        this.origen = origen;
    }
}
