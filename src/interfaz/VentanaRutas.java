package interfaz;

import dominio.Grafo;
import utilidades.Algoritmos;
import javax.swing.*;
import java.awt.*;

/**
 * Ventana encargada de la ejecución de algoritmos de búsqueda y rutas.
 * Permite seleccionar proteínas de origen y destino para aplicar 
 * BFS, DFS o Dijkstra y visualizar el resultado.
 */
public class VentanaRutas extends JFrame {
    private Grafo grafo;
    private Algoritmos alg = new Algoritmos();
    
    /**
     * Constructor que inicializa la interfaz de cálculo de rutas.
     * Configura los selectores de proteínas y los botones de ejecución.
     */
    public VentanaRutas(Grafo g) {
        this.grafo = g;
        setTitle("Cálculo de Rutas y Recorridos");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(6, 1, 10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        JTextField txtOrigen = new JTextField("P1");
        JTextField txtDestino = new JTextField("P5");
        
        JButton btnDijkstra = new JButton("Calcular Ruta Mínima (Dijkstra)");
        btnDijkstra.addActionListener(e -> {
            alg.calcularDijkstra(this.grafo, txtOrigen.getText(), txtDestino.getText());
        }); 

        JButton btnBFS = new JButton("Recorrido BFS (Anchura)");
        btnBFS.addActionListener(e -> {
            String res = alg.recorrerBFS(this.grafo, txtOrigen.getText());
            JOptionPane.showMessageDialog(this, res);
        }); 

        panelPrincipal.add(new JLabel("Proteína Origen:", SwingConstants.CENTER));
        panelPrincipal.add(txtOrigen);
        panelPrincipal.add(new JLabel("Proteína Destino (solo para Dijkstra):", SwingConstants.CENTER));
        panelPrincipal.add(txtDestino);
        panelPrincipal.add(btnDijkstra);
        panelPrincipal.add(btnBFS);
        
        add(panelPrincipal, BorderLayout.CENTER);
    }
}