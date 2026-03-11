package vista;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class VentanaPrincipal extends JFrame {

    private PanelEstadisticas panelEstadisticas;
    private PanelMapa panelMapa;

    public VentanaPrincipal() {
        // Configuración de la ventana según el PDF
        setTitle("Simulador Electoral España 2026");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Cabecera
        JPanel header = new JPanel();
        header.setBackground(new Color(41, 128, 185));
        JLabel titulo = new JLabel("ESCRUTINIO EN TIEMPO REAL");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        header.add(titulo);
        add(header, BorderLayout.NORTH);

        // Paneles (Se encargan de los gráficos de sectores y barras) 
        panelEstadisticas = new PanelEstadisticas();
        panelMapa = new PanelMapa(panelEstadisticas);

        // Separador para mapa (izq) y gráficos (der)
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelMapa, panelEstadisticas);
        splitPane.setDividerLocation(450);
        add(splitPane, BorderLayout.CENTER);

        // Barra de progreso (Aviso visual del escrutinio) 
        JProgressBar barraProgreso = new JProgressBar(0, 100);
        barraProgreso.setStringPainted(true);
        barraProgreso.setString("Esperando inicio...");
        add(barraProgreso, BorderLayout.SOUTH);
    }

    // EL MÉTODO MAIN PARA EJECUTAR DESDE EL POM.XML
    public static void main(String[] args) {
        // Aplicar diseño del sistema (Usabilidad) [cite: 62]
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}