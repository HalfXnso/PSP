/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2t1psp;

import java.io.IOException;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class Ejercicio2T1PSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        Process p = new ProcessBuilder("CMD","/C","START winword").start();

    }
    
}
