package EstructurasDeDatos.diccionario;

public class Diccionario<K, V> {
    private K clave;
    private V valor;
    private Diccionario<K, V> siguiente;
    private Diccionario<K, V> anterior;

    public Diccionario(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public K getClave() {
        return clave;
    }

    public void setClave(K clave) {
        this.clave = clave;
    }

    public V getValor() {
        return valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }

    public Diccionario<K, V> getSiguiente(){
        return siguiente;
    }

    public Diccionario<K, V> getAnterior() {
        return anterior;
    }
}
