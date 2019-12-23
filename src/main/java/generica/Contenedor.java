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
public class Contenedor<T extends ArrayList<Moneda>>{
//public class Contenedor<T extends Moneda> implements Comparable<Moneda>{
//public class Contenedor<T extends Moneda>{
//public class Contenedor<T extends Comparable<Moneda>>{

//    private List<T> lista;

    private T generico;
//    private ArrayList<Moneda> monedas;

    // Contructor

    public Contenedor(T generico) {
        // Se inicia la clse generica en nulo
        this.generico = generico;
//        lista = new ArrayList<>();

    }


    public void mostrarDatos() {
        for (int i = 0; i < generico.size() ; i++) {
            System.out.println(generico.get(i));
        }
    }


    public void ordenarPorValor() {
        // metodo estatico basico
        Collections.sort(generico);
    }


    public void ordenarPorAlfabeto() {
        // ordenara por letra en el orden especificado en la clase 'Moneda'
        Collections.sort(generico, new AlfabeticComparator());
    }



    public void ordenarPorFecha() {
        Collections.sort(generico, new Comparator<Moneda>() {
            @Override
            public int compare(Moneda moneda1, Moneda moneda2) {
                return moneda1.getFecha().compareTo(moneda2.getFecha()); // compara para ordenar por letras
            }
        });
    }




















}
