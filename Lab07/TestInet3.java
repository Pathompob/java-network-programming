import java.net.*;

public class TestInet3 {
    public static void main(String[] args) {
        try {
            InetAddress ad = InetAddress.getLocalHost();
            System.out.println("Host = " + ad.getHostName());
            System.out.println("IP = " + ad.getHostAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}