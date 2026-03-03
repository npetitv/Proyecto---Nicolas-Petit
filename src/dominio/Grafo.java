package dominio;

import estructuras.Lista;
import estructuras.NodoLista;

public class Grafo {
    
    private Lista<Proteina> proteinas;

    public Grafo() {
        this.proteinas = new Lista<>();
    }

    public Lista<Proteina> getProteinas() {
        return proteinas;
    }

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

    public void agregarProteina(String nombre) {
        if (obtenerProteina(nombre) == null) {
            Proteina nuevaProteina = new Proteina(nombre);
            proteinas.agregar(nuevaProteina);
        }
    }

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
}