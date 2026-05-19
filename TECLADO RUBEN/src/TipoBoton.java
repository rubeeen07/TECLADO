public enum TipoBoton {
    IZQUIERDO(1), CENTRAL(2), DERECHO(3);

    private final int numero;

    private TipoBoton(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public static TipoBoton convertirNumeroATipo(int numero){
        if (numero == 1){
            return IZQUIERDO;
        } else if (numero == 2) {
            return CENTRAL;
        } else if (numero == 3) {
            return DERECHO;
        } else {
            throw new IllegalArgumentException("Número de botón inválido: "+numero);
        }
    }

}
