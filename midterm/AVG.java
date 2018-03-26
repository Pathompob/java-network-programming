import java.io.*;
public class AVG{
    public static void main(String[] args){
       try {
           String msg;
           int count=0; int avg=0;
           File f = new File(args[0]);
           File o = new File("output.txt");
           BufferedReader br =  new BufferedReader(
                                new InputStreamReader(
                                new FileInputStream(f)));
            PrintWriter pout = new PrintWriter(new FileOutputStream(o));
            while((msg = br.readLine()) != null){
                try {
                    int number = Integer.parseInt(msg);
                    count=count+1;
                    avg+=number;
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
            pout.println("result = "+(avg/(float)count));
            pout.close();
       } catch (Exception e)  {
           //TODO: handle exception
       }
    }
}