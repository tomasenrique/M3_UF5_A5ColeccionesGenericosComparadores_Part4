package clases;

import excepciones.ElementoDuplicadoException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * A la clase, ahora se le implementa la interfaz 'Iterable' para poder recorrer la lista de monedas
 */
public class Monedas implements Iterable<Moneda> {

    private ArrayList<Moneda> monedas;

    // Contructor
    public Monedas() {
        // inicializa el array
        this.monedas = new ArrayList<>();
    }

    //Setter y Getter
    public ArrayList<Moneda> getMonedas() {
        return monedas;
    }

    public void setMonedas(ArrayList<Moneda> monedas) {
        this.monedas = monedas;
    }


    // Metodos

    /**
     * Este metodo se encarga de agregar las monedas al arraList teniendo en cuenta si ya existe una igual en el, teniendo
     * como referecia en este caso el campo 'imagen' que es de tipo cadena de la moneda para poder usar el metodo 'contains'
     * y asi saber si son iguales.
     *
     * @param moneda Es el objeto de tipo Moneda
     * @throws ElementoDuplicadoException Es la excepcion de error que saltara cuando halla una modeda identica
     */
    public void guardarMonedaContains(Moneda moneda) throws ElementoDuplicadoException {
        boolean contiene = false; // para saber si esta el objeto igual

        for (Moneda m : monedas) { // se itera todo el array para verificar el contenido
            if (m.getDetalle().contains(moneda.getDetalle()))
                contiene = true; // verifica que la moneda no existe en el arrayList
        }
        if (contiene) {
            throw new ElementoDuplicadoException("La moneda de valor " + moneda.getValor() + " ya existe, No se agregara a la lista.");
        } else monedas.add(moneda); // agrega las monedas que no sean iguales
    }


    /**
     * Este metodo compara si dos objetos son iguales, a diferencia del metodo 'guardarMonedaContains' este compara teniendo
     * en cuenta todos los campos atributos del objeto dando asi una mayor certeza de que el objeto analizado es identico al
     * que ya este en la lista y si no esta lo agrega.
     *
     * @param moneda Es el objeto de tipo Moneda
     * @throws ElementoDuplicadoException Es la excepcion de error que saltara cuando halla una modeda identica
     */
    public void guardarMonedaEquals(Moneda moneda) throws ElementoDuplicadoException {
        boolean contiene = false; // para saber si esta el objeto igual

        for (Moneda monedaArray : monedas) { // se itera todo el array para verificar el contenido
            if (monedaArray.equals(moneda)) contiene = true; // verifica que la moneda no existe en el arrayList
        }
        if (contiene) {
            throw new ElementoDuplicadoException("La moneda de valor " + moneda.getValor() + " ya existe, No se agregara a la lista.");
        } else monedas.add(moneda); // agrega las monedas que no sean iguales
    }


    /**
     * Este metodo guardara una moneda en la lista usando el metodo creado 'esIgual' el cual compara el valor hashCode del
     * objeto a insertar con los que ya estan dentro de la lista, si el valor del hasCode es igual saltara la excepcion
     * de que se esta intentando insertar un objeto igual a uno que esta ya incluido en la lista.
     *
     * @param moneda Es el objeto de tipo Moneda
     * @throws ElementoDuplicadoException Es la excepcion de error que saltara cuando halla una modeda identica
     */
    public void guardarMonedaEsIgual(Moneda moneda) throws ElementoDuplicadoException {
        boolean contiene = false; // para saber si esta el objeto igual

        for (Moneda monedaArray : monedas) { // se itera todo el array para verificar el contenido
            if (monedaArray.esIgual(moneda)) contiene = true; // verifica que la moneda no existe en el arrayList
        }
        if (contiene) {
            throw new ElementoDuplicadoException("La moneda de valor " + moneda.getValor() + " ya existe, No se agregara a la lista.");
        } else monedas.add(moneda); // agrega las monedas que no sean iguales

    }


    public void mostrarDatos() {
        // mostrara el contenido del arrayList usando un FOREACH
        for (Moneda moneda : monedas) {
            System.out.println(moneda);
        }
    }


    /**
     * El metodo ordenara de manera decreciente (de mayor a menor), orden natural configurado en el metodo 'compareTo'
     * que esta en la clase 'Monedas'
     * El parametro que se le pasa al metodo estatico 'Collections.sort()' sera de tipo lista que en este caso es un
     * arrayList para ordenarlo
     */
    public void ordenarPorValor() {
        // metodo estatico basico
        Collections.sort(monedas);
    }


