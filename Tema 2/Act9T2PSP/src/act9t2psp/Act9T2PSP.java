/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act9t2psp;

import static java.lang.Thread.sleep;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class Act9T2PSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Paella miContentedor = new Paella();

        Productor productor = new Productor(miContentedor);
        Consumidor consumidor = new Consumidor(miContentedor);

        productor.start();
        consumidor.start();
        
        LocalTime inicio = LocalTime.now();
        
        productor.join();
        consumidor.join();
        LocalTime fin = LocalTime.now();
        long tiempo = ChronoUnit.MILLIS.between(inicio, fin);
        System.out.println("Tiempo en servir: "+ tiempo);
        
    }

}

class Productor extends Thread {

    private Paella contenedor;

    public Productor(Paella contenedor) {
        this.contenedor = contenedor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                contenedor.servirRacion(i);
            } catch (InterruptedException ex) {
            }
        }
    }
}

class Consumidor extends Thread {

    private Paella contenedor;

    public Consumidor(Paella contenedor) {
        this.contenedor = contenedor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                contenedor.cogerRacion();
            } catch (InterruptedException ex) {
            }
        }
    }
}

class Paella {

    private int numRacion;
    private boolean hayRacion = false;

    public synchronized int cogerRacion() throws InterruptedException {
        if (!hayRacion) {
            wait();
        }
        sleep(100);
        hayRacion = false;
        System.out.println("Ración consumida: " + numRacion);
        notifyAll();
        return numRacion;
    }

    public synchronized void servirRacion(int numRacion) throws InterruptedException {
        if (hayRacion) {
            wait();
        }
        sleep(200);
        this.numRacion = numRacion;
        hayRacion = true;
        System.out.println("Dato producido: " + this.numRacion);
        notifyAll();

    }

}
