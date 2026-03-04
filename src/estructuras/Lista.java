package estructuras;

public class Lista<T> {
    
    private NodoLista<T> cabeza;
    private int tamaño;

    public Lista() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    public boolean esVacia() {
        return cabeza == null;
    }

    public void agregar(T elemento) {
        NodoLista<T> nuevoNodo = new NodoLista<>(elemento);
        if (esVacia()) {
            cabeza = nuevoNodo;
        } else {
            NodoLista<T> actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        tamaño++;
    }

    public T obtener(int indice) {
        if (indice < 0 || indice >= tamaño) {
            return null;
        }
        NodoLista<T> actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getElemento();
    }

    public int getTamaño() {
        return tamaño;
    }
    
    public void eliminar(int indice) {
        if (indice < 0 || indice >= tamaño || cabeza == null) {
            return;
        }

        if (indice == 0) {
            cabeza = cabeza.getSiguiente();
        } 
        else {
            NodoLista<T> auxiliar = cabeza;
            for (int i = 0; i < indice - 1; i++) {
                auxiliar = auxiliar.getSiguiente();
            }
            if (auxiliar.getSiguiente() != null) {
                auxiliar.setSiguiente(auxiliar.getSiguiente().getSiguiente());
            }
        }
        
        tamaño--;
    }
}