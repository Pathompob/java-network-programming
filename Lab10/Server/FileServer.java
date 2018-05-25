import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class FileServer implements Runnable{
    Socket s = null;
    public FileServer(Socket s) {
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
            if (command.equals("list")) {
                File f = new File("./");
                String[] filename = f.list();
                for (int i = 0; i < filename.length; i++) {
                    pw.println(filename[i]);
                }
                pw.flush();
            }
            else if (command.equals("upload")){
              pw.println("OK");
              pw.flush();
              File f = new File(br.readLine());
              FileOutputStream fout = new FileOutputStream(f);
              byte[] b = new byte[65536];
              int size;
              while ((size = in.read(b)) > 0) {
                  fout.write(b,0,size);
              }
              fout.flush();
              fout.close();
            }
            else{
              pw.println("OK");
              pw.flush();
              String fileName = br.readLine();
              File file = new File(fileName);
              if(!file.exists()){
                pw.println(fileName + "not found");
                pw.flush();
              }else{
                pw.println("OK");
                pw.flush();
                FileInputStream fin = new FileInputStream(file);
                byte[] b = new byte[65536];
                int size;
                while ((size = fin.read(b)) > 0) {
                  out.write(b, 0, size);
                }
                out.flush();
              }
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
          } catch (Exception e) {}
          while (true) {
              try {
                  Socket s = serv.accept();
                  FileServer fs = new FileServer(s);
                  es.execute(fs);
              } catch (Exception e) {
                  //
              }
          }
    }
}
