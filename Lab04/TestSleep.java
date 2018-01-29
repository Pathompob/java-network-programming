import java.io.*;
public class TestSleep{
    public static void main(String args[]){
        System.out.print("Hello");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            //TODO: handle exception
        }
        System.out.print("Bye Bye");
    }
}
