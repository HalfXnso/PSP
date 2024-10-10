/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio14t1psp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class Ejercicio14T1PSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
        // TODO code application logic here

        Hilo miHilo = new Hilo();
        LocalTime comienzo = LocalTime.now();
        miHilo.start();

        Hilo2 miHilo2 = new Hilo2();
        miHilo2.start();
        miHilo.join();
        miHilo2.join();
        LocalTime fin = LocalTime.now();

        double tiempo = ChronoUnit.MILLIS.between(comienzo, fin);
        tiempo /= 1000;
        System.out.println("\nTiempo:" + tiempo + "s");
    }

}

class Hilo extends Thread {

    @Override
    public void run() {

        try {
            File fichero = new File("lazarillo.txt");
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);

            String linea = "";
            while ((linea = br.readLine()) != null) {
                System.out.println(linea); // Imprimir la línea leída
            }
            Thread.sleep(3000);
        } catch (IOException e) {

        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class Hilo2 extends Thread {

    @Override
    public void run() {
        try {
            File fichero = new File("quijote.txt");
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            int caracter;
            while ((caracter = br.read()) != -1) {
                System.out.print((char) caracter);
            }
        } catch (IOException ex) {
            Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
