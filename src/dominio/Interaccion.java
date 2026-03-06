package dominio;

/**
 * Clase que representa una arista o conexión en el grafo.
 * Almacena la proteína de destino y el costo de la interacción.
 */
public class Interaccion {
    
    private Proteina destino;
    private int costo;
    
    /**
     * Constructor que inicializa una nueva interacción.
     */
    public Interaccion(Proteina destino, int costo) {
        this.destino = destino;
        this.costo = costo;
    }
    
    /**
     * Obtiene la proteína de destino de esta interacción..
     */
    public Proteina getDestino() {
        return destino;
    }
    
    /**
     * Modifica la proteína de destino de la interacción.
     */
    public void setDestino(Proteina destino) {
        this.destino = destino;
    }
    
    /**
     * Obtiene el costo o peso de la conexión.
     */
    public int getCosto() {
        return costo;
    }
    
    /**
     * Modifica el costo de la interacción.
     */
    public void setCosto(int costo) {
        this.costo = costo;
    }
}