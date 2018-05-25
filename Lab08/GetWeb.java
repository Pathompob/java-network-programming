import java.io.*;
import java.net.*;

public class GetWeb{
    public static void main(String[] args){
        String host = args[0];
        String path = args[1];
        try {
            Socket socket = new Socket(host,80);
            BufferedReader br = new BufferedReader(
                                new InputStreamReader(socket.getInputStream()));
            PrintWriter pwSocket = new PrintWriter(socket.getInputStream());
            PrintWriter pw = new PrintWriter(
                             new File("getweb.html"));
            String msg;
            pwSocket.println("GET "+path+" HTTP.1,1");
            pwSocket.println("HOST: "+host);
            pwSocket.println("Connection: close");
            pwSocket.println();
            pwSocket.flush();
            while((msg = br.readLine())!=null){
                System.out.println(msg);
                pw.println(msg);
            }
            br.close();
            pw.close();
            socket.close();
        } catch (Exception e) {}
    }
}
