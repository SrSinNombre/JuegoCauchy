package EstructurasDeDatos.grafos;

import EstructurasDeDatos.Iterador;
import EstructurasDeDatos.Lista;
import EstructurasDeDatos.lista.ListaBasica;


public class GrafoNoPonderado<T> {
    private Vertice<T> primerVertice;
    private final Lista<AristaSinPeso<T>> aristasTotales;
    private final Lista<Vertice<T>> verticesTotales;

    public GrafoNoPonderado(Vertice<T> primerVertice){
        this.primerVertice = primerVertice;
        verticesTotales = new ListaBasica<>(1);
        verticesTotales.add(primerVertice);
        aristasTotales = new ListaBasica<>(1);
    }
    public Vertice<T> getPrimerVertice() {
        return primerVertice;
    }
    public void setPrimerVertice(Vertice<T> primerVertice) {
        this.primerVertice = primerVertice;
    }

    public void addVertice(Vertice<T> v){
        verticesTotales.add(v);
    }
    public void addArista(Vertice<T> v1, Vertice<T> v2){
        v1.verticesUnidos.add(v2);
        v2.verticesUnidos.add(v1);
        aristasTotales.add(new AristaSinPeso<>(v1, v2));
    }
    public void deleteArista(AristaSinPeso<T> arista){
        aristasTotales.delete(arista);
        arista.origen.verticesUnidos.delete(arista.destino);
        arista.destino.verticesUnidos.delete(arista.origen);
    }

    public boolean hayCiclos(){

    }
    private boolean hayCiclosRec(Vertice<T> v1, Vertice<T> v2){
        Iterador<Vertice<T>> it = verticesTotales.getIterador();
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
