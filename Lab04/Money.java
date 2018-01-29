public class Money extends Thread{
    static int money = 0;
    static Object o = new Object();
    int mode;
    public Money(int mode){
        this.mode = mode;
    }
    public synchronized int getMoney(){
        return money;
    }
    public void run(){
        if(mode == 0){
            for(int i=0;i<1000000;i++){
                synchronized(o){
                    money++;
                }
            }
        }else{
            for(int i=0;i<1000000;i++){
                synchronized(o){
                    money--;
                }
            }
        }
    }
    public static void main(String args[]){
        Money me = new Money(0);
        Money gf = new Money(1);
        me.start();gf.start();
        try {
            me.join();gf.join();
        } catch (Exception e) {
            //TODO: handle exception
        }
        System.out.println(me.getMoney());
    }
}