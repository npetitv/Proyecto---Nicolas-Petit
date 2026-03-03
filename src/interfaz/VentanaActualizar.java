package interfaz;

import dominio.Grafo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaActualizar extends JFrame {
    private Grafo grafo;

    public VentanaActualizar(Grafo grafo) {
        this.grafo = grafo;
        setTitle("Actualizar Repositorio");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

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

        add(new JLabel("Gestión de Datos", SwingConstants.CENTER));
        add(btnAddProteina);
        add(btnAddEnlace);
        
        JButton btnVolver = new JButton("Volver al Menú");
        btnVolver.addActionListener(e -> dispose());
        add(btnVolver);
    }
}