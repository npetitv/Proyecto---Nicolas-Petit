package interfaz;

import dominio.Grafo;
import utilidades.ManejadorArchivos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa la ventana principal de la interfaz gráfica del sistema.
 */
public class MenuPrincipal extends JFrame {
    
    private Grafo grafoSistema;
    private final ManejadorArchivos manejador;
    
    /**
     * Constructor que inicializa la ventana principal.
     */
    public MenuPrincipal() {
        this.grafoSistema = new Grafo();
        this.manejador = new ManejadorArchivos();
        
        // Configuración básica de la ventana
        setTitle("Analizador de Redes Proteicas - Nicolas Petit");
        setSize(400, 350); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout(10, 10)); 
        
        JLabel lblTitulo = new JLabel("Menú Principal del Sistema", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblTitulo, BorderLayout.NORTH);
        
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(5, 1, 10, 10)); 
        
        JButton btnCargar = new JButton("1. Cargar Grafo desde archivo (CSV)");
        JButton btnMostrar = new JButton("2. Mostrar Grafo (Visual)");
        JButton btnActualizar = new JButton("3. Actualizar Repositorio (Agregar/Eliminar)");
        JButton btnRutas = new JButton("4. Calcular Rutas (BFS / DFS / Dijkstra)");
        
        panelBotones.add(btnCargar);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnRutas);
        
        add(panelBotones, BorderLayout.CENTER);
        
        // Evento para cargar el grafo desde un archivo
        btnCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Grafo grafoCargado = manejador.cargarGrafoDesdeCSV();
                
                if (grafoCargado != null && !grafoCargado.getProteinas().esVacia()) {
                    grafoSistema = grafoCargado;
                    JOptionPane.showMessageDialog(null, 
                            "Se han cargado " + grafoSistema.getProteinas().getTamaño() + " proteínas al sistema.", 
                            "Resumen de Carga", 
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        // Evento para abrir la ventana de actualización de datos
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaActualizar v = new VentanaActualizar(grafoSistema);
                v.setVisible(true);
            }
        });
        
        // Evento para abrir la visualización gráfica del grafo
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (grafoSistema.getProteinas().esVacia()) {
                    JOptionPane.showMessageDialog(null, "Carga un archivo primero.");
                    return;
                }
                JFrame ventanaGrafica = new JFrame("Visualización del Grafo");
                ventanaGrafica.setSize(600, 600);
                ventanaGrafica.add(new PanelGrafo(grafoSistema));
                ventanaGrafica.setLocationRelativeTo(null);
                ventanaGrafica.setVisible(true);
            }
        });
        
        // Evento para abrir la ventana de cálculo de rutas
        btnRutas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (grafoSistema.getProteinas().esVacia()) {
                    JOptionPane.showMessageDialog(null, "Carga datos primero.");
                    return;
            }
            VentanaRutas v = new VentanaRutas(grafoSistema);
            v.setVisible(true);
            }
        });
        
    }
    
    /**
     * Método principal que arranca la aplicación.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MenuPrincipal ventana = new MenuPrincipal();
                ventana.setVisible(true); 
            }
        });
    }
}