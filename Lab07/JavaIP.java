import java.net.*;

public class JavaIP {
    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                InetAddress ad = InetAddress.getByName(args[0]);
                System.out.println("HOST = " + ad.getHostName());
                System.out.println("IP = " + ad.getHostAddress());
            } catch (Exception e) {
                System.out.println("Error: unknown host or IP address");
            }
        } else {
            System.out.println("Usage : java JavaIP <hostname/IP>");
        }
    }
}