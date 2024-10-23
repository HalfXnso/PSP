/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3t3pspservicio;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class Ejercicio3T3PSPServicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        int numPuerto = 6000;
        ServerSocket servidor = new ServerSocket(numPuerto);

        System.out.println("Esperando conexion del cliente");
        Socket clienteConectado = servidor.accept();
        DataOutputStream salida = new DataOutputStream(clienteConectado.getOutputStream());

        for (int i = 0; i < 5; i++) {
            int numero = (int) (Math.random() * 100);

            salida.writeInt(numero);

        }
        salida.close();
        clienteConectado.close();
        servidor.close();
    }

}
