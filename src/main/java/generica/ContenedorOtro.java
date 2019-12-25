package generica;

import clases.AlfabeticComparator;
import clases.Moneda;
import excepciones.ElementoDuplicadoException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ContenedorOtro<T extends Comparable<T>> {

    private ArrayList<T> generico;

    // Builder
    public ContenedorOtro() {
        this.generico = new ArrayList<>();
    }


    // Setter and Getter
    public ArrayList<T> getGenerico() {
        return generico;
    }

    public void setGenerico(ArrayList<T> generico) {
        this.generico = generico;
    }


    // Methods
    public void guardarDatoGenerico(T generico) throws ElementoDuplicadoException {
        this.generico.add(generico);

    }

    public void mostrarDatos() {
        for (int i = 0; i < generico.size() ; i++) {
            System.out.println(generico.get(i));
        }
    }


    public void ordenarPorValor() {
        Collections.sort(generico);
    }




}
