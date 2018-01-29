public class JavaThread extends Thread{
    int num;
    public JavaThread(int num){
        this.num = num;
    }
    public void run(){
        System.out.println(num+" HelloWorld");
    }
    public static void main(String args[]){
        int x = Integer.parseInt(args[0]);
        for(int i=0;i<=x;i++){
            JavaThread t = new JavaThread(i);
            t.start();
        }
    }
}