package estructuras;

/**
 * Implementación de una Lista Enlazada.
 */
public class Lista<T> {
    
    private NodoLista<T> cabeza;
    private int tamaño;
    
    /**
     * Constructor que inicializa una lista vacía.
     */
    public Lista() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    public boolean esVacia() {
        return cabeza == null;
    }
    
    /**
     * Agrega un nuevo elemento al final de la lista.
     */
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
    
    /**
     * Obtiene el elemento almacenado en una posición específica.
     */
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
    
    /**
     * Elimina el elemento de la lista en la posición indicada.
     */
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