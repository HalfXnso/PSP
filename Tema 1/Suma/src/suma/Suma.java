/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class Suma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
     
        String num1T = tec.nextLine();
        int num1 = Integer.parseInt(num1T);
     
        String num2T = tec.nextLine();
        int num2 = Integer.parseInt(num2T);

        System.out.println("La suma de " + num1 + " y " + num2 + " es: " + (num1 + num2));

    }

}
