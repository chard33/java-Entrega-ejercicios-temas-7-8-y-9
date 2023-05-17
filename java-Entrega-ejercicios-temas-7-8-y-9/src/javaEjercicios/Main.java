package javaEjercicios;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        System.out.println(reverse("Hola mundo"));

        String[] cadenas = {
                "cadena1",
                "cadena2",
                "cadena3",
                "cadena4",
                "cadena5"
        };

        System.out.println("Arreglo unidimensional");
        for (String cadena : cadenas) {
            System.out.println(cadena);
        }


        int[][] enteros = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };

        System.out.println("Arreglo bidimensional");
        for (int[] enterosArreglo : enteros) {
            for (int entero : enterosArreglo) {
                System.out.println(entero);
            }
        }

        //Con el uso de vectores, entre cada aumento de capacidad se van generando copias del vector generando un mayor aumento de recursos.

        Vector<Integer> vector = new Vector<Integer>();

        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);

        vector.remove(1);
        vector.remove(2);

        System.out.println("Estructura Vector");
        for (int entero : vector) {
            System.out.println(entero);
        }


        ArrayList<String> ArregloL = new ArrayList<String>();
        ArregloL.add("uno");
        ArregloL.add("dos");
        ArregloL.add("tres");
        ArregloL.add("cuatro");

        LinkedList<String> listaL = new LinkedList<String>(ArregloL);

        System.out.println("Estructura ArrayList");
        for (String elemento : ArregloL) {
            System.out.println(elemento);
        }

        System.out.println("Estructura LinkedList");
        for (String elemento : listaL) {
            System.out.println(elemento);
        }

//        for (int i = 0; i < ArregloL.size(); i++) {
//
//            System.out.println(ArregloL.get(i));
//        }

//        for (int i = 0; i < listaL.size(); i++) {
//
//            System.out.println(listaL.get(i));
//        }

        ArrayList<Integer> listaE = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {

            listaE.add(i + 1);
        }

        for (int i = 0; i < listaE.size(); i++) {

            if(listaE.get(i) % 2 == 0){
                listaE.remove(listaE.indexOf(listaE.get(i)));
            }
        }

        System.out.println("Estructura ArrayList");

        listaE.forEach(elemento -> System.out.println(elemento));

        try {

            int resultado = DividePorCero(4, 0);
        }catch (Exception e){

            System.out.println("Esto no puede hacerse");
        }finally {

            System.out.println("Demo de código");
        }

        copiaFichero("Ficheros/ficheroOriginal.txt", "Ficheros/ficheroCopia.txt");
    }

    public static String reverse(String texto) {

        String resultado = "";

        for (int i = texto.length(); i > 0; i--) {
            resultado += texto.charAt(i - 1);
        }

        return resultado;
    }

    public static int DividePorCero(int a, int b) throws ArithmeticException {

        return a /b;
    }

    public static void copiaFichero(String fileIn, String fileOut){

        try {

            InputStream ficheroE = new FileInputStream(fileIn);
            BufferedInputStream ficheroB = new BufferedInputStream(ficheroE);

            PrintStream ficheroS = new PrintStream(fileOut);
            ficheroS.write(ficheroB.readAllBytes());

            ficheroS.close();
            ficheroB.close();
            ficheroE.close();

        }catch (Exception e){

            System.out.println(e.getMessage());
        }
    }
}
