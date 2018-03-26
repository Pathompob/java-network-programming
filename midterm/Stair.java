import java.io.*;
public class Stair{
    public static void main(String[] args){
       int a = Integer.parseInt(args[0]);
       for(int i=0;i<a;i++){
           for(int j=0;j<a;j++){
               if(j<a-i-1){
                    System.out.print(" ");
               }else{
                    System.out.print("#");
               }
           }
           System.out.println();
       }
    }
}