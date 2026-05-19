import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        // Ejecutar la creación de la interfaz en el hilo de eventos de Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new VentanaPrincipal();
                } catch (Exception e) {
                    System.err.println("Error crítico al iniciar la aplicación: " + e.getMessage());
                }
            }
        });
    }
}
