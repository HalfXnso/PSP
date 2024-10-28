/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicat3pspcliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class PracticaT3PSPCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        Socket cliente = new Socket("localhost", 6000);
        System.out.println("Conectado al servidor");
        DataOutputStream datoEnviado = new DataOutputStream(cliente.getOutputStream());
        for (int i = 0; i < 5; i++) {
            int numero = (int) (Math.random() * 10);
            datoEnviado.writeInt(i);
        }
        datoEnviado.close();
        cliente.close();
    }

}
