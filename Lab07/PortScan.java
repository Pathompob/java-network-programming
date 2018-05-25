import java.io.*;
import java.net.*;
public class PortScan {
    public static void main(String[] args) {
        if (args.length == 1) {
            for (int i = 1040; i <= 1060; i++) {
                try {
                    Socket s = new Socket(args[0], i);
                    System.out.println("port " + i + ": open");
                } catch (Exception e) {
                    System.out.println("port " + i + ": not open");
                }
            }
        } else {
            System.out.print("Usage: java PortScan <hostname/IP>");
        }
    }
}
