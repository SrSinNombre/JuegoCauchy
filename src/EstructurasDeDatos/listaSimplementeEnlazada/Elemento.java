package EstructurasDeDatos.listaSimplementeEnlazada;

public class Elemento<T> {
    private T dato;
    private Elemento<T> siguiente;

    public Elemento(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }
    public Elemento<T> getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Elemento<T> siguiente) {
        this.siguiente = siguiente;
    }
}

