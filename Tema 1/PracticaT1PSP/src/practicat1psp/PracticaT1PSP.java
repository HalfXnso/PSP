/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicat1psp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class PracticaT1PSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
        Scanner tec = new Scanner(System.in);
        System.out.print("Introduce el nombre de la foto a convertir: ");
        String foto = tec.nextLine() + ".jpg";

        System.out.print("Introduce el nuevo nombre de la foto: ");
        String fotoConvertida = tec.nextLine() + ".png";

        System.out.println("Porcentaje de escalado: ");
        String porcentaje = tec.nextLine();

        System.out.print("¿Rotar imagen? (S) o (N)");
        String rotacion = tec.nextLine();

        if (rotacion.equals("S")) {
            rotacion = "-flip";
        } else {
            rotacion = "flip";
        }
        String[] comando = {"magick", "convert", foto, "-resize", porcentaje, rotacion, fotoConvertida};
        // Creamos el proceso que lanza el comando DIR EN EL CMD
        Process p = new ProcessBuilder(comando).start();
        //Establecemos flujo de comunicación de entrada con el proceso
        InputStream entrada = p.getInputStream();
        //Leemos caracter a caracter la salida del proceso
        int caracter;
        while ((caracter = entrada.read()) != -1) {
            System.out.print((char) caracter);

        }
        //Cerramos el flujo de datos
        entrada.close();
        //Establecemos un flujo sobre el proceso que obtiene el mensaje de error de la ejecución
        InputStream error = p.getErrorStream();
        while ((caracter = error.read()) != -1) {
            System.out.print((char) caracter);
        }
        //Comprobamos si la ejecución ha sido correcta con el método .waitFor()
        int codEjecucion = p.waitFor();
        System.out.println("\nValor de ejecución: " + codEjecucion);
    }
}


