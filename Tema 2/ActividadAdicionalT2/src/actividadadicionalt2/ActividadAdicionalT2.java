package actividadadicionalt2;
import static java.lang.Thread.sleep;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
public class ActividadAdicionalT2 {

    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Paquete paquete = new Paquete();
        Repartidor repartidor = new Repartidor(paquete);
        Destinatario destinatario = new Destinatario(paquete);
        LocalTime tiempoEmpezar = LocalTime.now();
        repartidor.start();
        destinatario.start();
        repartidor.join();
        destinatario.join();
        LocalTime tiempoEsperado = LocalTime.now();
        long tiempo = ChronoUnit.MILLIS.between(tiempoEmpezar, tiempoEsperado);
        tiempo /=1000;
        System.out.println("Se ha tardado "+ tiempo+" segundos en repartir todos los productos.");
    }

}

class Repartidor extends Thread {

    private Paquete paquete;

    public Repartidor(Paquete paquete) {
        this.paquete = paquete;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                paquete.entregaPaquete(i);
            } catch (InterruptedException ex) {
            }
        }
    }
}

class Destinatario extends Thread {

    private Paquete paquete;

    public Destinatario(Paquete paquete) {
        this.paquete = paquete;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                paquete.recibePaquete();
            } catch (InterruptedException ex) {
            }
        }
    }
}

class Paquete {

    private int numPaquete;
    private boolean paqueteEntregado = false;

    public synchronized int recibePaquete() throws InterruptedException {
        if (!paqueteEntregado) {
            wait();
        }
        sleep((int) (Math.random() * 200) + 200);
        paqueteEntregado = false;
        System.out.println("Paquete nº" + this.numPaquete + " recibido.");
        notifyAll();
        return numPaquete;
    }

    public synchronized void entregaPaquete(int numPaquete) throws InterruptedException {
        if (paqueteEntregado) {
            wait();
        }
        sleep((int) (Math.random() * 1000) + 1000);
        this.numPaquete = numPaquete;
        paqueteEntregado = true;
        System.out.println("Paquete nº" + this.numPaquete + " entregado.");
        notifyAll();
    }
}
