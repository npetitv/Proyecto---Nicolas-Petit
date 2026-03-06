package dominio;

import estructuras.Lista; 

/**
 * Clase que representa un vértice dentro del grafo.
 * Almacena su nombre y la lista de interacciones  que tiene con otras proteínas.
 */
public class Proteina {
    
    private String nombre;
    private Lista<Interaccion> interacciones;
    
    /**
     * Constructor que inicializa la proteína con su identificador.
     * También prepara la estructura vacía para sus futuras conexiones.
     */
    public Proteina(String nombre) {
        this.nombre = nombre;
        this.interacciones = new Lista<>(); 
    }
    
    /**
     * Obtiene el nombre de la proteína.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Modifica el nombre de la proteína.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene la lista de adyacencia de esta proteína (todas sus conexiones).
     */
    public Lista<Interaccion> getInteracciones() {
        return interacciones;
    }
    
    /**
     * Añade una nueva conexión a la lista de interacciones de esta proteína.
     */
    public void agregarInteraccion(Interaccion interaccion) {
        this.interacciones.agregar(interaccion);
    }
}