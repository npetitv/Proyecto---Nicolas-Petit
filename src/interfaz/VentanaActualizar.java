package interfaz;

import dominio.Grafo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Ventana secundaria encargada de la gestión de datos del grafo.
 * Permite agregar, eliminar y gestionar proteinas asi como las interacciones entre ellas.
 */
public class VentanaActualizar extends JFrame {
    private Grafo grafo;
    
    /**
     * Constructor que inicializa la interfaz de actualización.
     */
    public VentanaActualizar(Grafo grafo) {
        this.grafo = grafo;
        setTitle("Actualizar Repositorio");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 1, 10, 10));

        JButton btnAddProteina = new JButton("Agregar Nueva Proteína");
        btnAddProteina.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog("Nombre de la proteína:");
            if (nombre != null && !nombre.trim().isEmpty()) {
                grafo.agregarProteina(nombre.trim());
                JOptionPane.showMessageDialog(this, "Proteína agregada.");
            }
        });

        JButton btnAddEnlace = new JButton("Agregar Interacción (Arista)");
        btnAddEnlace.addActionListener(e -> {
            String p1 = JOptionPane.showInputDialog("Proteína origen:");
            String p2 = JOptionPane.showInputDialog("Proteína destino:");
            String costoStr = JOptionPane.showInputDialog("Costo de resistencia:");
            try {
                int costo = Integer.parseInt(costoStr);
                grafo.agregarInteraccion(p1, p2, costo);
                JOptionPane.showMessageDialog(this, "Interacción agregada.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Datos inválidos.");
            }
        });
        
        JButton btnDeleteProteina = new JButton("Eliminar Proteína");
        btnDeleteProteina.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog(this, "Nombre de la proteína a eliminar:");
            if (nombre != null && !nombre.trim().isEmpty()) {
                grafo.eliminarProteina(nombre.trim());
                JOptionPane.showMessageDialog(this, "Proteína eliminada.");
            }
        });

        JButton btnDeleteEnlace = new JButton("Eliminar Interacción (Arista)");
        btnDeleteEnlace.addActionListener(e -> {
            String p1 = JOptionPane.showInputDialog(this, "Proteína origen:");
            String p2 = JOptionPane.showInputDialog(this, "Proteína destino:");
            if (p1 != null && p2 != null) {
                grafo.eliminarInteraccion(p1, p2);
                JOptionPane.showMessageDialog(this, "Interacción eliminada.");
            }
        });

        add(new JLabel("Gestión de Datos", SwingConstants.CENTER));
        add(btnAddProteina);
        add(btnDeleteProteina); 
        add(btnAddEnlace);
        add(btnDeleteEnlace);   
        
        JButton btnVolver = new JButton("Volver al Menú");
        btnVolver.addActionListener(e -> dispose());
        add(btnVolver);
    }
}