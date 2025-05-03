package EstructurasDeDatos.grafos;

public interface Grafo<T> {
    void addArista(Vertice<T> v1, Vertice<T> v2);
    void remove(Vertice<T> v);
    boolean hayCiclos();

}
