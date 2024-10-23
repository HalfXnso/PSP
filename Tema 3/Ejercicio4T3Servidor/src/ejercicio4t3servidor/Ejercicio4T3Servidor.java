/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4t3servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class Ejercicio4T3Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String[] corredores = {"Edgal", "Carloes", "Demonio", "Joel(Fugado)"};
        int numPuerto = 6000;
        ServerSocket servidor = new ServerSocket(numPuerto);

        System.out.println("Esperando conexion del cliente");
        Socket clienteConectado = servidor.accept();

        DataInputStream entrada = new DataInputStream(clienteConectado.getInputStream());

        DataOutputStream salida = new DataOutputStream(clienteConectado.getOutputStream());
        String resultado = "El valor que corresponde a la posición " + entrada.readInt() + " es: "
                + corredores[entrada.readInt()];

        salida.writeUTF(resultado);

        salida.close();
        entrada.close();
        clienteConectado.close();
        servidor.close();
        System.out.println("Callate");

    }

}
