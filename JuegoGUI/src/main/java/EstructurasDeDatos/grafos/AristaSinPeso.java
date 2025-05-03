package EstructurasDeDatos.grafos;

public class AristaSinPeso<E> {
    protected Vertice<E> origen;
    protected Vertice<E> destino;

    public AristaSinPeso(Vertice<E> origen, Vertice<E> destino){
        this.origen = origen;
        this.destino = destino;
    }
}
