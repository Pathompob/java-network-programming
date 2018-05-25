import java.io.*;
import java.net.*;


public class TestTwo{
    public static void main(String[] args){
        int count = Integer.parseInt(args[0]);
        for(int i=0;i<count;i++){
            try {
                Socket s = new Socket("127.0.0.1",25);
                InputStream in = s.getInputStream();
                OutputStream out = s.getOutputStream();
    
                BufferedReader sin = new BufferedReader(new InputStreamReader(in));
                PrintWriter sout = new PrintWriter(out);
                sout.print("HELO mail.kmutnb.ac.th\r\n");
                sout.flush();
                sin.readLine();
                sout.print("MAIL FROM:<admin@getdota.com>\r\n");
                sin.readLine();
                sout.print("RCPT TO:<choopanr@kmutnb.ac.th>\r\n");
                sout.flush();
                sin.readLine();
                sout.print("DATA\r\n");
                sout.flush();
                sin.readLine();
                sout.print("Subject: Pay us money\r\n");
                sout.print("Dear user,\r\n");
                sout.print("     Pay us money otherwise you will be captured!\r\n");
                sout.print(".\r\n");
                sout.flush();
                sin.readLine();
                sin.close();
                sout.close();
                in.close();
                out.close();
                s.close();
            } catch (Exception e) {
                e.printStackTrace();
                //TODO: handle exception
            }
        }
        
    }
}
