/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo5apuntes;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class Ejemplo5Apuntes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here

        int suma = 0;
        int total = 0;
        LocalTime horaInicio;
        LocalTime horaFin;
        long tiempo;
        int vector[] = new int[100000000];

        for (int i = 0; i < vector.length; i++) {
            int num = (int) (Math.random() * 10);
            vector[i] = num;
        }
        horaInicio = LocalTime.now();
        for (int i = 0; i < vector.length; i++) {
            total += vector[i];
        }
        horaFin = LocalTime.now();
        tiempo = ChronoUnit.MILLIS.between(horaInicio, horaFin);
        System.out.println("Tiempo sin Hilos: " + tiempo + " Suma:" + total);

        int cuarto = vector.length / 4;
        Hilo miHilo1 = new Hilo(0, cuarto - 1, vector);
        Hilo miHilo2 = new Hilo(cuarto, (cuarto * 2) - 1, vector);
        Hilo miHilo3 = new Hilo(cuarto * 2, (cuarto * 3) - 1, vector);
        Hilo miHilo4 = new Hilo(cuarto * 3, (cuarto * 4)-1, vector);
        horaInicio = LocalTime.now();
        miHilo1.start();
        miHilo2.start();
        miHilo3.start();
        miHilo4.start();

        miHilo1.join();
        miHilo2.join();
        miHilo3.join();
        miHilo4.join();

        horaFin = LocalTime.now();
        suma = miHilo1.getSuma() + miHilo2.getSuma() + miHilo3.getSuma() + miHilo4.getSuma();
        tiempo = ChronoUnit.MILLIS.between(horaInicio, horaFin);
        System.out.println("Tiempo con Hilos: " + tiempo + " Suma:" + suma);
    }

}

class Hilo extends Thread {

    private int inicio;
    private int fin;
    private int suma;
    private int[] vector;

    public Hilo(int inicio, int fin, int[] vector) {
        this.inicio = inicio;
        this.fin = fin;
        this.vector = vector;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public int[] getVector() {
        return vector;
    }

    public void setVector(int[] vector) {
        this.vector = vector;
    }

    @Override
    public void run() {
        int total = 0;
        for (int i = inicio; i <= fin; i++) {
            total += vector[i];
        }
        this.suma = total;
    }

}
