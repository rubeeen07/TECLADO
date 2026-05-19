import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private Teclado panelTeclado;
    private Visualizador panelVisualizador;

    public VentanaPrincipal() {
        super("Teclado Virtual Swing");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 460);

        // Color de fondo de la ventana principal
        this.getContentPane().setBackground(Color.BLUE);
        this.setLayout(new BorderLayout());

        try {
            panelVisualizador = new Visualizador();
            // El visualizador ocupa la mayoría (CENTER)
            this.add(panelVisualizador, BorderLayout.CENTER);

            // Creamos un panel contenedor azul para la parte inferior
            JPanel contenedorInferior = new JPanel(new BorderLayout());
            contenedorInferior.setBackground(Color.BLUE);
            // Añadimos un poco de margen azul alrededor del teclado para que se vea el color
            contenedorInferior.setBorder(new EmptyBorder(10, 10, 10, 10));

            // Ahora pasamos el Visualizador como un Escritor al Teclado
            panelTeclado = new Teclado(panelVisualizador);
            // El panel teclado en sí es verde (según requisito)
            contenedorInferior.add(panelTeclado, BorderLayout.CENTER);

            // Añadimos el contenedor azul al sur
            this.add(contenedorInferior, BorderLayout.SOUTH);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
