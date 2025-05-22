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
        if(!estaVacia()){
            if (elemento == cola.getDato()) deleteCola();
            else if (elemento == cabeza.getDato()) deleteCabeza();

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
                siguiente.setAnterior(siguiente);
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

