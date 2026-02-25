package vista;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        setTitle("Simulador Electoral 2026 - EFA Moratalaz");
        setSize(1300, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Cabecera profesional
        JPanel header = new JPanel();
        header.setBackground(new Color(41, 128, 185));
        JLabel titulo = new JLabel("SISTEMA DE ESCRUTINIO EN TIEMPO REAL");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        header.add(titulo);
        add(header, BorderLayout.NORTH);

        // Paneles de contenido
        PanelEstadisticas panelEstadisticas = new PanelEstadisticas();
        PanelMapa panelMapa = new PanelMapa(panelEstadisticas);

        // SplitPane para dividir mapa y gráficos 
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelMapa, panelEstadisticas);
        splitPane.setDividerLocation(400);
        add(splitPane, BorderLayout.CENTER);

        // Barra de progreso inferior 
        JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setString("Esperando inicio de simulación...");
        add(progressBar, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        // Look & Feel del sistema para que se vea moderno
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}