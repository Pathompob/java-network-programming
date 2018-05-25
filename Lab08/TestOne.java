import java.io.*;
import java.net.*;

public class TestOne{
    public static void main(String[] args){
        try {
            Socket s = new Socket("127.0.0.1",1041);
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            in.close();
            out.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}