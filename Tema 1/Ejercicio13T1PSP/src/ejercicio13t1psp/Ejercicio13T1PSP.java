/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio13t1psp;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class Ejercicio13T1PSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Caballo miCaballo = new Caballo(1);
        miCaballo.start();
        Caballo miCaballo2 = new Caballo(2);
        miCaballo2.start();
        Caballo miCaballo3 = new Caballo(3);
        miCaballo3.start();
        
    }

}

class Caballo extends Thread {

    private int progresion;
    private int numCaballo;
    private int tiempoEspera;

    public Caballo(int numCaballo) {
        this.progresion = progresion;
        this.numCaballo = numCaballo;

    }

    public int getProgresion() {
        return progresion;
    }

    public void setProgresion(int progresion) {
        this.progresion = progresion;
    }

    public int getNumCaballo() {
        return numCaballo;
    }

    public void setNumCaballo(int numCaballo) {
        this.numCaballo = numCaballo;
    }

    @Override
    public void run() {

        while (progresion < 100) {
            progresion += (int) (Math.random() * 5) + 5;
            int tiempo = (int) (Math.random() * 5000) + 500;
            System.out.println("Caballo " + this.getNumCaballo() + ": " + progresion + "%");
            try {
                Thread.sleep(tiempo);
            } catch (InterruptedException ex) {

            }
        }
    }
}
