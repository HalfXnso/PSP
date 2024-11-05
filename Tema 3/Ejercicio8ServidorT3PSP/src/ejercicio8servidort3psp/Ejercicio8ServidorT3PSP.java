/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio8servidort3psp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class Ejercicio8ServidorT3PSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
          ServerSocket servidor = new ServerSocket(6000);
        System.out.println("Servidor iniciado....");
        while(true){
            Socket servidorCliente = new Socket();
            servidorCliente = servidor.accept();
            
            Servidor hiloServidor = new Servidor(servidorCliente);
            hiloServidor.start();
            
        }
        
    }
    
}
class Servidor extends Thread {

    DataInputStream entrada;
    DataOutputStream salida;
    Socket socket = null;

    public Servidor(Socket s) throws IOException {

        this.socket = s;
        this.entrada = new DataInputStream(socket.getInputStream());
        this.salida = new DataOutputStream(socket.getOutputStream());

    }

    @Override
    public void run() {

        try {
            String cadena = "";
            System.out.println("Conexion: " + this.socket.toString());

            while (!cadena.trim().equals("*")) {
                cadena = entrada.readUTF();
                salida.writeUTF(cadena.trim().toUpperCase());
            }
            System.out.println("Fin Conexión: " + socket.toString());

            entrada.close();
            salida.close();
            socket.close();
        } catch (IOException ex) {
        }

    }

}