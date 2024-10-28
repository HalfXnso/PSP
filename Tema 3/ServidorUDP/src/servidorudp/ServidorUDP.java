/** *
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorudp;

import java.io.IOException;
import java.net.*;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class ServidorUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException, IOException {
        // TODO code application logic here

        int puerto = 6789;
        DatagramSocket socketUdp = new DatagramSocket(puerto);
        // Creamos array de bytes para recuperar el mensaje del cliente
        byte[] buffer = new byte[1000];
        //Mostramos mensaje esperando conexión.

        System.out.println("Esperando paquetes(pililas)");

        // Creamos datagframa para recibir paquetes(pelilas)
        DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);

        // Recibimos el paquetón de negro
        socketUdp.receive(paqueteRecibido);
        // Recuperamos del datagrama el mensaje el host y el puerto

        InetAddress hostCliente = paqueteRecibido.getAddress();

        int puertoCliente = paqueteRecibido.getPort();
        String mensajeRecibidoEspacios = new String(paqueteRecibido.getData());

        String mensajeRecibido = mensajeRecibidoEspacios.trim();

        System.out.println(mensajeRecibidoEspacios);
        System.out.println(mensajeRecibido);
        System.out.println(hostCliente);
        System.out.println(puertoCliente);
        
        String MENSAJERECIBIDO = mensajeRecibido.toUpperCase();
        byte[] bytesRespuesta = MENSAJERECIBIDO.getBytes();
        DatagramPacket paqueteRespuesta = new DatagramPacket(bytesRespuesta,bytesRespuesta.length, hostCliente,puertoCliente);
        
        
        socketUdp.send(paqueteRecibido);
        
        // recuperamos el mensaje en mayúsculas
        socketUdp.close();
    }
}
