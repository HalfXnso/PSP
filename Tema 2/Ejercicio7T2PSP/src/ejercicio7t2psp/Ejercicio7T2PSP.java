/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7t2psp;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class Ejercicio7T2PSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Hilo[] misHilos = new Hilo[6];
        for (int i = 0; i < misHilos.length; i++) {
            misHilos[i] = new Hilo();
            misHilos[i].setName("Coche " + i);
            misHilos[i].start();
        }
    }

}

class Hilo extends Thread {

    @Override
    public void run() {

        double probabilidad;
        for (int i = 0; i < 50; i++) {
            int tiempo = (int) (Math.random() * 5000) + 500;
            if (!isInterrupted()) {
         System.out.println(this.getName() + "Vuelta: " + i + "de 50");
                probabilidad = Math.random();
                try {
                    Thread.sleep(tiempo);
                } catch (InterruptedException ex) {
                }
                if (probabilidad < 0.15) {
                    System.out.println("Hilo: " + this.getName() + " se estrelló");
                    interrupt();
                }
            }

        }
        if(!isInterrupted()){
        System.out.println(this.getName() + " ha terminado la carrera.");
        }
    }

}
