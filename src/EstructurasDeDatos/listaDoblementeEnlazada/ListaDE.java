package EstructurasDeDatos.listaDoblementeEnlazada;
import EstructurasDeDatos.*;
import EstructurasDeDatos.listaSimplementeEnlazada.ListaSE;

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
    public ListaSE<T> convertToListaSE(){
        return new ListaSE<>(cabeza);
    }
    @Override
    public int getNumElementos(){
        return convertToListaSE().getNumElementos();
    }

    @Override
    public Iterador<T> getIterador() {
        return new IteradorListaDE<>(cabeza);
    }
    @Override
    public boolean add(T valor) {
        /** equivalente a añadir al final**/
        if(estaVacia()){
            cabeza = cola = new ElementoDoble<>(valor);
        }else{
            ElementoDoble<T> siguiente = cola.getSiguiente();
            siguiente = new ElementoDoble<>(valor);
            cola = siguiente;
        }
        return true;
    }

    public boolean estaVacia(){
        return cabeza == null;
    }
    public void deleteCabeza(){
        cabeza = cabeza.getSiguiente();
        ElementoDoble<T> anterior = cabeza.getAnterior();
        anterior = null;
    }
    public void deleteCola(){
        cola = cola.getAnterior();
        ElementoDoble<T> siguiente = cola.getSiguiente();
        siguiente = null;
    }
    @Override
    public boolean delete(T elemento) {
        if(!estaVacia()){
            if (elemento == cola.getDato()) {
                deleteCola();
            } else if (elemento == cabeza.getDato()) {
                deleteCabeza();
            }
            ElementoDoble<T> e = new ElementoDoble<>(elemento);
            ElementoDoble<T> actual = cabeza.getSiguiente();
            while(actual != e){
                actual = actual.getSiguiente();
                if(actual == cola){
                    System.out.print("El elemento no está en la lista");
                    return false;
                }
            } //busca el elemento a eliminar
            ElementoDoble<T> siguiente = actual.getSiguiente();
            while(siguiente.getAnterior() /*otra forma de llamar a actual*/ != cola){
                ElementoDoble<T> anterior = siguiente.getAnterior();
                anterior = siguiente;
                siguiente = siguiente.getSiguiente(); //en el primer bucle actual ya está sobrescrito, es decir, borrado
            }
            deleteCola();
            return true;
        }
        else{
            System.out.println("La lista esta vacía");
            return estaVacia();
        }
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
}

