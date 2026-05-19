import java.util.ArrayList;
import java.util.List;

public class Fabrica {

    public static List<Character> generarLetrasMay() {

        String qwerty = "QWERTYUIOPASDFGHJKLZXCVBNM";
        List<Character> letras = new ArrayList<>();

        for (int i = 0; i < qwerty.length(); i++) {
            letras.add(qwerty.charAt(i));
        }

        return letras;
    }


}
