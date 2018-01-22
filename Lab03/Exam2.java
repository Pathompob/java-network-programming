import java.io.*;

public class Exam2
{
    public static void main(String[] args)
    {
       try {
           int n;
           byte[] b = new byte[16];

           File f = new File("myFile.txt");
           FileInputStream fin = new FileInputStream(f);
        //    while((n = fin.read(b)) > 0){
        //        String data = new String (b, 0, n);
        //        System.out.println(data);
        //    }
        // อ่านแบบเป็น byte

           String msg;
           InputStreamReader ir = new InputStreamReader(fin);
           BufferedReader br = new BufferedReader(ir);

           while((msg = br.readLine()) != null){
                System.out.println(msg);
           }
        // อ่านแบบเป็น line
           fin.close();
       } catch(Exception e) {
           e.printStackTrace();
       }
    }
}
//อ่านไฟล์