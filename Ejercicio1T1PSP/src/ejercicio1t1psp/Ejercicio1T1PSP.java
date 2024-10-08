/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1t1psp;

import java.io.IOException;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class Ejercicio1T1PSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String[] comando ={"CMD","/C", "START winword"}; 
        Process p = new ProcessBuilder(comando).start();
        
        
        
    }
    
}
