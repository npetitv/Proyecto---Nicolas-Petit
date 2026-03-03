package utilidades;

import dominio.Grafo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ManejadorArchivos {
    
    public Grafo cargarGrafoDesdeCSV() {
        Grafo grafo = new Grafo(); 
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona el archivo maestro de proteínas (CSV)");
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos CSV o Texto", "csv", "txt");
        fileChooser.setFileFilter(filtro);
        
        int seleccion = fileChooser.showOpenDialog(null);
        
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                
                while ((linea = br.readLine()) != null) {
                    
                    if (linea.trim().isEmpty()) {
                        continue;
                    }
                    
                    String[] partes = linea.split(",");
                    
                    if (partes.length >= 3) {
                        String origen = partes[0].trim();
                        String destino = partes[1].trim();
                        
                        int costo = Integer.parseInt(partes[2].trim());
                        
                        grafo.agregarInteraccion(origen, destino, costo);
                    }
                }
                
                JOptionPane.showMessageDialog(null, "¡Archivo cargado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return grafo;
    }
}