package dominio;

import estructuras.Lista;
import estructuras.NodoLista;

/**
 * Clase que representa la estructura principal del grafo.
 * Administra los vértices y sus aristas ).
 */
public class Grafo {
    
    private Lista<Proteina> proteinas;
    
    /**
     * Constructor que inicializa el grafo con una lista vacía de proteínas.
     */
    public Grafo() {
        this.proteinas = new Lista<>();
    }
    
    /**
     * Constructor que inicializa el grafo con una lista vacía de proteínas.
     */
    public Lista<Proteina> getProteinas() {
        return proteinas;
    }

    /**
     * Busca y retorna una proteína específica por su nombre.
     */
    public Proteina obtenerProteina(String nombre) {
        if (proteinas.esVacia()) {
            return null;
        }
        
        for (int i = 0; i < proteinas.getTamaño(); i++) {
            Proteina p = proteinas.obtener(i);
            if (p.getNombre().equals(nombre)) {
                return p;
            }
        }
        return null;
    }
    
    /**
     * Agrega un nuevo vértice al grafo si no existe previamente.
     */
    public void agregarProteina(String nombre) {
        if (obtenerProteina(nombre) == null) {
            Proteina nuevaProteina = new Proteina(nombre);
            proteinas.agregar(nuevaProteina);
        }
    }
    
    /**
     * Crea una arista (interacción) bidireccional entre dos proteínas.
     */
    public void agregarInteraccion(String origen, String destino, int costo) {
        agregarProteina(origen);
        agregarProteina(destino);
        
        Proteina pOrigen = obtenerProteina(origen);
        Proteina pDestino = obtenerProteina(destino);
        
        Interaccion interaccionIda = new Interaccion(pDestino, costo);
        Interaccion interaccionVuelta = new Interaccion(pOrigen, costo);
        
        pOrigen.agregarInteraccion(interaccionIda);
        pDestino.agregarInteraccion(interaccionVuelta);
    }
    
    /**
     * Elimina un vértice del grafo usando su nombre y actualiza la estructura.
     */
    public void eliminarProteina(String nombre) {
        for (int i = 0; i < proteinas.getTamaño(); i++) {
            if (proteinas.obtener(i).getNombre().equalsIgnoreCase(nombre)) {
                proteinas.eliminar(i);
                break;
            }
        }
    }
    
    /**
     * Elimina la arista dirigida de una proteína a otra.
     */
    public void eliminarInteraccion(String origen, String destino) {
        for (int i = 0; i < proteinas.getTamaño(); i++) {
            Proteina p = proteinas.obtener(i);
            if (p.getNombre().equalsIgnoreCase(origen)) {
                Lista<Interaccion> adyacentes = p.getInteracciones();
                for (int j = 0; j < adyacentes.getTamaño(); j++) {
                    if (adyacentes.obtener(j).getDestino().getNombre().equalsIgnoreCase(destino)) {
                        adyacentes.eliminar(j);
                        return;
                    }
                }
            }
        }
    }
}