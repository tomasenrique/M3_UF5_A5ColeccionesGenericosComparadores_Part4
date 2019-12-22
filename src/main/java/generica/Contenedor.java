package generica;

/**Poniendo lo siguiente ' <T> ' despues de la clase lo que estamos haciendo es ponerle
 * un argumento de tipo, por lo tanto la clase pasaria a ser generica.
 * Por convencion se usan las letras T, U y K
 * @param <T>  */
public class Contenedor<T>{

    private T generico;

    // Contructor
    public Contenedor() {
        // Se inicia la clse generica en nulo
        this.generico = null;
    }

    //Setter y Getter
    public T getGenerico() {
        return generico;
    }

    public void setGenerico(T generico) {
        this.generico = generico;
    }

    // Metodos


}
