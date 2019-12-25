package principal;

import clases.Moneda;
import excepciones.ElementoDuplicadoException;
import generica.ContenedorOtro;

import static metodos_constantes.Metodos.parseFecha;

public class MainOtro {
    public static void main(String[] args) {

        Moneda m1 = new Moneda(5, "Moneda", "5 centimos de España", "Catedral de Santiago de Compostela", parseFecha("01/01/2000"));
        Moneda m2 = new Moneda(10, "Moneda", "10 centimos de España", "Miguel de Cervantes", parseFecha("02/02/2010"));
        Moneda m3 = new Moneda(20, "Moneda", "20 centimos de Andorra", "Iglesia románica de Santa Coloma", parseFecha("03/03/2008"));
        Moneda m4 = new Moneda(50, "Moneda", "50 centimos de la Ciudad del Vaticano", "El papa Francisco", parseFecha("04/04/2017"));
        Moneda m5 = new Moneda(1, "Moneda", "1 euro de Alemania", "El águila", parseFecha("05/05/2006"));
        Moneda m6 = new Moneda(2, "Moneda", "2 euros de Irlanda", "El arpa céltica", parseFecha("03/03/2009"));
        Moneda m7 = new Moneda(2, "Moneda", "2 euros de Irlanda", "El arpa céltica", parseFecha("03/03/2009"));


        ContenedorOtro<Moneda> contenedor = new ContenedorOtro<>();
        try {
            contenedor.guardarDatoGenerico(m1);
            contenedor.guardarDatoGenerico(m2);
            contenedor.guardarDatoGenerico(m3);
            contenedor.guardarDatoGenerico(m4);
            contenedor.guardarDatoGenerico(m5);
            contenedor.guardarDatoGenerico(m6);
            contenedor.guardarDatoGenerico(m7);
        } catch (ElementoDuplicadoException e) {
            e.printStackTrace();
        }

        System.out.println("========================================");
        System.out.println("CLASE GENERICA - METODDO HEREDADO - DATOS SIN ORDENAR");
        contenedor.mostrarDatos();


        System.out.println("========================================");
        System.out.println("CLASE GENERICA - METODDO HEREDADO - ORDENANDO POR ORDEN NATURAL - VALOR");
        contenedor.ordenarPorValor();
        contenedor.mostrarDatos();















    }
}
