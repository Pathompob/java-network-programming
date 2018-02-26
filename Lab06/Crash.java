public class Crash implements Runnable{
    int id;
    public Crash(int id) {this.id = id;}

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
        for(int i = 0; i<n;i++){
            Crash c = new Crash(i);
            Thread t = new Thread(c);
            t.start();
        }
    }
}