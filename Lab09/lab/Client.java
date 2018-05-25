import java.net.*;
import java.io.*;
public class Client{
    public static void main(String[] args){
        try {
            Socket s = new Socket("127.0.0.1",23410);
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream());
            String command  = args[0];
            if(command.equals("add")){
                pw.println(args[0]);
                pw.println(args[1]);
                pw.println(args[2]);
            }else if(command.equals("search")){
                pw.println(args[0]);
                pw.println(args[1]);
            }else{
                System.out.println("Command not found");
                System.exit(1);
            }
            pw.flush();
            String msg = br.readLine();
            System.out.println(msg);
            br.close();
            pw.close();
            s.close();
        } catch (Exception e) {}
    }
}
