package EstructurasDeDatos.lista;
import EstructurasDeDatos.*;

public class ListaBasica<T> implements Lista<T> {

    T[] array;
    int numElementos;
    int maxElementos; //numElementos <= maxElementos SIEMPRE

    public ListaBasica(int maxElementos) {
        this.maxElementos = maxElementos;
        numElementos = 0;
        array = (T[]) new Object[numElementos];
    }
    @Override
    public int getNumElementos(){
        return numElementos;
    }
    @Override
    public boolean add(T elemento){
        aumentarT(); //añade el elemento al final de la lista
        array[numElementos] = elemento;
        return true;
    }

    @Override
    public boolean delete(T elemento) {
        T cabeza = array[0];
        for(int i = 1; cabeza != elemento; i++) {
            cabeza = array[i];
            if (i == numElementos) {
                System.out.println("El elemento no está en la lista");
                return false;
            }
        }
        cabeza = null;
        for (int j = numElementos - 1; array[j] == null; j--){
            array[j-1] = array[j];
        }
        numElementos -= 1;
        return true;
    }
    @Override
    public Iterador<T> getIterador() {
        return new IteradorListaBasica<>();
    }

    public void aumentarT(){
        if(numElementos == maxElementos){
            maxElementos *= 2;
        }
    }
    public boolean estaVacia(){
        return numElementos == 0;
    }
    public ListaBasica<T> reverse(){
        ListaBasica<T> array_aux = new ListaBasica<>(maxElementos);
        for(int i = numElementos - 1; i >= 0; i--){
            array_aux.add(array[i]);
        }
        return array_aux;
    }
    public Object buscar(T elemento){
        IteradorListaBasica<T> it = new IteradorListaBasica<>();
        while(it.hasNext() && array[it.contador] != elemento){
            it.next();
        }
        if(!it.hasNext()){
            System.out.println("El elemento no está en la lista");
            return null;
        }else{
            return it.contador;
        }
    }
    public void sumar(ListaBasica<T> otraLista){
        while(maxElementos < numElementos + otraLista.numElementos){
            aumentarT();
        }
        IteradorListaBasica<T> it = new IteradorListaBasica<>();
        for(int i = 0; i < otraLista.numElementos; i++){
            add(otraLista.array[i]);
        }
    }
    public boolean setElemento(int indice, T elemento){
        if(indice >= numElementos){
            System.out.println("El índice no es válido.");
            return false;
        }else{
            array[indice] = elemento;
            return true;
        }
    }
    public void removeLast(){
        array[numElementos-1] = null;
    }
}

