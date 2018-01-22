import java.io.*;

public class JavaBinaryCopy
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
                int n;
                byte[] b = new byte[100000];
                FileInputStream oneIn = new FileInputStream(one);
                FileOutputStream twoOut = new FileOutputStream(two);
                while((n = oneIn.read(b)) > 0){
                    twoOut.write(b,0,n);
                    twoOut.flush();
                }
                twoOut.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
    }
}
//อ่านไฟล์