package ejemplohost;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class EjemploHost {

    public static void main(String[] args) throws UnknownHostException {

        InetAddress host = InetAddress.getByName("www.google.es");
        System.out.println("Jose: " + host);
        System.out.println("IP: " + host.getHostAddress());
        System.out.println("Nombre de dominao: " + host.getHostName());
        System.out.println("SIUUUUUUUUUUUUUUUUUUUUUU");

    }

}
