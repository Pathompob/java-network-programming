public class Sum extends Thread{
    long start;
    long stop;
    double sum = 0;
    public Sum(long start, long stop){
        this.start = start;
        this.stop = stop;
    }
    public double getSum(){
        return sum;
    }
    public void run(){
        for(long i = start; i<=stop;i++){
            // sum += Math.log(Math.acos(i));
            sum += i;
        }
    }
    public static void main(String args[]){
        // long startTime = System.nanoTime();
        //program
        Sum t1 = new Sum(0,50000);
        // Sum t2 = new Sum(25000001,500000000);
        // Sum t3 = new Sum(500000001,75000000);
        // Sum t4 = new Sum(75000001,100000000);
        t1.start();
        try {
            t1.join();
            //รอ t1 จนทำงานเสด
        } catch (Exception e) {
            //TODO: handle exception
        }
        System.out.println(t1.getSum());
        // t2.start();
        // t3.start();
        // t4.start();
        //end program
        // long endTime   = System.nanoTime();
        // long totalTime = endTime - startTime;
        // System.out.println(totalTime);
    }
}