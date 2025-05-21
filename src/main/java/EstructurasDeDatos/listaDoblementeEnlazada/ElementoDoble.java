package EstructurasDeDatos.listaDoblementeEnlazada;
import EstructurasDeDatos.listaSimplementeEnlazada.Elemento;

public class ElementoDoble<T> extends Elemento<T> {
    private T dato;
    private ElementoDoble<T> anterior;
    private ElementoDoble<T> siguiente;

    public ElementoDoble(T dato){
        super(dato);
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }
    @Override
    public T getDato(){
        return dato;
    }
    @Override
    public ElementoDoble<T> getSiguiente(){
        return siguiente;
    }
    public ElementoDoble<T> getAnterior(){
        return anterior;
    }
    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }
    @Override
    public void setSiguiente(Elemento<T> siguiente) {
        super.setSiguiente(siguiente);
    }
    public void setAnterior(ElementoDoble<T> anterior) {
        this.anterior = anterior;
    }
}
