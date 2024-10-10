/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio12t1psp;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class Ejercicio12T1PSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hilo miHilo1 = new Hilo(4, 150);
        miHilo1.start();

        Hilo miHilo2 = new Hilo(12, 100);
        miHilo2.start();

        Hilo miHilo3 = new Hilo(54, 200);
        miHilo3.start();

    }

}

class Hilo extends Thread {

    private int numero;
    private int tiempoEspera;

    public Hilo(int numero, int tiempoEspera) {
        this.numero = numero;
        this.tiempoEspera = tiempoEspera;
    }

    Hilo(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

        @Override
        public void run() {

            for (int i = 1; i < 11; i++) {
                int tiempo = (int) (Math.random() * 5000) + 500;
                System.out.println(this.getNumero() + " X " + i + "=" + (this.getNumero() * i));
                try {
                    Thread.sleep(this.getTiempoEspera());
                } catch (InterruptedException ex) {

                }
            }
        }
}
