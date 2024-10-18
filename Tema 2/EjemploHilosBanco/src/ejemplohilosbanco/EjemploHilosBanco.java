/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplohilosbanco;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class EjemploHilosBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Cuenta cuentaCompartida = new Cuenta(400);
        SacarDinero persona1 = new SacarDinero("Penelope", cuentaCompartida);
        persona1.start();
        SacarDinero persona2 = new SacarDinero("Juan", cuentaCompartida);
        persona2.start();
    }

}

class SacarDinero extends Thread {

    private Cuenta miCuenta;

    public SacarDinero(String nombre, Cuenta miCuenta) {
        super(nombre);
        this.miCuenta = miCuenta;

    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            miCuenta.retirarDinero(50, getName());
        }
    }
}

class Cuenta {

    private double saldo;

    public Cuenta(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void restarSaldo(double cantidad) {
        this.saldo -= cantidad;
    }

   synchronized public void retirarDinero(double cantidad, String nombre) {

        if (this.saldo >= cantidad) {
            System.out.println(nombre + " va a retirar efectivo. Saldo: " + this.getSaldo());

            restarSaldo(cantidad);
            System.out.println(nombre + " ha retirado " + cantidad + " €. Saldo: " + getSaldo());
        } else {
            System.out.println("☆*: .｡. o(≧▽≦)o .｡.:*☆" + nombre + " no puede retirar dinero. No hay saldo suficiente");
        }
        if (this.getSaldo() < 0) {
            System.out.println("☆*: .｡. o(≧▽≦)o .｡.:*☆ PUTO POBRE SALDO: " + this.getSaldo());
        }
        try{
        Thread.sleep(200);
        }catch(InterruptedException e){}
    }

}
