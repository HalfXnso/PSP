/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploproductorconsumidor;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class EjemploProductorConsumidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Contenedor miContentedor = new Contenedor();
        
        Productor productor = new Productor(miContentedor);
        Consumidor consumidor = new Consumidor(miContentedor);
        
        productor.start();
        consumidor.start();
    }

}

class Productor extends Thread {

    private Contenedor contenedor;

    public Productor(Contenedor contenedor) {
        this.contenedor = contenedor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                contenedor.put(i);
            } catch (InterruptedException ex) {
            }
        }
    }
}

class Consumidor extends Thread {

    private Contenedor contenedor;

    public Consumidor(Contenedor contenedor) {
        this.contenedor = contenedor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                contenedor.get();
            } catch (InterruptedException ex) {
            }
        }
    }
}

class Contenedor {

    private int dato;
    private boolean hayDato = false;

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public boolean isHayDato() {
        return hayDato;
    }

    public void setHayDato(boolean hayDato) {
        this.hayDato = hayDato;
    }

    public synchronized int get() throws InterruptedException {
        if (!hayDato) {
            wait();
        }
        sleep((int) (Math.random() * 2000));
        hayDato = false;
        String mensaje ="";
        switch(this.dato){
            case 1:mensaje =" me la comes como ninguno";break;
            case 2:mensaje =" comemelos";break;
            case 3:mensaje =" me la coges del revés";break;
            case 4:mensaje =" agarramela un rato";break;
            case 5:mensaje =" por el culo te la hinco";break;
            case 6:mensaje =" me la agarras del jersey";break;
            case 7:mensaje =" por el culo se te mete";break;
            case 8:mensaje =" por el culo te la 'entocho'";break;
            case 9:mensaje =" por el culo se te mueve";break;
            case 0:mensaje =" me la pones como el acero";break;
        
        }
        System.out.println("Consumido dato: " + this.dato + mensaje);
        notifyAll();
        return dato;
    }

    public synchronized void put(int valor) throws InterruptedException {
        if (hayDato) {
            wait();
        }
        sleep((int) (Math.random() * 2000));
        this.dato = valor;
        hayDato = true;
        System.out.println("Dato producido: " + this.dato);
        notifyAll();
    }

}
