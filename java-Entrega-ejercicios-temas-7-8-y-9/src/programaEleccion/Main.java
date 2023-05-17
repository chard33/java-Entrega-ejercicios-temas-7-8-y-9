package programaEleccion;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    public static void main(String[] args){

        ArrayList<String> productos = new ArrayList<String>();
        HashMap<Integer, String> llaveV = new HashMap<Integer, String>();
        boolean pasa = false;

        do{
            try {

                menu(productos, llaveV);
                pasa = true;

            }catch (InputMismatchException e) {

                System.out.println("Ingrese valores validos");

            } catch (IOException e) {

                System.out.println("Error en fichero");
            }
        }while (!pasa);


    }

    public static void menu(ArrayList<String> productos, HashMap<Integer, String> llaveV) throws InputMismatchException, IOException {

        Scanner entrada = new Scanner(System.in);
        int opcion = 0;

        do {

            System.out.println("\t_.Menu de compra._\n");

            System.out.println("1. Ingresar productos");
            System.out.println("2. Imprimir recibo");
            System.out.println("3. Salir");
            System.out.print("Ingrese la opción: ");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Lista de compras");
                    entradaD(productos, llaveV);
                    System.out.println("Pedido exitoso!!!");
                    entrada.nextLine();
                    entrada.nextLine();
                    break;
                case 2:
                    impresionFichero();
                    System.out.println("Impresion exitosa!!!");
                    entrada.nextLine();
                    entrada.nextLine();
                    break;
                case 3:
                    System.out.println("Saliendo....");
                    System.exit(0);
                default:
                    System.out.println("Opcion no valida");
            }

        }while (opcion != 3);
    }

    public static void entradaD(ArrayList<String> productos, HashMap<Integer, String> llaveV) throws InputMismatchException, IOException {

        Scanner entrada = new Scanner(System.in);
        int cantidad = 0, contador = 0;

        System.out.print("Ingrese la cantidad de productos a comprar: ");
        cantidad = entrada.nextInt();

        while (contador < cantidad) {

            System.out.print("Producto " + (contador + 1) + ": ");
            productos.add(entrada.next());

            contador++;
        }

        for (int i = 0; i < productos.size(); i++) {

            llaveV.put((i+1), productos.get(i));
        }

        GenerarFichero(llaveV);
    }

    public static void GenerarFichero(HashMap<Integer, String> llaveV) throws IOException {

        PrintStream fichero = new PrintStream("Ficheros/listaCompras.txt");

        fichero.write("\t_.Lista de compras._\n\n".getBytes());

        for (Map.Entry<Integer, String> elemento : llaveV.entrySet()){

            fichero.write((elemento.getKey() + " = " + elemento.getValue() + " \n").getBytes());
        }

        fichero.close();
    }

    public static void impresionFichero() throws IOException {

        InputStream ficheroE = new FileInputStream("Ficheros/listaCompras.txt");
        BufferedInputStream ficheroB = new BufferedInputStream(ficheroE);
        byte[] archivo = ficheroB.readAllBytes();

        for (byte cadena : archivo) {

            System.out.print((char) cadena);
        }
    }
}
