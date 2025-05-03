package EstructurasDeDatos.lista;
import EstructurasDeDatos.*;

public class ListaBasica<T> implements Lista<T> {

    T[] array;
    int numElementos;
    int maxElementos; //numElementos <= maxElementos SIEMPRE

    public ListaBasica(int maxElementos) {
        this.maxElementos = maxElementos;
        numElementos = 0;
        array = (T[]) new Object[maxElementos];
    }
    @Override
    public int getNumElementos(){
        return numElementos;
    }
    @Override
    public boolean add(T elemento){
        aumentarT();
        array[numElementos] = elemento;
        numElementos++;
        return true;
    }

    @Override
    public boolean delete(T elemento) {
        int posicion = buscar(elemento);
        if(posicion == -1) return false;
        while(getIterador().hasNext()){
            array[posicion] = array[posicion+1];
        }
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
    public int buscar(T elemento){
        IteradorListaBasica<T> it = new IteradorListaBasica<>();
        while(it.hasNext() && array[it.contador] != elemento){
            it.next();
        }
        if(!it.hasNext()){
            System.out.println("El elemento no está en la lista");
            return -1;
        }else{
            return it.contador;
        }
    }
    public T get(int indice){
        if(indice == 0) return array[0];
        Iterador<T> it = getIterador();
        int cont = 1;
        T elemento = it.next();
        while(cont != indice){
            elemento = it.next();
            cont++;
        }
        return elemento;
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
    public boolean contains(T elemento){
        return buscar(elemento) != -1;
    }
    public T random(){
        float a = (float) Math.random();
        int n = Math.round(a*numElementos);
        return get(n);
    }
}

