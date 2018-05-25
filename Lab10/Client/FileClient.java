import java.io.*;
import java.net.*;

public class FileClient {
  public static void main(String[] args){
    try {
      Socket s = new Socket("127.0.0.1",6789);
      InputStream in = s.getInputStream();
      OutputStream out = s.getOutputStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      PrintWriter pw = new PrintWriter(out);
      String command  = args[0];     
      if(command.equals("upload")){
        if(args.length == 2){
          pw.println(args[0]);
          pw.flush();
          String response = br.readLine();
          if(response.equals("OK")){
            File f = new File(args[1]);
            if(!f.exists()){
              System.out.println(args[1] + " not found");
              System.exit(1);
            }
            pw.println(args[1]);
            pw.flush();
            FileInputStream fin = new FileInputStream(f);
            byte[] buffer = new byte[65536];
            int size;
            while((size = fin.read(buffer)) > 0){
              out.write(buffer,0,size);
            }
            out.flush();
            fin.close();
          }
        }else{
          System.out.println("error");
          System.exit(1);
        }
      }else if(command.equals("download")){
        if(args.length == 2){
          pw.println(args[0]);
          pw.flush();
          String response = br.readLine();
          if(response.equals("OK")){
            pw.println(args[1]);
            pw.flush();
            if(br.readLine().equals("OK")){
              File f = new File(args[1]);
              FileOutputStream fout = new FileOutputStream(f);
              byte[] b = new byte[65536];
              int size;
              while((size = in.read(b)) > 0){
                fout.write(b,0,size);
              }
            }else{
              System.out.println(args[1]+" not found");
            }
          }
        }else{
          System.out.println("error");
          System.exit(1);
        }
      }else if(command.equals("list")){
        pw.println(args[0]);
        pw.flush();
        String filename;
        while((filename = br.readLine()) != null){
          System.out.println(filename);
        }
      }else{
        System.out.println("command not found");
        System.exit(1);
      }
      in.close();
      out.close();
      s.close();
    } catch (Exception e) {}
  }
}