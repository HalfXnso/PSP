/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package llamadaantonio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class LlamadaAntonio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Process p = new ProcessBuilder("java", "Antonio").start();
        //Creamos un flujo de salida sobre el proceso con .OutputStream

        OutputStream salida = p.getOutputStream();
        // enviamos por el flujo de salida un 2 con \n  convertido en bytes
        salida.write("2\n".getBytes());
        salida.flush();
        salida.close();

        //Creamos flujo de entrada con el resultado que devuelve el proceso Cuadrado
        InputStream entrada = p.getInputStream();
        //Bucler 00
        int caracter;
        while ((caracter = entrada.read()) != -1) {
            System.out.print((char) caracter);

        }
        entrada.close();
        
    }

}
