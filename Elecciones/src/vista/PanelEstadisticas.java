package vista;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PanelEstadisticas extends JPanel {
    private JPanel contenedorGraficos;

    public PanelEstadisticas() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Visualización de Resultados"));
        
        contenedorGraficos = new JPanel(new GridLayout(2, 1)); // Tarta arriba, Barras abajo
        add(new JScrollPane(contenedorGraficos), BorderLayout.CENTER);
        
        mostrarMensajeInicial();
    }

    private void mostrarMensajeInicial() {
        contenedorGraficos.add(new JLabel("Selecciona una comunidad en el mapa para ver estadísticas", SwingConstants.CENTER));
    }

    // Actualiza los gráficos con los datos reales de la BBDD o simulación
    public void actualizarGraficos(String comunidad, Map<String, Integer> votosPartidos, Map<String, Integer> votosEdad) {
        contenedorGraficos.removeAll();

        // 1. Gráfico de Sectores (Votos por Partido) [cite: 114, 124]
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        votosPartidos.forEach(pieDataset::setValue);
        JFreeChart pieChart = ChartFactory.createPieChart("Resultado en " + comunidad, pieDataset, true, true, false);
        
        // 2. Gráfico de Barras (Votos por Edad) [cite: 113, 124]
        DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
        votosEdad.forEach((rango, cantidad) -> barDataset.addValue(cantidad, "Votos", rango));
        JFreeChart barChart = ChartFactory.createBarChart("Votos por Rango de Edad", "Edad", "Votos", barDataset);

        contenedorGraficos.add(new ChartPanel(pieChart));
        contenedorGraficos.add(new ChartPanel(barChart));

        revalidate();
        repaint();
    }
}