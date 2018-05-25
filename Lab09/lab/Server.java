import java.util.concurrent.*;
import java.io.*;
import java.util.*;
import java.net.*;
public class Server implements Runnable{
    Socket s = null;
    static HashMap<String,String> map = new HashMap<String,String>();
    public Server(Socket s){this.s=s;}
    public void run(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream());
            String command = br.readLine();
            if(command.equals("add")){
                String id = br.readLine(),name = br.readLine();
                map.put(id,name);pw.println("OK");
            }else{
                String id = br.readLine();
                if(map.get(id)!=null)
                    pw.println(map.get(id));
                else
                    pw.println("N/A");
            }
            pw.flush();pw.close();br.close();s.close();
        }catch (Exception e) {}
    }
    public static void main(String[] args) {
        ServerSocket serv=null;
        ExecutorService es=Executors.newFixedThreadPool(15);
        try{serv=new ServerSocket(23410);}catch (Exception e){}
        while(true){
            try{
                Socket s=serv.accept();
                Server st=new Server(s);
                es.execute(st);
            }catch (Exception e) {}
        }
    }
}

