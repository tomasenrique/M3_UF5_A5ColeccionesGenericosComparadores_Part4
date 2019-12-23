package principal;

import clases.Moneda;
import generica.Contenedor;

import java.util.ArrayList;

import static metodos_constantes.Metodos.parseFecha;

public class MainGenerico {
    public static void main(String[] args) {

        Moneda m1 = new Moneda(5, "Moneda", "5 centimos de España", "Catedral de Santiago de Compostela", parseFecha("01/01/2000"));
        Moneda m2 = new Moneda(10, "Moneda", "10 centimos de España", "Miguel de Cervantes", parseFecha("02/02/2010"));
        Moneda m3 = new Moneda(20, "Moneda", "20 centimos de Andorra", "Iglesia románica de Santa Coloma", parseFecha("03/03/2008"));
        Moneda m4 = new Moneda(50, "Moneda", "50 centimos de la Ciudad del Vaticano", "El papa Francisco", parseFecha("04/04/2017"));
        Moneda m5 = new Moneda(1, "Moneda", "1 euro de Alemania", "El águila", parseFecha("05/05/2006"));
        Moneda m6 = new Moneda(2, "Moneda", "2 euros de Irlanda", "El arpa céltica", parseFecha("03/03/2009"));
        Moneda m7 = new Moneda(2, "Moneda", "2 euros de Irlanda", "El arpa céltica", parseFecha("03/03/2009"));


        ArrayList<Moneda> monedasGenerica = new ArrayList<>(); // Se implementa la clase que contendra las monedas
        monedasGenerica.add(m1);
        monedasGenerica.add(m2);
        monedasGenerica.add(m3);
        monedasGenerica.add(m4);
        monedasGenerica.add(m5);
        monedasGenerica.add(m6);
        monedasGenerica.add(m7);

        System.out.println("========================================");
        System.out.println("CLASE GENERICA - DATOS SIN ORDENAR");
        Contenedor< ArrayList<Moneda>> contenedor = new Contenedor<>(monedasGenerica);
        contenedor.mostrarDatos();

        System.out.println("========================================");
        System.out.println("CLASE GENERICA ORDENANDO POR ORDEN NATURAL - VALOR");
        contenedor.ordenarPorValor();
        contenedor.mostrarDatos();


        System.out.println("========================================");
        System.out.println("CLASE GENERICA ORDENANDO POR LETRA");
        contenedor.ordenarPorAlfabeto();
        contenedor.mostrarDatos();

        System.out.println("========================================");
        System.out.println("CLASE GENERICA ORDENANDO POR FECHA");
        contenedor.ordenarPorFecha();
        contenedor.mostrarDatos();





//        // Se declara la clase generica que en este caso sera de tipo ArrayList de Monedas
//        Contenedor<ArrayList<Moneda>> contenedor = new Contenedor<>();
//        contenedor.setGenerico(monedasGenerica); // se agrega el objeto contenedor a la clase generica
//        System.out.println(contenedor.getGenerico()); // se muestra el contenido
    }
}
