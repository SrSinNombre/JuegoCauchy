package EstructurasDeDatos.listaDoblementeEnlazada;

public class ElementoDoble<T> {
    private T dato;
    private ElementoDoble<T> anterior;
    private ElementoDoble<T> siguiente;

    public ElementoDoble(T dato){
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }
    public T getDato(){
        return dato;
    }
    public ElementoDoble<T> getSiguiente(){
        return siguiente;
    }
    public ElementoDoble<T> getAnterior(){
        return anterior;
    }
    public void setDato(T dato) {
        this.dato = dato;
    }

    public void setSiguiente(ElementoDoble<T> siguiente) {
        this.siguiente = siguiente;
    }
    public void setAnterior(ElementoDoble<T> anterior) {
        this.anterior = anterior;
    }
}
