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
}
