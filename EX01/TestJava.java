public class TestJava
{
    public static void main(String[] args)
    {
        System.out.println("Number of argument : " + args.length);
        for(int i = 0; i<args.length;i++){
            System.out.println("Args["+ i + "]" +args[i]);
        }
    }
}