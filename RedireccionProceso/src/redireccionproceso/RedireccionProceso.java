/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redireccionproceso;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author AlfonsoGaitanPerez
 */
public class RedireccionProceso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        //Creamos proces que lance la consola de comandos cmd
        ProcessBuilder pb = new ProcessBuilder("CMD");

        //Creamos instancia de tipo File para indicar los ficheros de comandos, salida y error.
        File fBat = new File("fichero.bat");
        File fOut = new File("salida.txt");
        File fError = new File("error.txt");

        pb.redirectInput(fBat);
        pb.redirectOutput(fOut);
        pb.redirectError(fError);
        
        
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        pb.start();

    }

}
