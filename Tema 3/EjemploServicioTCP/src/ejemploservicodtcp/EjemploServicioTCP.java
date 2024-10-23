/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploservicodtcp;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class EjemploServicioTCP {

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
        String data = "Bienvenido al servidor, conexion realizada en Fecha: " + LocalDateTime.now();
        
        salida.writeUTF(data);
        salida.close();

        clienteConectado.close();
        servidor.close();
        System.out.println("Callate");
        
    }
}
