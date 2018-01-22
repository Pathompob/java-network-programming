import java.io.*;

public class Exam
{
    public static void main(String[] args)
    {
       File f = new File("$HOME/Documents/Network Programming/WorkLab/java-network-programming/lab03/myFile.txt");
       if(!f.exists()){
           System.out.println("File does not exist");
           System.exit(1);
       }
        if(f.isFile()){
            System.out.println("myFile.txt is a File Length = " + f.length());
            //เช็คไฟล์
        } else if(f.isDirectory()){
            System.out.println("MyFile.txt is a directory");
            //เช็คโฟลเดอร์
        }else{
            System.out.println("....");
        }      
    }
}