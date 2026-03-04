package utilidades;

import dominio.*;
import estructuras.Lista;
import javax.swing.JOptionPane;

public class Algoritmos {

    public void calcularDijkstra(Grafo grafo, String inicio, String fin) {
        Lista<Proteina> todas = grafo.getProteinas();
        Proteina pInicio = grafo.obtenerProteina(inicio);
        Proteina pFin = grafo.obtenerProteina(fin);

        if (pInicio == null || pFin == null) {
            JOptionPane.showMessageDialog(null, "Error: Verifique los nombres de las proteínas.");
            return;
        }

        int n = todas.getTamaño();
        int[] distancias = new int[n];
        boolean[] visitados = new boolean[n];
        Proteina[] predecesores = new Proteina[n];

        for (int i = 0; i < n; i++) {
            distancias[i] = Integer.MAX_VALUE;
            visitados[i] = false;
        }

        int idxInicio = buscarIndice(todas, pInicio);
        distancias[idxInicio] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = minDistance(distancias, visitados, n);
            if (u == -1) break;
            visitados[u] = true;

            Proteina actual = todas.obtener(u);
            Lista<Interaccion> adyacentes = actual.getInteracciones();

            for (int j = 0; j < adyacentes.getTamaño(); j++) {
                Interaccion inter = adyacentes.obtener(j);
                int v = buscarIndice(todas, inter.getDestino());
                
                if (!visitados[v] && distancias[u] != Integer.MAX_VALUE 
                    && distancias[u] + inter.getCosto() < distancias[v]) {
                    distancias[v] = distancias[u] + inter.getCosto();
                    predecesores[v] = actual;
                }
            }
        }

        mostrarResultadoDijkstra(predecesores, todas, pFin, distancias[buscarIndice(todas, pFin)]);
    }

    private int minDistance(int[] dist, boolean[] visitados, int n) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < n; v++) {
            if (!visitados[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }

    private int buscarIndice(Lista<Proteina> lista, Proteina p) {
        for (int i = 0; i < lista.getTamaño(); i++) {
            if (lista.obtener(i) == p) return i;
        }
        return -1;
    }

    private void mostrarResultadoDijkstra(Proteina[] pred, Lista<Proteina> lista, Proteina fin, int distTotal) {
        if (distTotal == Integer.MAX_VALUE) {
            JOptionPane.showMessageDialog(null, "No existe conexión entre estas proteínas.");
            return;
        }
        
        String camino = fin.getNombre();
        Proteina temp = pred[buscarIndice(lista, fin)];
        while (temp != null) {
            camino = temp.getNombre() + " -> " + camino;
            temp = pred[buscarIndice(lista, temp)];
        }
        JOptionPane.showMessageDialog(null, "Ruta Mínima: " + camino + "\nCosto Total: " + distTotal);
    }
    
    public String recorrerBFS(Grafo grafo, String nombreInicio) {
        Proteina inicio = grafo.obtenerProteina(nombreInicio);
        if (inicio == null) return "La proteína inicial no existe.";

        Lista<Proteina> visitados = new Lista<>();
        Lista<Proteina> cola = new Lista<>();
        String resultado = "Recorrido BFS: ";

        cola.agregar(inicio);
        visitados.agregar(inicio);

        while (!cola.esVacia()) {
            Proteina actual = cola.obtener(0);
            cola.eliminar(0); 
            
            resultado += actual.getNombre() + " ";

            Lista<Interaccion> adyacentes = actual.getInteracciones();
            for (int i = 0; i < adyacentes.getTamaño(); i++) {
                Proteina destino = adyacentes.obtener(i).getDestino();
                
                boolean yaVisitado = false;
                for(int j=0; j < visitados.getTamaño(); j++) {
                    if(visitados.obtener(j) == destino) yaVisitado = true;
                }
                
                if (!yaVisitado) {
                    visitados.agregar(destino);
                    cola.agregar(destino);
                }
            }
        }
        return resultado;
    }
    
}

