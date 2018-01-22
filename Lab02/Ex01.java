import java.io.*;

public class Ex01 {
    public static void main(String[] args) {
        try {
            int num = Integer.parseInt(args[0]);
            System.out.println("Result = " + num);
        // } catch (ArrayIndexOutOfBoundsException e) {
        //     System.out.println("Usage : java Ex01 <number>");
        // } catch (NumberFormatException ee) {
        //     System.out.println("Usage : java Ex01 <number>");
        } catch (Exception e ){
            System.out.println("Usage : java Ex01 <number>");
        } 
    }
}