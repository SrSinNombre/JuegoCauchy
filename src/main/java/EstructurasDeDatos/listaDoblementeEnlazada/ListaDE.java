package EstructurasDeDatos.listaDoblementeEnlazada;
import EstructurasDeDatos.*;

public class ListaDE<T> implements Lista<T> {
    private ElementoDoble<T> cabeza;
    private ElementoDoble<T> cola;

    public ListaDE(){
        cabeza = null;
        cola = null;
    }
    public ElementoDoble<T> getCabeza(){
        return cabeza;
    }
    public ElementoDoble<T> getCola(){
        return cola;
    }
    @Override
    public int getNumElementos(){
        int cont = 0;
        if(cabeza == null) return 0;
        ElementoDoble<T> actual = cabeza;
        while(actual != null){
            actual = actual.getSiguiente();
            cont++;
        }
        return cont;
    }

    @Override
    public Iterador<T> getIterador() {
        return new IteradorListaDE<>(cabeza);
    }
    @Override
    public boolean add(T valor) {
        /** equivalente a añadir al final**/
        ElementoDoble<T> nuevoElemento = new ElementoDoble<>(valor);
        if(estaVacia()){
            cabeza = cola = nuevoElemento;
        }else{
            cola.setSiguiente(nuevoElemento);
            nuevoElemento.setAnterior(cola);
            cola = nuevoElemento;
        }
        return true;
    }

    public boolean estaVacia(){
        return cabeza == null;
    }
    public void deleteCabeza(){
        cabeza = cabeza.getSiguiente();
        cabeza.setAnterior(null);
    }
    public void deleteCola(){
        cola = cola.getAnterior();
        cola.setSiguiente(null);
    }
    @Override
    public boolean delete(T elemento) {
        if (estaVacia()) {
            System.out.println("La lista está vacía");
            return false;
        }
        ElementoDoble<T> actual = cabeza;
        while (actual != null) {
            if (actual.getDato().equals(elemento)) {
                // Caso: es la cabeza
                if (actual == cabeza) {
                    deleteCabeza();
                }
                // Caso: es la cola
                else if (actual == cola) {
                    deleteCola();
                }
                // Caso general
                else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }
                return true;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("El elemento no está en la lista");
        return false;
    }

    public void imprimir(){
        ElementoDoble<T> actual = cabeza;
        while(actual != cola){
            System.out.print(actual.getDato() + " <-> ");
            actual = actual.getSiguiente();
        }
        System.out.print(actual.getDato());
    }
    public void reverse(){
        ElementoDoble<T> aux = cabeza;
        cabeza = cola;
        cola = aux;
    }
    @Override
    public boolean contains(T elemento){
        if(elemento == cabeza.getDato() || elemento == cola.getDato()) return true;
        Iterador<T> it = getIterador();
        while(it.next() != cola){
            if(it.next() == elemento) return true;
        }
        return false;
    }
}

