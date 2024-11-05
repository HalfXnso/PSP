/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio8clientet3psp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class Ejercicio8ClienteT3PSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner tec = new Scanner(System.in);

        Socket cliente = new Socket("localhost", 6000);

        DataInputStream entrada = new DataInputStream(cliente.getInputStream());

        DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());

        String cadena = "";
        while (!cadena.trim().equals("*")) {
            System.out.println("Introducir Texto: ");
            cadena = tec.nextLine();
            salida.writeUTF(cadena);
            String mayus = entrada.readUTF();
            System.out.println("Texto Convertido: " + mayus);

        }
        entrada.close();
        salida.close();
        cliente.close();
        System.out.println("Conexion finalizada");
    }

}