    /**
     * Este metodo ordenara por letra, en este caso, para ordenar por ello se usara la clase 'AlfabeticComparator' la cual
     * en este caso estara como clase anonima
     */
    public void ordenarPorAlfabeto() {
        // ordenara por letra en el orden especificado en la clase 'Moneda'
        Collections.sort(monedas, new AlfabeticComparator());
    }


    /**
     * Este metodo ordenara por fecha, en este caso, para ordenar por ello se usa una clase anonima 'Comparator'
     * en donde se sobrescribira para poder obtener el orden que se necesita
     */
    public void ordenarPorFecha() {
        Collections.sort(monedas, new Comparator<Moneda>() {
            @Override
            public int compare(Moneda moneda1, Moneda moneda2) {
                return moneda1.getFecha().compareTo(moneda2.getFecha()); // compara para ordenar por letras
            }
        });
        /**Este metodo al usar una clase anonima de un solo metodo se puede convertir en las 2 opciones mostradas abajo
         * metodo lambda      ==>> Collections.sort(monedas, (moneda1, moneda2) -> moneda1.getImagen().compareTo(moneda2.getImagen()));
         * metodo Comparator  ==>> Collections.sort(monedas, Comparator.comparing(Moneda::getImagen));          */
    }


    /**
     * En este metodo sobre escrito se iterara segun la configuracion
     *
     * @return devolvera true o false, en donde true significa que aun hay elementos a recorrer y false en donde ya no
     * hay mas y por lo tanto el arrayList ya ha sido recorrido totalmente
     */
    @Override
    public Iterator<Moneda> iterator() {
        return monedas.iterator();
    }


    /**
     * Este metodo sobrescrito del Iterator recibira, en este caso un dato de tipo entero que servira para que solo
     * se iteren los objetos que tengan un valor igual o superior al dato pasado
     *
     * @param minVal sera el valor minimo pasado para iterar los objetos
     * @return devolvera el objeto iterado
     */
    public Iterator<Moneda> iterarPorValor(int minVal) {
        return new Iterator<Moneda>() { //clase anonima
            int indice = 0; // servira para poder recorrer el arrayList

            @Override
            public boolean hasNext() {
                boolean resultado = false;
                /**aqui el bucle seguira mientras el indice sea menor que el tamaño del array o que el resultado sea true */
                while (indice < monedas.size() && !resultado) {
                    /**aqui se verifica que el valor de la moneda sea siempre mayor o igual al valor minimo pasado
                     *esto indica que esta buscando objetos con un atributo 'valor' menor que el ingresado (minVal)
                     * y si lo encuentra el resultado pasa a ser true que indicara al bucle que se detenga, por lo
                     * tanto no se mostraran los objetos que tengan el atributo valor menor que el pasado*/
                    if (monedas.get(indice).getValor() >= minVal) resultado = true;
                        //aqui si no se cumple lo anterior, se itera con normalidad el array
                    else indice++;
                }
                return resultado;
            }

            @Override
            public Moneda next() {
                // aqui el indice servira para ir moviendo(avanzando) de posicion el arrayList
                return monedas.get(indice++);
            }
        };
    }


    /**
     * Este metodo obtendra el indice de posicion del objeto dentro de la lista
     *
     * @param moneda Sera el objeto moneda pasado como parametro
     * @return Devolvera un valor de tipo entero que sera el indice de la posicion del objeto en el arrayList
     */
    public int indexOf(Moneda moneda) {
        return monedas.indexOf(moneda);
    }
    /**
     * NOTA: El metodo implementado 'indexOf' utiliza el metodo 'equals' para poder ubicar un objeto pasado como parametro.
     * Usando la condicional if para verificar que el objeto no sea nulo y un bucle for para poder recorrer el arraylist o
     * la lista, comparando cada indice de la lista con el indice de un objeto 'elementData', devolviendo un numero entero
     * para indicar si se encuentra o no el objeto en la lista, si retorna -1 significara que el objeto no existe.
     *
     * public int indexOf(Object o) {
     *     if (o == null) {
     *         for (int i = 0; i < size; i++)
     *             if (elementData[i]==null)
     *                 return i;
     *     } else {
     *         for (int i = 0; i < size; i++)
     *             if (o.equals(elementData[i]))
     *                 return i;
     *     }
     *     return -1;
     * }
     *
     * Por tanto, desde mi punto de vista este metodo no usa el codigo generado 'hashCode' para ubicar un objeto identico
     * en la lista pasada.
     * */

}










