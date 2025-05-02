package EstructurasDeDatos.listaSimplementeEnlazada;
import EstructurasDeDatos.*;

public class IteradorListaSE<T> implements Iterador<T>{
    Elemento<T> puntero;
    ListaSE<T> lista;
    Elemento<T> output; // almacena la salida de next()

    public IteradorListaSE(Elemento<T> cabeza){
        this.puntero = cabeza;
        this.output = null;
    }

    @Override
    public boolean hasNext(){
        return puntero.getSiguiente() != null;
    }
    @Override
    public T next(){
        if(!hasNext()) {
            System.out.println("No hay más elementos en la lista");
            return null;
        }else{
            output = puntero.getSiguiente(); //siguiente nodo
            puntero = puntero.getSiguiente(); //actualiza el puntero
            return output.getDato(); //devuelve el dato de output
        }
    }
    @Override
    public void delete(){ // elimina el último nodo retornado por next()
        if(output == null){
            System.out.println("No se ha invocado el método next() anteriormente");
        }else{
            Elemento<T> anterior = lista.getCabeza();
            while(anterior != null && anterior.getSiguiente() != output){
                anterior = anterior.getSiguiente();
            }
            if(anterior != null){ //en realidad sobra pero me garantiza que anterior sea no nulo
                Elemento<T> s = anterior.getSiguiente();
                s = output.getSiguiente(); //sustituye el elemento de después de output por el anterior
                output = null; //elimina el elemento en cuestión
            }
        }
    }
}