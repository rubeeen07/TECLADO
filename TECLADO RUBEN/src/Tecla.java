import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Tecla extends JButton  {

    private char abajo;             //a - z  , . -
    private char arriba;            //A - Z ; : _
    private Escritor escritor;

    public Tecla(char abajo, char arriba, Escritor escritor) {

        setAbajo(abajo);
        setArriba(arriba);
        setEscritor(escritor);


        this.setText(String.valueOf(abajo));
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.setOpaque(true);



        this.addMouseListener(new ManejadorEventos());
    }


    public char getAbajo() {
        return abajo;
    }

    public void setAbajo(char abajo) {
        this.abajo = abajo;
    }

    public char getArriba() {
        return arriba;
    }

    public void setArriba(char arriba) {
        this.arriba = arriba;
    }

    public Escritor getEscritor() {
        return escritor;
    }

    public void setEscritor(Escritor escritor) {
        if (escritor == null)
            throw new IllegalArgumentException("El escritor no puede ser nulo");
        this.escritor = escritor;
    }

    @Override
    public String toString() {
        return "Tecla{" +
                "abajo=" + abajo +
                ", arriba=" + arriba +
                ", escritor=" + escritor +
                '}';
    }


    public class ManejadorEventos extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() instanceof Tecla) {
                Tecla tecla = (Tecla) e.getSource();

                //Asigno el boton del raton usado en "Tipo"
                TipoBoton tipo= TipoBoton.convertirNumeroATipo(e.getButton());

                //Si es click de Tipo IZQUIERDO, valor de abajo, si es click Tipo DERECHO, valor de arriba
                if (tipo == TipoBoton.IZQUIERDO) {
                    escritor.escribir(String.valueOf(tecla.getAbajo()));
                } else if (tipo == TipoBoton.DERECHO) {
                    escritor.escribir(String.valueOf(tecla.getArriba()));
                } else {
                    throw new IllegalArgumentException("Boton no esperado: "+e.getButton());
                }
            } else {
                throw new IllegalStateException("El origen del evento tiene que ser una Tecla");
            }
        }

        /*@Override
        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) { // Botón IZQUIERDO
                visualizador.escribir(String.valueOf(caracterAbajo));
            } else if (e.getButton() == MouseEvent.BUTTON3) { // Botón DERECHO
                visualizador.escribir(String.valueOf(caracterArriba));
            }
        }*/
    }
}
