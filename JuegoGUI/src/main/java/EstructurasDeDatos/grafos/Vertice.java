package EstructurasDeDatos.grafos;
import EstructurasDeDatos.lista.ListaBasica;

public class Vertice<T> {
    protected T valor;
    protected ListaBasica<Vertice<T>> verticesUnidos;

    public Vertice(T valor){
        this.valor = valor;
        verticesUnidos = new ListaBasica<>(1);
    }

    public int getGrado(){
        return verticesUnidos.getNumElementos();
    }
    public T getValor(){
        return valor;
    }
}
