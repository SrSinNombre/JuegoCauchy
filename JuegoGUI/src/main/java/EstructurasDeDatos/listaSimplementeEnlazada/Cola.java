package EstructurasDeDatos.listaSimplementeEnlazada;

public class Cola<T> extends ListaSE<T>{
    private Elemento<T> cabeza;

    public Cola(){
        super();
    }

    public void enqueue(T elemento){
        add(elemento);
    }
    public T dequeue(){
        T dato = cabeza.getDato();
        Elemento<T> temp = cabeza;
        cabeza = temp.getSiguiente();
        return dato;
    }
    public boolean isEmpty(){
        return cabeza == null;
    }
}
