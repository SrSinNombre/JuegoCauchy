package EstructurasDeDatos.listaSimplementeEnlazada;

public class Pila<T> extends ListaSE<T>{
    private Elemento<T> cabeza;

    public Pila() {
        super();
    }

    public void push(T elemento) {
        add(elemento);
    }

    public T pop() {
        if (estaVacia()) {
            System.out.println("La pila está vacía");
            return null;
        }
        Elemento<T> actual = cabeza;
        while(actual.getSiguiente() != null){
            actual = actual.getSiguiente();
        }
        T dato = actual.getDato();
        delete(actual.getDato());
        return dato;
    }
}