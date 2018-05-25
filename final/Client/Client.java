import java.io.*;
import java.net.*;

public class Client {
  public static void main(String[] args){
    try {
      Socket s = new Socket("127.0.0.1",6789);
      InputStream in = s.getInputStream();
      OutputStream out = s.getOutputStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      PrintWriter pw = new PrintWriter(out);
      if(args.length == 0){
        System.out.println("Error args");
        System.exit(1);
      }
      String command  = args[0];
      if(command.equals("listFile")){
        if(args.length == 1){
          pw.println(args[0]);
          pw.flush();
          String filename;
          int count = 0;
          while((filename = br.readLine()) != null){
            String[] parts = filename.split(":");
            String part1 = parts[0];
            String part2 = parts[1];
            System.out.println(part1+" "+part2);
            count = count + Integer.parseInt(part2);
          }
          System.out.println("Total size = " + count);
        }else{
          System.out.println("Error args");
          System.exit(1);
        }
      }else if(command.equals("listFileinDir")){
        if(args.length == 2){
          pw.println(args[0]);
          pw.flush();
          pw.println(args[1]);
          pw.flush();
          int count = 0;
            String filename;
            while((filename = br.readLine()) != null){
              String[] parts = filename.split(":");
              String part1 = parts[0];
              String part2 = parts[1];
              System.out.println(part1+" "+part2);
              count = count + Integer.parseInt(part2);
            }          
          System.out.println("Total size = " + count);        
        }else{
          System.out.println("Error args");
          System.exit(1);
        }
      }else{
        System.out.println("Command not found");
        System.exit(1);
      }
      in.close();
      out.close();
      s.close();
    } catch (Exception e) {}
  }
}
