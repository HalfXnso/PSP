/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package antonio;

import java.util.Scanner;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class Antonio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        String numT = tec.nextLine();
        int num = Integer.parseInt(numT);
        int resultado =num * num;
        System.out.println("El cuadrado de "+num+ " es " +resultado);
    }

}
