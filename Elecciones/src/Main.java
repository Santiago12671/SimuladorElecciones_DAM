import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import vista.VentanaPrincipal;

public class Main {

    public static void main(String[] args) {
        // 1. Intentar poner el diseño del sistema operativo (Requisito de usabilidad)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Si falla, usará el diseño por defecto de Java (Metal)
        }

        // 2. Lanzar la interfaz en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            try {
                // Creamos la ventana que ya tienes configurada
                VentanaPrincipal ventana = new VentanaPrincipal();
                
                // La hacemos visible
                ventana.setVisible(true);
                
                System.out.println("Aplicación de Escrutinio iniciada correctamente.");
            } catch (Exception e) {
                System.err.println("Error al iniciar la ventana: " + e.getMessage());
                e.printStackTrace();
            }
        });
    }
}