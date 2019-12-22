package principal;

import clases.Moneda;
import clases.Monedas;
import excepciones.ElementoDuplicadoException;
import generica.Contenedor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import static metodos_constantes.Metodos.parseFecha;

public class Main {
    public static void main(String[] args) {

        Moneda m1 = new Moneda(5, "Moneda", "5 centimos de España", "Catedral de Santiago de Compostela", parseFecha("01/01/2000"));
        Moneda m2 = new Moneda(10, "Moneda", "10 centimos de España", "Miguel de Cervantes", parseFecha("02/02/2010"));
        Moneda m3 = new Moneda(20, "Moneda", "20 centimos de Andorra", "Iglesia románica de Santa Coloma", parseFecha("03/03/2008"));
        Moneda m4 = new Moneda(50, "Moneda", "50 centimos de la Ciudad del Vaticano", "El papa Francisco", parseFecha("04/04/2017"));
        Moneda m5 = new Moneda(1, "Moneda", "1 euro de Alemania", "El águila", parseFecha("05/05/2006"));
        Moneda m6 = new Moneda(2, "Moneda", "2 euros de Irlanda", "El arpa céltica", parseFecha("03/03/2009"));
        Moneda m7 = new Moneda(2, "Moneda", "2 euros de Irlanda", "El arpa céltica", parseFecha("03/03/2009"));

        Monedas monedas = new Monedas();

        try {
            // Comentar un grupo para verificar los diferentes metodos de agregado a la lista.

//            monedas.guardarMonedaContains(m1);
//            monedas.guardarMonedaContains(m2);
//            monedas.guardarMonedaContains(m3);
//            monedas.guardarMonedaContains(m4);
//            monedas.guardarMonedaContains(m5);
//            monedas.guardarMonedaContains(m6);
//            monedas.guardarMonedaContains(m7);


//            monedas.guardarMonedaEquals(m1);
//            monedas.guardarMonedaEquals(m2);
//            monedas.guardarMonedaEquals(m3);
//            monedas.guardarMonedaEquals(m4);
//            monedas.guardarMonedaEquals(m5);
//            monedas.guardarMonedaEquals(m6);
//            monedas.guardarMonedaEquals(m7);


            monedas.guardarMonedaEsIgual(m1);
            monedas.guardarMonedaEsIgual(m2);
            monedas.guardarMonedaEsIgual(m3);
            monedas.guardarMonedaEsIgual(m4);
            monedas.guardarMonedaEsIgual(m5);
            monedas.guardarMonedaEsIgual(m6);
            monedas.guardarMonedaEsIgual(m7);

        } catch (ElementoDuplicadoException e) {
            System.out.printf("ERROR: " + e.getMessage()); // mostrara el mensaje de la excepcion personalizada creada
        }


        System.out.println("\n========================================");
        System.out.println("MUESTRA SIN APLICAR NADA");
        monedas.mostrarDatos();

        System.out.println("========================================");
        System.out.println("MUESTRA ORDENADA POR VALOR DE LA MONEDA (VALOR) - ORDEN DECRECIENTE");
        monedas.ordenarPorValor();
        monedas.mostrarDatos();

        System.out.println("========================================");
        System.out.println("MUESTRA ORDENADA POR LAS LETRAS DEL CAMPO IMAGEN (ALFABETICO)");
        monedas.ordenarPorAlfabeto();
        monedas.mostrarDatos();

        System.out.println("========================================");
        System.out.println("MUESTRA ORDENADA POR FECHA (CRONOLOGICO)");
        monedas.ordenarPorFecha();
        monedas.mostrarDatos();

        System.out.println("========================================");
        System.out.println("MUESTRA RECORRIDA CON ITERADOR (ITERATOR)");

        Iterator<Moneda> it1 = monedas.iterator();
        while (it1.hasNext()){
            Moneda moneda = it1.next();
            System.out.println(moneda);
        }

        System.out.println("========================================");
        System.out.println("ITERANDO CON FOREACH");

        for (Moneda moneda: monedas) {
            System.out.println(moneda);
        }

        System.out.println("========================================");
        System.out.println("MUESTRA RECORRIDA CON ITERADOR CON VALOR NIMINO DE LA MONEDA");

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese 'Valor' minimo de atributo para iterar los objetos: ");
        int minVal = sc.nextInt();

        Iterator<Moneda> it2 = monedas.iterarPorValor(minVal);
        while (it2.hasNext()){
            Moneda moneda = it2.next();
            System.out.println(moneda);
        }

        System.out.println("========================================");
        System.out.println("USANDO METODO CREADO indexOf");

        ArrayList<Moneda> otrasMonedas = monedas.getMonedas();
        for (int i = 0; i < otrasMonedas.size(); i++) {
            System.out.println("La moneda de " + otrasMonedas.get(i).getValor() + " se encuentra en el indice: " +  monedas.indexOf(otrasMonedas.get(i)));
        }

    }

}
