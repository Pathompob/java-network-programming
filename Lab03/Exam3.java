import java.io.*;

public class Exam3
{
    public static void main(String[] args)
    {
       try {
           String msg = "Hello World!!!!!!";
           File f = new File("myFile.txt");
           FileOutputStream fout = new FileOutputStream(f);
        //    byte[] b = msg.getBytes();
        //    fout.write(b);
        //    fout.close();
        // แปลงเป็น byte ก่อน
           PrintWriter pout = new PrintWriter(fout);
           pout.print(msg);
           pout.flush();
           fout.close();
        // เขียนเป็น String
       } catch(Exception e) {
           e.printStackTrace();
       }
    }
}

//เขียนไฟล์