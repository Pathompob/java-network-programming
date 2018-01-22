import java.io.*;

public class JavaTextCopy
{
    public static void main(String[] args)
    {
           if(args.length != 2){
                System.out.println("JavaBinaryCopy <source file> <destination file>");
                System.exit(1);
            }
            File one = new File(args[0]);
            File two = new File(args[1]);
            if(!one.exists()){
                System.out.println("JavaBinaryCopy <source file> <destination file>");
                System.exit(1);
            }
            try {
                FileInputStream oneIn = new FileInputStream(one);
                InputStreamReader ir = new InputStreamReader(oneIn);
                BufferedReader br = new BufferedReader(ir);

                FileOutputStream twoOut = new FileOutputStream(two);
                PrintWriter pout = new PrintWriter(twoOut);

                String msg;
                while((msg = br.readLine()) != null){
                    pout.println(msg);
               }
               pout.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
    }
}
//อ่านไฟล์