package EstructurasDeDatos.grafos;

import EstructurasDeDatos.Iterador;
import EstructurasDeDatos.Lista;
import EstructurasDeDatos.lista.ListaBasica;


public class GrafoNoPonderado<T> {
    private Vertice<T> primerVertice;
    private final Lista<Vertice<T>> verticesTotales = new ListaBasica<>(1);

    public GrafoNoPonderado(Vertice<T> primerVertice){
        this.primerVertice = primerVertice;
        verticesTotales.add(primerVertice);
    }
    public Vertice<T> getPrimerVertice() {
        return primerVertice;
    }
    public void setPrimerVertice(Vertice<T> primerVertice) {
        this.primerVertice = primerVertice;
    }

    public void addArista(Vertice<T> v1, Vertice<T> v2){
        v1.verticesUnidos.add(v2);
        v2.verticesUnidos.add(v1);
    }
    public void deleteArista(Vertice<T> origenArista, Vertice<T> destinoArista){
        origenArista.verticesUnidos.delete(destinoArista);
        destinoArista.verticesUnidos.delete(origenArista);
    }

    public Lista<Vertice<T>> recorrerEnProfundidad(){
        Lista<Vertice<T>> lista = new ListaBasica<>(1);
        recorrerEnProfundidadRec(primerVertice, lista);
        return lista;
    }
    private void recorrerEnProfundidadRec(Vertice<T> v, Lista<Vertice<T>> lista){
        lista.add(v);
        Iterador<Vertice<T>> it = v.verticesUnidos.getIterador();
        while(it.hasNext()){
            if(!lista.contains(it.next())){
                recorrerEnProfundidadRec(it.next(), lista);
            }
        }
    }
}
