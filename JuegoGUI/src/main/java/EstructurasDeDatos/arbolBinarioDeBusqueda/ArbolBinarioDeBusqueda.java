package EstructurasDeDatos.arbolBinarioDeBusqueda;

import EstructurasDeDatos.lista.ListaBasica;
import EstructurasDeDatos.listaSimplementeEnlazada.*;

public class ArbolBinarioDeBusqueda<T extends Comparable<T>> {
    private Nodo<T> raiz;

    public ArbolBinarioDeBusqueda(){
        raiz = null;
    }
    public Nodo<T> getRaiz(){
        return raiz;
    }

    public int getAltura(){
        return getAlturaRec(raiz);
    }

    private int getAlturaRec(Nodo<T> nodo) {
        if (raiz == null) {
            return -1;
        }
        else if(nodo == null){
            return 0;
        }
        return Math.max(getAlturaRec(nodo.izquierdo), getAlturaRec(nodo.derecho)) + 1;
    }

    public ListaBasica<T> getListaDatosNivel(int nivel) {
        ListaBasica<T> resultado = new ListaBasica<>(1);
        if (raiz == null) return resultado;

        Cola<Nodo<T>> cola = new Cola<>();
        Cola<Integer> niveles = new Cola<>();

        cola.enqueue(raiz);
        niveles.enqueue(0);

        while (!cola.isEmpty()) {
            Nodo<T> actual = cola.dequeue();
            int nivelActual = niveles.dequeue();

            if (nivelActual == nivel) {
                resultado.add(actual.getDato());
            }
            if (actual.izquierdo != null) {
                cola.enqueue(actual.izquierdo);
                niveles.enqueue(nivelActual + 1);
            }
            if (actual.derecho != null) {
                cola.enqueue(actual.derecho);
                niveles.enqueue(nivelActual + 1);
            }

        }
        return resultado;
    }

    public ListaBasica<T> getCamino(T dato){
        ListaBasica<T> camino = new ListaBasica<>(1);
        getCaminoRec(raiz, dato, camino);
        return camino;
    }
    private boolean getCaminoRec(Nodo<T> nodo, T dato, ListaBasica<T> lista){
        if(nodo == null){
            return false;
        }

        lista.add(nodo.getDato());

        if(nodo.getDato() == dato){
            return true;
        }
        if(getCaminoRec(nodo.izquierdo, dato, lista)){
            return true;
        }
        if(getCaminoRec(nodo.derecho, dato, lista)){
            return true;
        }
        lista.removeLast();
        return false;
    }

    public boolean isArbolHomogeneo() {
        return verificarHomogeneidad(raiz, new int[]{-1}); // usamos array para pasar "por referencia"
    }

    // Recursión para verificar homogeneidad
    private boolean verificarHomogeneidad(Nodo<T> nodo, int[] gradoEsperado) {
        if (nodo == null) {
            return true;
        }

        int gradoActual = nodo.obtenerGrado();

        if (gradoActual > 0) { // solo evaluamos nodos que no son hojas
            if (gradoEsperado[0] == -1) {
                gradoEsperado[0] = gradoActual; // primer grado interno encontrado
            } else if (gradoActual != gradoEsperado[0]) {
                return false; // no coincide
            }
        }

        // Recursivamente evaluamos hijos
        return verificarHomogeneidad(nodo.izquierdo, gradoEsperado) &&
                verificarHomogeneidad(nodo.derecho, gradoEsperado);
    }

    public boolean isArbolCompleto() {
        if (raiz == null) return true;

        Cola<Nodo<T>> cola = new Cola<>();
        cola.enqueue(raiz);
        boolean encontradoNodoIncompleto = false;

        while (!cola.isEmpty()) {
            Nodo<T> actual = cola.dequeue();

            // Si tiene hijo izquierdo
            if (actual.izquierdo != null) {
                if (encontradoNodoIncompleto) return false;
                cola.enqueue(actual.izquierdo);
            } else {
                encontradoNodoIncompleto = true;
            }

            // Si tiene hijo derecho
            if (actual.derecho != null) {
                if (actual.izquierdo == null) return false;
                cola.enqueue(actual.derecho);
            } else {
                encontradoNodoIncompleto = true;
            }
        }

        return true;
    }

