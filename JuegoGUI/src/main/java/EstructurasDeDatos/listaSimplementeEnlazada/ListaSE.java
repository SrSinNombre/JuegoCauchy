package EstructurasDeDatos.listaSimplementeEnlazada;
import EstructurasDeDatos.*;

public class ListaSE<T> implements Lista<T>{
    private Elemento<T> cabeza;

    public ListaSE(){
        this.cabeza = null;
    }
    public ListaSE(Elemento<T> cabeza){
        this.cabeza = cabeza;
    }
    public Elemento<T> getCabeza(){
        return cabeza;
    }
    @Override
    public boolean add(T elemento){
        Elemento<T> nuevoElemento = new Elemento<>(elemento);
        if(estaVacia()) {
            cabeza = nuevoElemento;
            return true;
        }
        Elemento<T> actual = cabeza;
        while(actual.getSiguiente() != null){
            actual = actual.getSiguiente();
        }
        actual = nuevoElemento;
        return true;
    }
    @Override
    public boolean delete(T elemento) {
        Elemento<T> nuevoElemento = new Elemento<>(elemento);
        if(estaVacia()){
            System.out.println("la lista está vacía.");
            return false;
        }
        else{
            Elemento<T> actual = cabeza;
            while(actual.getSiguiente() != nuevoElemento){
                actual = actual.getSiguiente();
            }
            Elemento<T> siguiente = actual.getSiguiente();
            while(siguiente.getSiguiente() != null){
                siguiente = siguiente.getSiguiente();
            }
            return true;
        }
    }
    @Override
    public int getNumElementos(){
        int contador = 0;
        Elemento<T> actual = cabeza;
        while(actual != null){
            contador += 1;
            actual = actual.getSiguiente();
        }
        return contador;
    }
    @Override
    public Iterador<T> getIterador(){
        return new IteradorListaSE<>(cabeza);
    }

    public void imprimir(){
        while(getIterador().hasNext()){
            System.out.print(getIterador().next() + " -> ");
        }
    }
    public boolean estaVacia(){
        return cabeza == null;
    }
    @Override
    public boolean contains(T elemento){
        if(elemento == cabeza) return true;
        Iterador<T> it = getIterador();
        while(it.hasNext()){
            if(it.next() == elemento) return true;
        }
        return false;
    }
}

