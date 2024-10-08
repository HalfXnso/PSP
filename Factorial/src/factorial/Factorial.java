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
public class Factorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        String numT = tec.nextLine();
        int num = Integer.parseInt(numT);
        for (int i = 4; i > 0; i--) {
            num *= i;
        }
        System.out.println("El factorial de 5 es: " + num);

    }

}