    public boolean isArbolCasiCompleto() {
        if (raiz == null) {
            return true;
        }

        Cola<Nodo<T>> cola = new Cola<>();
        Cola<Integer> niveles = new Cola<>();

        cola.enqueue(raiz);
        niveles.enqueue(0);

        int nivelHojaMin = -1;
        int nivelHojaMax = -1;
        boolean seTerminoLaZonaCompleta = false;

        while (!cola.isEmpty()) {
            Nodo<T> actual = cola.dequeue();
            int nivel = niveles.dequeue();


            if (actual.esHoja()) {
                if (nivelHojaMin == -1) nivelHojaMin = nivel;
                nivelHojaMax = nivel;

                // Si encontramos una hoja después de un hueco, no es contiguo
                if (seTerminoLaZonaCompleta) {
                    return false;
                }
            } else {
                // Caso en que falta hijo izquierdo: hueco detectado
                if (actual.izquierdo == null && actual.derecho != null) {
                    return false;
                }

                if (actual.izquierdo != null) {
                    cola.enqueue(actual.izquierdo);
                    niveles.enqueue(nivel + 1);
                } else {
                    seTerminoLaZonaCompleta = true;
                }

                if (actual.derecho != null) {
                    cola.enqueue(actual.derecho);
                    niveles.enqueue(nivel + 1);
                } else {
                    seTerminoLaZonaCompleta = true;
                }
            }
        }
        // Las hojas solo deben estar en como mucho 2 niveles, y esos deben ser consecutivos
        return (nivelHojaMax - nivelHojaMin <= 1);
    }


    public void add(T dato) {
        addRecursivo(dato, raiz);
    }

    private void addRecursivo(T dato, Nodo<T> nodo) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if(raiz == null){
            raiz = nuevoNodo;
        }
        else {
            if (nodo.getDato().compareTo(dato) < 0) {
                if (nodo.derecho == null) {
                    nodo.derecho = nuevoNodo;
                } else {
                    addRecursivo(dato, nodo.derecho);
                }
            }
            if (nodo.getDato().compareTo(dato) > 0) {
                if (nodo.izquierdo == null) {
                    nodo.izquierdo = nuevoNodo;
                } else {
                    addRecursivo(dato, nodo.izquierdo);
                }
            }
            if (nodo.getDato().equals(dato)) {
                System.out.println("El elemento ya está en el árbol");
            }
        }
    }

    public ArbolBinarioDeBusqueda<T> getSubArbolIzquierda() {
        ArbolBinarioDeBusqueda<T> subArbol = new ArbolBinarioDeBusqueda<>();
        subArbol.raiz = raiz.izquierdo;
        return subArbol;
    }

    public ArbolBinarioDeBusqueda<T> getSubArbolDerecha() {
        ArbolBinarioDeBusqueda<T> subArbol = new ArbolBinarioDeBusqueda<>();
        subArbol.raiz = raiz.derecho;
        return subArbol;
    }
    public ListaBasica<T> getListaPreOrden() {
        ListaBasica<T> resultado = new ListaBasica<>(1);
        getListaPreOrdenRecursivo(raiz, resultado);
        return resultado;
    }
    private void getListaPreOrdenRecursivo(Nodo<T> nodo, ListaBasica<T> lista) {
        if (nodo != null) {
            lista.add(nodo.getDato());
            getListaPreOrdenRecursivo(nodo.izquierdo, lista);
            getListaPreOrdenRecursivo(nodo.derecho, lista);
        }
    }
    public ListaBasica<T> getListaPostOrden() {
        ListaBasica<T> resultado = new ListaBasica<>(1);
        getListaPostOrdenRecursivo(raiz, resultado);
        return resultado;
    }
    private void getListaPostOrdenRecursivo(Nodo<T> nodo, ListaBasica<T> lista) {
        if (nodo != null) {
            getListaPostOrdenRecursivo(nodo.izquierdo, lista);
            getListaPostOrdenRecursivo(nodo.derecho, lista);
            lista.add(nodo.getDato());
        }
    }
    public ListaBasica<T> getListaOrdenCentral() {
        ListaBasica<T> resultado = new ListaBasica<>(1);
        getListaOrdenCentralRecursivo(raiz, resultado);
        return resultado;
    }
    private void getListaOrdenCentralRecursivo(Nodo<T> nodo, ListaBasica<T> lista) {
        if (nodo != null) {
            getListaOrdenCentralRecursivo(nodo.izquierdo, lista);
            lista.add(nodo.getDato());
            getListaOrdenCentralRecursivo(nodo.derecho, lista);
        }
    }
}

