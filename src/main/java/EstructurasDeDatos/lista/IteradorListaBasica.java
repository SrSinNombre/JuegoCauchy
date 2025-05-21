package EstructurasDeDatos.lista;
import EstructurasDeDatos.*;

public class IteradorListaBasica<T> implements Iterador<T> {
    protected ListaBasica<T> lista;
    protected int contador;

    public IteradorListaBasica(ListaBasica<T> lista){
        this.contador = 0;
        this.lista = lista;
    }
    @Override
    public boolean hasNext(){
        return contador < lista.getNumElementos() - 1;
    }
    @Override
    public T next() {
        try {
            T siguiente = lista.array[contador+1];
            contador += 1;
            return siguiente;
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }
    @Override
    public void delete(){ //elimina el último elemento retornado por next()
        int i = contador;
        while (i < lista.getNumElementos() - 1) {
            lista.array[i] = lista.array[i+1];
            i++;
        }
        lista.setNumElementos(lista.getNumElementos()-1);
        contador -= 1;
    }
}