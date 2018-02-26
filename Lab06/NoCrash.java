import java.util.concurrent.*;

public class NoCrash implements Runnable{
    int id;
    public NoCrash(int id){this.id = id;}
    
    public void run(){
        int buffer[] = new int[50000000];
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            //TODO: handle exception
        }
        System.out.println(id + ": Done");
    }
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        ExecutorService es = Executors.newFixedThreadPool(5);
        for(int i = 0;i<n;i++){
            NoCrash c = new NoCrash(i);
            es.execute(c);
        }
        es.shutdown();
    }
}