/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplohilosherencia;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class EjemploHilosHerencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hilo miHilo = new Hilo();
        miHilo.start();

        HiloHerencia hilo = new HiloHerencia();
        Thread miHilo2 = new Thread(hilo);
        miHilo2.start();

    }

}

class Hilo extends Thread {

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            int dado
                    = (int) (Math.random() * 6) + 1;
            System.out.println("Dado 1: " + dado);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
}
//Solo puedo utilizar la hiloherencia si la clase hereda de otra
class HiloHerencia implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            int dado
                    = (int) (Math.random() * 6) + 1;
            System.out.println("Dado 2: " + dado);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
}
