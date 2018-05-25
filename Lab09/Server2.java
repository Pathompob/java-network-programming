import java.io.*;
import java.net.*;

public class Server2{
    public static void main(String[] args) {
        ServerSocket servSocket = null;
        try {
            servSocket = new ServerSocket(30000);
        } catch (Exception e) {
            //TODO: handle exception
        }
        while(true){
            try {
                Socket s = servSocket.accept();

                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter pw = new PrintWriter(s.getOutputStream());
                String sleep = br.readLine();
                long sleepTime = Long.parseLong(sleep);

                try {
                    Thread.sleep(sleepTime*1000);
                } catch (Exception e) {
                    //TODO: handle exception
                }
                pw.println("OK");
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