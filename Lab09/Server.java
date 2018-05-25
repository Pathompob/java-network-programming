import java.io.*;
import java.net.*;

public class Server{
    public static void main(String[] args) {
        ServerSocket servSocket = null;
        try {
            servSocket = new ServerSocket(20000);
        } catch (Exception e) {
            //TODO: handle exception
        }
        while(true){
            try {
                Socket s = servSocket.accept();

                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter pw = new PrintWriter(s.getOutputStream());
                String login = br.readLine();
                String passwd = br.readLine();

                if(login.equals("admin") && passwd.equals("admin"))
                    pw.println("OK");
                else
                    pw.println("NO");
                pw.flush();
                pw.close();
                br.close();
                s.close();
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
    }
}