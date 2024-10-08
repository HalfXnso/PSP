/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplohilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class EjemploHilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hilo miHilo = new Hilo();
        miHilo.setName("Valencia basket");
        miHilo.start();
        Hilo miHilo2 = new Hilo();
        miHilo2.setName("Valencia baloncesto");
        miHilo2.start();
    }

}

class Hilo extends Thread {

    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            int tiempo = (int) (Math.random() * 5000) + 500;
            System.out.println(this.getName() + ": " + i);
            try {
                Thread.sleep(tiempo);
            } catch (InterruptedException ex) {

            }
        }
    }
}
