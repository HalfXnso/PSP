/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicat2psp;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class PracticaT2PSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Hilo miHilo1 = new Hilo();
        miHilo1.setName("equipo 1");
        miHilo1.start();
        miHilo1.join();
        Hilo miHilo2 = new Hilo();
        miHilo2.setName("equipo 2");
        miHilo2.start();
        miHilo2.join();

    }

}

class Hilo extends Thread {

    @Override
    public void run() {

        int puntosTotales = 0;
        int tiroLibre = 0;
        int tiroDeCampo = 0;
        int triple = 0;
        int tiroFallado = 0;
        for (int i = 0; i < 150; i++) {
            int tiro = (int) (Math.random() * 100) + 1;
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {}
                if (tiro <= 30) {
                    tiroFallado++;
                    System.out.println("Tiro fallado por parte del "+this.getName());
                } else if (tiro <= 50) {
                    puntosTotales += 1;
                    tiroLibre++;
                    System.out.println("Tiro libre acertado por parte del ."+this.getName());
                } else if (tiro <= 90) {
                    puntosTotales += 2;
                    tiroDeCampo++;
                    System.out.println("Tiro de campo acertado por parte del ."+this.getName());
                } else if (tiro <= 100) {
                    puntosTotales += 3;
                    triple++;
                    System.out.println("TRIIIIIIPLEEEEEE del "+this.getName());
                }
            

        }
        System.out.println("\n");
        System.out.println("Partido terminado para el "+this.getName());
        System.out.println("Puntos del " + this.getName() + ": ");
        System.out.println("Tiros fallados: " + tiroFallado);
        System.out.println("Tiros libres acertados: " + tiroLibre);
        System.out.println("Tiros de campo acertados: " + tiroDeCampo);
        System.out.println("Triples acertados: " + triple);
        System.out.println("Puntuación total: " + puntosTotales);
        System.out.println("\n");

    }

}
