import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Server implements Runnable{
    Socket s = null;
    public Server(Socket s) {
        this.s = s;
    }
    @Override
    public void run() {
        try {           
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            PrintWriter pw = new PrintWriter(out);
            String command = br.readLine();
            if (command.equals("listFile")) {
                File f = new File("./");
                File[] filename = f.listFiles();
                for (int i = 0; i < filename.length; i++) {
                  if(filename[i].isFile()){
                    pw.println(filename[i].getName()+":"+filename[i].length());
                  }
                }
                pw.flush();
            }
            else{
              File f = new File("./"+br.readLine());
              if(!f.exists()){}else{
                if(f.isDirectory()){
                  File[] filename = f.listFiles();
                  for (int i = 0; i < filename.length; i++) {
                    if(filename[i].isFile()){
                      pw.println(filename[i].getName()+":"+filename[i].length());
                    }
                  }
                }
              }
              pw.flush();
             
            }
            in.close();
            out.close();
            br.close();
            pw.close();
            s.close(); 
        } catch (Exception e) { }
    }
    public static void main(String[] args) {
        ServerSocket serv = null;
        ExecutorService es = Executors.newFixedThreadPool(10);
          try {
            serv = new ServerSocket(6789);
          } catch (Exception e) {
              //
          }
          while (true) {
              try {
                  Socket s = serv.accept();
                  Server fs = new Server(s);
                  es.execute(fs);
              } catch (Exception e) {}
          }
    }
}
