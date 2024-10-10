/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2t2psp;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class Ejercicio2T2PSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        Hilo miHilo = new Hilo(1);
        miHilo.start();
        Hilo miHilo2 = new Hilo(2);
        miHilo2.start();
        Hilo miHilo3 = new Hilo(3);
        miHilo3.start();
        Hilo miHilo4 = new Hilo(4);
        miHilo4.start();
        
        miHilo.join();
        miHilo2.join();
        miHilo3.join();
        miHilo4.join();
        System.out.println("---------------------------------");
System.out.println("Número de intentos del jugador " +
        miHilo.getJugador() + ": " + miHilo.getNumIntentos());
System.out.println("Número de intentos del jugador " +
        miHilo2.getJugador() + ": " + miHilo2.getNumIntentos());
System.out.println("Número de intentos del jugador " +
        miHilo3.getJugador() + ": " + miHilo3.getNumIntentos());
System.out.println("Número de intentos del jugador " +
        miHilo4.getJugador() + ": " + miHilo4.getNumIntentos());

    }

}

class Hilo extends Thread {

    private int jugador;
    int sumaTiradas = 0;
    private int numIntentos;

    public Hilo(int jugador) {
        this.jugador = jugador;
    }

    public int getJugador() {
        return jugador;
    }

    public int getNumIntentos() {
        return numIntentos;
    }

    public void setNumIntentos(int numIntentos) {
        this.numIntentos = numIntentos;
    }

    @Override
    public void run() {
        do {
            sumaTiradas = 0;
            numIntentos++;
            String dados = "";
            for (int i = 0; i < 6; i++) {
                int numeroDado = (int) (Math.random() * 6) + 1;
                sumaTiradas += numeroDado;
                dados += numeroDado + " ";
            }
            this.setNumIntentos(numIntentos);
            System.out.println("Dados del jugador"
                    + this.getJugador() + ": " + dados + " Suma de dados: " + sumaTiradas);
        } while (sumaTiradas != 36);
    }
}
