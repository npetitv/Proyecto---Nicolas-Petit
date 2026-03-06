package interfaz;

import dominio.Grafo;
import dominio.Proteina;
import dominio.Interaccion;
import estructuras.Lista;
import javax.swing.*;
import java.awt.*;

/**
 * Clase encargada de la representación gráfica del grafo en pantalla.
 */
public class PanelGrafo extends JPanel {
    private Grafo grafo;
    
    /**
     * Constructor que recibe el grafo cargado en memoria para ser dibujado..
     */
    public PanelGrafo(Grafo grafo) {
        this.grafo = grafo;
        this.setBackground(Color.WHITE);
    }

    /**
     * Método principal de renderizado que se ejecuta automáticamente al mostrar el panel.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Lista<Proteina> listaProtas = grafo.getProteinas();
        int n = listaProtas.getTamaño();
        if (n == 0) return;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radio = Math.min(centerX, centerY) - 50;

        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            double angulo = 2 * Math.PI * i / n;
            x[i] = (int) (centerX + radio * Math.cos(angulo));
            y[i] = (int) (centerY + radio * Math.sin(angulo));
        }

        g2.setColor(Color.BLACK);
        for (int i = 0; i < n; i++) {
            Proteina p = listaProtas.obtener(i);
            Lista<Interaccion> inters = p.getInteracciones();
            for (int j = 0; j < inters.getTamaño(); j++) {
                Proteina destino = inters.obtener(j).getDestino();
                for (int k = 0; k < n; k++) {
                    if (listaProtas.obtener(k) == destino) {
                        g2.drawLine(x[i], y[i], x[k], y[k]);
                        g2.drawString(String.valueOf(inters.obtener(j).getCosto()), (x[i]+x[k])/2, (y[i]+y[k])/2);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            g2.setColor(new Color(100, 150, 255));
            g2.fillOval(x[i] - 15, y[i] - 15, 30, 30);
            g2.setColor(Color.BLACK);
            g2.drawOval(x[i] - 15, y[i] - 15, 30, 30);
            g2.drawString(listaProtas.obtener(i).getNombre(), x[i] - 20, y[i] - 20);
        }
    }
}