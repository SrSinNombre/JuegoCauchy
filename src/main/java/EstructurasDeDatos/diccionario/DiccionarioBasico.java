package EstructurasDeDatos.diccionario;

import EstructurasDeDatos.Iterador;
import EstructurasDeDatos.listaDoblementeEnlazada.ElementoDoble;
import EstructurasDeDatos.listaDoblementeEnlazada.IteradorListaDE;
import EstructurasDeDatos.listaDoblementeEnlazada.ListaDE;

public class DiccionarioBasico<K, V> {
    private ListaDE<Diccionario<K, V>> lista;

    public DiccionarioBasico() {
        lista = new ListaDE<>();
    }

    public Diccionario<K, V> getCabeza(){
        return lista.getCabeza().getDato();
    }
    public boolean agregar(K clave, V valor) {
        if (hasKey(clave)) return false;
        lista.add(new Diccionario<>(clave, valor));
        return true;
    }

    public V get(K clave) {
        ElementoDoble<Diccionario<K, V>> actual = lista.getCabeza();
        while (actual != null) {
            Diccionario<K, V> dic = actual.getDato();
            if (dic.getClave().equals(clave)) return dic.getValor();
            actual = actual.getSiguiente();
        }
        return null;
    }

    public boolean delete(K clave) {
        ElementoDoble<Diccionario<K, V>> actual = lista.getCabeza();
        while (actual != null) {
            if (actual.getDato().getClave().equals(clave)) {
                lista.delete(actual.getDato());
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public boolean hasKey(K clave) {
        ElementoDoble<Diccionario<K, V>> actual = lista.getCabeza();
        while (actual != null) {
            if (actual.getDato().getClave().equals(clave)) return true;
            actual = actual.getSiguiente();
        }
        return false;
    }
    public Iterador<Diccionario<K, V>> getIterador(){
        return new IteradorListaDE<>(lista.getCabeza());
    }

    public K getClaveIndice(int index){
        if(index == 0) return getCabeza().getClave();
        Iterador<Diccionario<K, V>> it = getIterador();
        int cont = 1;
        while(it.hasNext()){
            K clave = it.next().getClave();
            if(cont == index) return clave;
            cont++;
        }
        return null;
    }
    public int getNumElementos(){
        return lista.getNumElementos();
    }
    public K buscar(V valor){
        Iterador<Diccionario<K, V>> it = getIterador();
        if(lista.getCabeza().getDato().getValor().equals(valor)) return lista.getCabeza().getDato().getClave();
        while(it.hasNext()){
            Diccionario<K, V> elemento = it.next();
            if(elemento.getValor().equals(valor)) return elemento.getClave();
        }
        return null;
    }
}
