/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio11t2;

import static java.lang.Thread.sleep;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class Ejercicio11T2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        Entrada miContentedor = new Entrada();

        Productor productor = new Productor(miContentedor);
        Consumidor consumidor = new Consumidor(miContentedor);

        productor.start();
        consumidor.start();

        LocalTime inicio = LocalTime.now();

        productor.join();
        consumidor.join();
        LocalTime fin = LocalTime.now();
        long tiempo = ChronoUnit.MILLIS.between(inicio, fin);
        System.out.println("Tiempo en servir: " + tiempo);
    }

}

class Entrada {

    private int entrada;
    private boolean hayEntrada = false;

    public synchronized int recogerEntrada() throws InterruptedException {
        if (!hayEntrada) {
            wait();
        }
        sleep(150);
        hayEntrada = false;
        System.out.println("Ticker recogido: " + entrada);
        notifyAll();
        return entrada;
    }

    public synchronized void servidarEntrada(int entrada) throws InterruptedException {
        if (hayEntrada) {
            wait();
        }
        sleep(300);
        this.entrada = entrada;
        hayEntrada = true;
        System.out.println("Ticket entregado: " + this.entrada);
        notifyAll();

    }
}

class Productor extends Thread {

    private Entrada contenedor;

    public Productor(Entrada contenedor) {
        this.contenedor = contenedor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            try {
                contenedor.servidarEntrada(i);
            } catch (InterruptedException ex) {
            }
        }
    }
}

class Consumidor extends Thread {

    private Entrada contenedor;

    public Consumidor(Entrada contenedor) {
        this.contenedor = contenedor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            try {
                contenedor.recogerEntrada();
            } catch (InterruptedException ex) {
            }
        }
    }
}
