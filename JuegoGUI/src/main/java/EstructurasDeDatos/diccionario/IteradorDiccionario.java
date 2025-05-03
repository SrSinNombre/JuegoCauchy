package EstructurasDeDatos.diccionario;
import EstructurasDeDatos.*;

public class IteradorDiccionario<K, V> implements Iterador<K> {
    private Diccionario<K, V> posicion;
    private Diccionario<K, V> output;

    public IteradorDiccionario(Diccionario<K, V> cabeza) {
        posicion = cabeza;
        output = null;
    }

    @Override
    public boolean hasNext() {
        return posicion.getSiguiente() != null;
    }

    @Override
    public K next() {
        if (!hasNext()) {
            System.out.println("No hay elementos en la lista");
            return null;
        }
        output = posicion.getSiguiente();
        return output.getClave();
    }

    @Override
    public void delete() {
        if(output == null){
            System.out.println("No se ha invocado el método next()");
        }else{
            Diccionario<K, V> posicion2 = posicion;
            Diccionario<K, V> anterior = posicion.getAnterior();
            anterior = null;
            while(posicion2.getSiguiente() != null){
                posicion2 = posicion2.getSiguiente();
            }
        }
    }
}
