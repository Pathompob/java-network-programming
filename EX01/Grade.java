public class Grade
{
    public static void main(String[] args)
    {
        try{
        if (args.length == 1) {
            int num = Integer.parseInt(args[0]);
            if (num >=0 && num <=100) {
                if (num < 80 && num >= 70) {
                    System.out.println("B");
                } else if (num < 70 && num >= 60) {
                    System.out.println("C");
                } else if (num < 60 && num >= 50) {
                    System.out.println("D");
                } else if (num < 50 && num >= 0) {
                    System.out.println("F");
                } else {
                    System.out.println("A");
                }
            } else {
                System.out.println("Please enter number 0-100");
            }
        } else {
            System.out.println("Please enter your score"); 
        }
        }catch(NumberFormatException e) {
            System.out.println("Please enter integer number");
        }  
    }
}