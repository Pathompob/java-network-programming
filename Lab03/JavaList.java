import java.io.*;

public class JavaList
{
    public static void main(String[] args)
    {
        try {
        if (args.length == 1) {
            File f = new File(args[0]);
            if(!f.exists()){
                System.out.println("File not found");
                System.exit(1);
            }else if(f.isFile()){
                System.out.println("File size " + f.length());
            }else if(f.isDirectory()){
                File list[] = f.listFiles();
                for(int i = 0; i <list.length; i++){
                    if (list[i].isFile()){
                        System.out.println(list[i].getName() + "is a file");
                    }else if(list[i].isDirectory()){
                        System.out.println(list[i].getName() + "is a directory");
                    }else{
                        System.out.println(list[i].getName() + "is unknow");
                    }
                }
            }
        } else {
            System.out.println("Usage : JavaList <File/Directory Name>");
        }
        }catch(Exception e ){
            System.out.print(e);
        }
    }
}
//อ่านไฟล์