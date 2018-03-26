import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileThreadPool implements Runnable {
    String msg;
    public FileThreadPool(String msg){this.msg = msg;}
    public void run() {
        int number  = Integer.parseInt(msg);
        // number = Integer.parseInt(msg);
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            //TODO: handle exception
        }
        System.out.println(msg + " -> " + number*number);
    }
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        try {
            File one = new File(args[0]);
            FileInputStream fileIn = new FileInputStream(one);
            InputStreamReader ir = new InputStreamReader(fileIn);
            BufferedReader br = new BufferedReader(ir);
            String save;
            while((save = br.readLine()) != null){
                FileThreadPool c = new FileThreadPool(save);
                es.execute(c);
            }
            fileIn.close();
            es.shutdown();
        } catch (Exception e) {
            //TODO: handle exception
        }    
    }
}