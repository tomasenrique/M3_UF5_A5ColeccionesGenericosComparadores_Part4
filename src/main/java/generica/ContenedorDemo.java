package generica;

import clases.AlfabeticComparator;
import clases.Moneda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Esta clase se crea para que sea generica y el dato este heredara los metodos de la clase ArrayList<Moneda> pudiendo
 * asi ordenar por valor por fecha y por alfabeto.
 */

public class ContenedorDemo<T extends ArrayList<Moneda>> {

    private T generico;

    public ContenedorDemo(T generico) {
        this.generico = generico;
    }

    // Setter and Getter
    public T getGenerico() {
        return generico;
    }

    public void setGenerico(T generico) {
        this.generico = generico;
    }

    // Inherited methods
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


    public Iterator<Moneda> iterator() {
        //
        return generico.iterator();
    }


}