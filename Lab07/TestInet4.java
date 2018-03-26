import java.net.*;

public class TestInet4 {
    public static void main(String[] args) {
        try {
            InetAddress ad = InetAddress.getByName("202.44.32.13");
            System.out.println("host = " + ad.getHostName());
        } catch (Exception e) {
        }
    }
}