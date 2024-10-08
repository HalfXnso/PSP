/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4t1psp;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class Ejercicio4T1PSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        Process p = new ProcessBuilder("CMD","/C","START tasklist").start();
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
