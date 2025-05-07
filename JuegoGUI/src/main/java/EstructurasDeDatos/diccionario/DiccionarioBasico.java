package EstructurasDeDatos.diccionario;
import EstructurasDeDatos.*;
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
        lista.add(new Diccionario<>(clave, valor));
        return true;
    }

    public V get(K clave) {
        Diccionario<K, V> elemento = lista.getCabeza().getDato();
        if(!hasKey(clave)){
            System.out.println("No se encontró la clave");
            return null;
        }
        while (elemento.getClave() != clave) {
            elemento = elemento.getSiguiente();
        }
        return elemento.getValor();
    }

    public boolean delete(K clave){
        if(lista.getCabeza() == null){
            System.out.println("El diccionario está vacío");
            return false;
        }
        Diccionario<K, V> elemento = lista.getCabeza().getDato();
        while(elemento.getClave() != clave){
            elemento = elemento.getSiguiente();
        }
        lista.delete(new Diccionario<>(clave, elemento.getValor()));
        return true;
    }
    public boolean hasKey(K clave){
        Diccionario<K, V> actual = lista.getCabeza().getDato();
        while(actual.getClave() != clave){
            actual = actual.getSiguiente();
            if(actual.getSiguiente() == lista.getCola().getDato()){
                return false;
            }
        }
        return true;
    }
    public Iterador<K> getIterador(){
        return new IteradorDiccionario<>(lista.getCabeza().getDato());
    }
}

