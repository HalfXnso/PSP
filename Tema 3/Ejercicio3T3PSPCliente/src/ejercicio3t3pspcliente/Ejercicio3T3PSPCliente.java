/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3t3pspcliente;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class Ejercicio3T3PSPCliente {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        Socket cliente = new Socket("localhost", 6000);
        System.out.println("Conectado al servidor");
        DataInputStream entrada = new DataInputStream(cliente.getInputStream());
        int numMayor = 0;
        for (int i = 0; i < 5; i++) {
            int num = entrada.readInt();
            System.out.println(num);
            if (num > numMayor) {
                numMayor = num;
            }

        }
        System.out.println("El número mayor es: " + numMayor);
        entrada.close();
        cliente.close();
    }

}
