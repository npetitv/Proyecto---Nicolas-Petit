package estructuras;

/**
 * Clase que representa un nodo individual dentro de una lista enlazada.
 */
public class NodoLista<T> {
    
    private T elemento;
    private NodoLista<T> siguiente;
    
    /**
     * Constructor que inicializa el nodo con un dato específico.
     */
    public NodoLista(T elemento) {
        this.elemento = elemento;
        this.siguiente = null;
    }
    
    /**
     * Obtiene el dato almacenado actualmente en el nodo.
     */
    public T getElemento() {
        return elemento;
    }
    
    /**
     * Modifica el dato que almacena el nodo.
     */
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }
    
    /**
     * Obtiene la referencia al siguiente nodo en la lista enlazada.
     */
    public NodoLista<T> getSiguiente() {
        return siguiente;
    }
    
    /**
     * Establece o modifica el enlace hacia el próximo nodo en la lista.
     */
    public void setSiguiente(NodoLista<T> siguiente) {
        this.siguiente = siguiente;
    }
}