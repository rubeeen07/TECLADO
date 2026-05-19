import javax.swing.*;
import java.awt.*;

public class Visualizador extends JPanel implements Escritor {
    private JTextArea textArea;

    public Visualizador() {
        this.setBackground(Color.ORANGE);
        this.setLayout(new BorderLayout());

        textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(Color.ORANGE);

        this.add(textArea, BorderLayout.CENTER);
    }

    /**
     * Implementación del método de la interfaz Escritor.
     */
    @Override
    public void escribir(String caracter) {
        textArea.append(caracter);
    }
}
