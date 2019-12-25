package generica;

import clases.AlfabeticComparator;
import clases.Moneda;
import clases.Monedas;
import sun.dc.pr.PRError;

import java.util.*;

/**Poniendo lo siguiente ' <T> ' despues de la clase lo que estamos haciendo es ponerle
 * un argumento de tipo, por lo tanto la clase pasaria a ser generica.
 * Por convencion se usan las letras T, U, K, E, N, V y S, donde caa letra es para:
 *  E: elemento de una colección.
 *  K: clave.
 *  V: valor.
 *  N: número.
 *  T: tipo.
 *  S, U, V etc: para segundos, terceros y cuartos tipos.
 * @param <T> sera el datro de tipo generico */
public class Contenedor<T extends Comparable<T>>{

    private T[] generico;

    // Builder
    public Contenedor() {
        this.generico = null;
    }

    // Setter and Getter
    public T[] getGenerico() {
        return generico;
    }

    public void setGenerico(T[] generico) {
        this.generico = generico;
    }



    // Methods
    public void mostrarDatos() {
        for (int i = 0; i < generico.length ; i++) {
            System.out.println(generico[i]);
        }
    }


    public void ordenarPorValor() {
        Arrays.sort(generico, 0, generico.length);
//        Arrays.sort(generico, Comparator.naturalOrder()); // metodo similar
    }



    public void ordenarPorAlfabeto() {



    }

    public void ordenarPorFecha() {



    }





}
