import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Teclado extends JPanel {

    private List<Character> numeros;        //0 - 9
    private List<Character> letrasMay;      //A - Z
    private List<Character> letrasMin;      //a - z
    private List<String> signosPun;         // ",;" ".:" "-_"
    private List<Tecla> teclas;             //1 - -
    private Escritor escritor;


    public Teclado(Escritor escritor) {
        super();
        if (escritor == null) {
            throw new IllegalArgumentException("El escritor no puede ser nulo");
        }
        this.escritor = escritor;
        this.teclas = new ArrayList<>();

        setBackground(Color.GREEN);


        inicializarLetras();
        crearTeclas();
        configurarLayout();

    }


    public void inicializarLetras() {
        //numeros
        numeros = new ArrayList<>();

        for (char i = '1'; i <= '9'; i++) {
            numeros.add(i);
        }
        char cero = '0';
        numeros.add(cero);

        //letras
       letrasMay = Fabrica.generarLetrasMay();

       //letras min
        letrasMin = new ArrayList<>();
        Iterator<Character> it =letrasMay.iterator();
        while (it.hasNext()) {
            char may = it.next();
            letrasMin.add(Character.toLowerCase(may));
        }


        //signos
        signosPun = new ArrayList<>();
        signosPun.add(",;");
        signosPun.add(".:");
        signosPun.add("-_");

    }

    public void crearTeclas() {
        //NUMEOROS
        for (int i = 0; i < numeros.size(); i++) {
            char c = numeros.get(i);
            teclas.add(new Tecla(c, c, escritor));
        }

        //LETRAS
        for (int i = 0; i < letrasMay.size(); i++) {
            char letraMin = letrasMin.get(i);
            char letraMay = letrasMay.get(i);
            teclas.add(new Tecla(letraMin, letraMay, escritor));
        }

        for (int i = 0; i < signosPun.size(); i++) {
            String s = signosPun.get(i);
            teclas.add(new Tecla(s.charAt(0), s.charAt(1), escritor));
        }

    }

    private void configurarLayout() {
        this.setLayout(new GridLayout(0, 10, 2, 2));

        for (int i = 0; i < teclas.size(); i++) {
            this.add(teclas.get(i));
        }
    }



}
