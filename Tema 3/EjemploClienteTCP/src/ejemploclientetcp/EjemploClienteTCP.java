/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploclientetcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class EjemploClienteTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        Socket cliente = new Socket("localhost",6000);
        System.out.println("Conectado al servidor");
        
        DataInputStream entrada = new DataInputStream(cliente.getInputStream());
        String mensaje = entrada.readUTF();
        //Mostramos el mensaje del servidor 
        System.out.println(mensaje);
        //Cerramos miFlujo
        entrada.close();
        cliente.close();
    }
    
}
