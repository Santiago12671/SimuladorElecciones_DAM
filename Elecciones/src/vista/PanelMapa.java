package vista;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PanelMapa extends JPanel {
    private PanelEstadisticas panelEstadisticas;

    public PanelMapa(PanelEstadisticas panelEstadisticas) {
        this.panelEstadisticas = panelEstadisticas;
        setLayout(new GridLayout(0, 2, 5, 5)); // Dos columnas de botones
        setBorder(BorderFactory.createTitledBorder("Mapa Interactivo de Comunidades"));

        // Comunidades según el PDF 
        String[] comunidades = {
            "Andalucia", "Aragón", "Asturias", "Baleares", "Canarias", "Cantabria",
            "Castilla La Mancha", "Castilla y León", "Cataluña", "Comunidad Valenciana",
            "Extremadura", "Galicia", "Madrid", "Murcia", "Navarra", "País Vasco", "La Rioja", "Ceuta", "Melilla"
        };

        for (String nombre : comunidades) {
            JButton btn = new JButton(nombre);
            btn.setToolTipText("Ver resultados de " + nombre);
            btn.addActionListener(e -> cargarDatosComunidad(nombre));
            add(btn);
        }
    }

    private void cargarDatosComunidad(String nombre) {
        // Simulación de datos (Aquí deberías llamar a tu controlador/DAO para datos reales)
        Map<String, Integer> partidos = new HashMap<>();
        partidos.put("Partido X", (int)(Math.random()*500));
        partidos.put("Partido Y", (int)(Math.random()*500));
        partidos.put("Partido W", (int)(Math.random()*500));
        partidos.put("Partido Z", (int)(Math.random()*500));

        Map<String, Integer> edades = new HashMap<>();
        edades.put("18-25", (int)(Math.random()*200));
        edades.put("26-40", (int)(Math.random()*200));
        edades.put("41-65", (int)(Math.random()*200));
        edades.put("+66", (int)(Math.random()*200));

        panelEstadisticas.actualizarGraficos(nombre, partidos, edades);
    }
}