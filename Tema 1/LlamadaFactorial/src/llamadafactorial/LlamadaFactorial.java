
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AlfonsoGaitanPerez
 */
public class LlamadaFactorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        Process p = new ProcessBuilder("java", "Factorial").start();
        //Creamos un flujo de salida sobre el proceso con .OutputStream

        OutputStream salida = p.getOutputStream();
        // enviamos por el flujo de salida un 2 con \n  convertido en bytes
        salida.write("5\n".getBytes());
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
