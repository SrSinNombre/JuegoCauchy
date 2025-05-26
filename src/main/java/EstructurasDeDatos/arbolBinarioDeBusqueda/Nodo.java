package EstructurasDeDatos.arbolBinarioDeBusqueda;

public class Nodo<T> {
    private T dato;
    protected Nodo<T> izquierdo;
    protected Nodo<T> derecho;

    Nodo(T dato) {
        this.dato = dato;
        izquierdo = derecho = null;
    }
    public T getDato(){
        return dato;
    }
    public void setDato(T dato){
        this.dato = dato;
    }
    public Nodo<T> getDerecho() {
        return derecho;
    }
    public Nodo<T> getIzquierdo() {
        return izquierdo;
    }
    public void setDerecho(Nodo<T> derecho) {
        this.derecho = derecho;
    }
    public void setIzquierdo(Nodo<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public int obtenerGrado(){
        int grado = 0;
        if(izquierdo != null){
            grado++;
        }
        if(derecho != null){
            grado++;
        }
        return grado;
    }
    public boolean esHoja(){
        return izquierdo == null && derecho == null;
    }
}
