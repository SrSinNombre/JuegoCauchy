package EstructurasDeDatos.lista;
import EstructurasDeDatos.*;

public class ListaBasica<T> implements Lista<T> {

    protected T[] array;
    private int numElementos;
    private int maxElementos; //numElementos <= maxElementos SIEMPRE

    public ListaBasica(int maxElementos) {
        this.maxElementos = maxElementos;
        numElementos = 0;
        array = (T[]) new Object[maxElementos];
    }
    @Override
    public int getNumElementos(){
        return numElementos;
    }
    public void setNumElementos(int numElementos){
        this.numElementos = numElementos;
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
        while(posicion < numElementos){
            array[posicion] = array[posicion+1];
            posicion++;
        }
        numElementos--;
        return true;
    }
    @Override
    public Iterador<T> getIterador() {
        return new IteradorListaBasica<>(this);
    }

    public void aumentarT(){
        if(numElementos == maxElementos){
            T[] nuevoArray =(T[]) new Object[maxElementos*2];
            System.arraycopy(array, 0, nuevoArray, 0, maxElementos);
            array = nuevoArray;
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
    public int buscar(T elemento) {
        Iterador<T> it = getIterador();
        if (array[0] == elemento) return 0;
        int cont = 1;
        while (it.hasNext()) {
            T e = it.next();
            if (e == elemento) return cont;
            cont++;
        }
        return -1;
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
        int n = Math.round(a*(numElementos-1));
        return get(n);
    }
}

