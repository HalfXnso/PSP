/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class ClienteUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        // TODO code application logic here
        DatagramSocket socketUDP = new DatagramSocket();
        String mensaje = "K dise tu pisha";
        byte[] mensajeBytes = mensaje.getBytes();
        // Declaramos dureccion y puerto del servidor al que enviaremos el mensaje
        InetAddress hostServidor = InetAddress.getByName("localhost");
        int puertoServidor = 6789;

        DatagramPacket paqueteEnvio = new DatagramPacket(mensajeBytes, mensajeBytes.length, hostServidor, puertoServidor);
        socketUDP.send(paqueteEnvio);

        byte[] buffer = new byte[1000];
        DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
        socketUDP.receive(paqueteRecibido);
        String mensajeEspacios = new String(paqueteRecibido.getData());
        
        String mensajeSinEspacios = mensajeEspacios.trim();
        
        System.out.println(mensajeEspacios);
        System.out.println(mensajeSinEspacios);
        
        
        socketUDP.close();
    }

}
