package EstructurasDeDatos.diccionario;

public class Diccionario<K, V> {
    private K clave;
    private V valor;

    public Diccionario(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public K getClave() {
        return clave;
    }

    public V getValor() {
        return valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Diccionario)) return false;
        Diccionario<?, ?> that = (Diccionario<?, ?>) o;
        return clave.equals(that.clave);
    }

    @Override
    public int hashCode() {
        return clave.hashCode();
    }
}

