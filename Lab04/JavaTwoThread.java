public class JavaTwoThread implements Runnable{
    int start;
    int des;
    long sleep;
    int sum=0;
    public JavaTwoThread(int start,int des,long sleep){
        this.start = start;
        this.des = des;
        this.sleep = sleep;
    }
    public int getSum(){
        return sum;
    }
    public void run(){
        for(int i = start ;i<=des;i++){
            sum+=i;
        }
        try {
            Thread.sleep(sleep);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public static void main(String args[]){
        JavaTwoThread tt = new JavaTwoThread(1,5000,5000);
        JavaTwoThread ii = new JavaTwoThread(5001,10000,10000);
        Thread t = new Thread(tt);
        Thread i = new Thread(ii);
        i.start();
        t.start();
        try {
            t.join();
            i.join();
        } catch (Exception e) {
            //TODO: handle exception
        }
        System.out.println(tt.getSum()+ii.getSum());
    }
}