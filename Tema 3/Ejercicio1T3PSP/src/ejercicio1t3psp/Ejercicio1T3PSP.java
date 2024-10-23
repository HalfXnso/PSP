/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1t3psp;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class Ejercicio1T3PSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {
        Scanner tec = new Scanner(System.in);
        System.out.print("Escribe el nombre de un dominio: ");
        String dominao = tec.nextLine();
        InetAddress host = InetAddress.getByName(dominao);
        int punto = dominao.lastIndexOf(".");
        System.out.println(dominao.substring(punto));
        String significado = "";
        switch (dominao.substring(punto)) {
            case ".com":
                significado = "Comercial";
                break;
            case ".org":
                significado = "Organización";
                break;
            case ".net":
                significado = "Red";
                break;
            case ".info":
                significado = "Servicios informativos";
                break;
            case ".biz":
                significado = "Negocios";
                break;
            case ".gov":
                significado = "Gobierno";
                break;
            case ".edu":
                significado = "Educación";
                break;
            case ".mil":
                significado = "Militar";
                break;
            case ".es":
                significado = "España";
        }

        System.out.println("Dirección IP: " + host.getHostAddress());
        System.out.println("Nombre del host: " + host.getHostName());
        System.out.println("Tipo: " + significado);

    }
    
}
