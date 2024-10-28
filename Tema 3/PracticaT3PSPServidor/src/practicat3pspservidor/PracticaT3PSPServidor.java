/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicat3pspservidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class PracticaT3PSPServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
        int numPuerto = 6000;
        int numIntentos = 0;
        int numero = (int) (Math.random() * 10);
        boolean acierto = false;
        
        ServerSocket servidor = new ServerSocket(numPuerto);
        System.out.println("Esperando conexion del cliente");
        Socket clienteConectado = servidor.accept();
        
        DataInputStream datoRecibido = new DataInputStream(clienteConectado.getInputStream());
        LocalTime tiempoInicio = LocalTime.now();
        
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            int numeroRecibido = datoRecibido.readInt();
            System.out.println(numeroRecibido + " - " + numero);
            if (numeroRecibido != numero) {
                System.out.println("Número incorrecto.");
                numIntentos++;
            } else {
                LocalTime tiempoFinal = LocalTime.now();
                acierto = true;
                System.out.println("Número acertado ");
                System.out.println("Tiempo tardado en adivinar: " + ChronoUnit.MILLIS.between(tiempoInicio, tiempoFinal));
                System.out.println("Número de intentos: " + numIntentos);
                break;

            }
        }
        if (!acierto) {
            System.out.println("No tienes más intentos.");
        }
        datoRecibido.close();
        clienteConectado.close();
        servidor.close();
    }

}
