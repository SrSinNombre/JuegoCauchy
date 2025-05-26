package EstructurasDeDatos.grafos;

import EstructurasDeDatos.Iterador;
import EstructurasDeDatos.diccionario.Diccionario;
import EstructurasDeDatos.diccionario.DiccionarioBasico;
import EstructurasDeDatos.lista.ListaBasica;

public class GrafoPonderado<T> {
    private Vertice<T> primerVertice;
    private DiccionarioBasico<ListaBasica<Vertice<T>>, Integer> aristasTotales;

    public GrafoPonderado(Vertice<T> primerVertice){
        this.primerVertice = primerVertice;
        aristasTotales = new DiccionarioBasico<>();
    }
    public Vertice<T> getPrimerVertice() {
        return primerVertice;
    }
    public void setPrimerVertice(Vertice<T> primerVertice) {
        this.primerVertice = primerVertice;
    }
    public DiccionarioBasico<ListaBasica<Vertice<T>>, Integer> getAristasTotales() {
        return aristasTotales;
    }

    public boolean addArista(Vertice<T> v1, Vertice<T> v2, int pesoArista){
        ListaBasica<Vertice<T>> parejaVertices = new ListaBasica<>(2);
        parejaVertices.add(v1);
        parejaVertices.add(v2);
        if(aristasTotales.getNumElementos() == 0) {
            aristasTotales.agregar(parejaVertices, pesoArista);
            v2.verticesUnidos.add(v1);
            v1.verticesUnidos.add(v2);
            return true;
        }
        if(aristasTotales.getCabeza().getClave().equals(parejaVertices)) return false; //entre dos vértices solo hay una arista
        Iterador<Diccionario<ListaBasica<Vertice<T>>, Integer>> it = aristasTotales.getIterador();
        while(it.hasNext()){
            if(it.next().getClave().equals(parejaVertices)) return false;
        }

        v2.verticesUnidos.add(v1);
        v1.verticesUnidos.add(v2);
        aristasTotales.agregar(parejaVertices, pesoArista);
        return true;
    }
    public void deleteArista(Arista<T> arista){
        ListaBasica<Vertice<T>> parejaVertices = new ListaBasica<>(2);
        parejaVertices.add(arista.origen);
        parejaVertices.add(arista.destino);
        aristasTotales.delete(parejaVertices);
        arista.origen.verticesUnidos.delete(arista.destino);
        arista.destino.verticesUnidos.delete(arista.origen);
    }

    public ListaBasica<Vertice<T>> recorrerEnProfundidad(){
        ListaBasica<Vertice<T>> lista = new ListaBasica<>(1);
        recorrerEnProfundidadRec(primerVertice, lista);
        return lista;
    }
    private void recorrerEnProfundidadRec(Vertice<T> vertice, ListaBasica<Vertice<T>> lista){
        lista.add(vertice);
        Iterador<Vertice<T>> it = vertice.verticesUnidos.getIterador();
        while(it.hasNext()){
            if(!lista.contains(it.next())){
                recorrerEnProfundidadRec(it.next(), lista);
            }
        }
    }
    public ListaBasica<Arista<T>> getAristasMenorPeso(){
        Iterador<Diccionario<ListaBasica<Vertice<T>>, Integer>> it = aristasTotales.getIterador();
        ListaBasica<Arista<T>> lista = new ListaBasica<>(1);
        int menorPeso = aristasTotales.getCabeza().getValor();
        while(it.hasNext()){
            ListaBasica<Vertice<T>> parVertices = it.next().getClave();
            if(aristasTotales.get(parVertices) <= menorPeso) {
                menorPeso = aristasTotales.get(parVertices);
                if(aristasTotales.get(parVertices) == menorPeso) lista.add(new Arista<>(parVertices.get(0), parVertices.get(1), menorPeso));

            }
        }
        return lista;
    }
}
