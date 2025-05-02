package EstructurasDeDatos.lista;
import EstructurasDeDatos.*;

public class IteradorListaBasica<T> implements Iterador<T> {
    T[] array;
    int numElementos;
    int contador;

    public IteradorListaBasica(){
        this.contador = 0;
    }
    @Override
    public boolean hasNext(){
        return contador < numElementos;
    }
    @Override
    public T next() {
        T siguiente = array[contador+1];
        contador += 1;
        return siguiente;
    }
    @Override
    public void delete(){ //elimina el último elemento retornado por next()
        int i = contador;
        while (i < numElementos - 1) {
            array[i] = array[i+1];
            i++;
        }
        numElementos -= 1;
        contador -= 1;
    }
}