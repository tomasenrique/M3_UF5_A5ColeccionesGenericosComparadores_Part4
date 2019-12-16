package clases;

import java.util.Comparator;

/**Esta clase servira para poder comparar datos que contengan letras  */
public class AlfabeticComparator implements Comparator<Moneda> {

    // Aqui se compara el texto del atributo 'imagen' de la clase Moneda para ordenar por letra
    @Override
    public int compare(Moneda moneda1, Moneda moneda2) {
        return (moneda1.getImagen().compareTo(moneda2.getImagen()));
    }



}
