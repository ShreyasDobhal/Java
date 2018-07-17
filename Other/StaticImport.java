import static java.lang.System.out;
import static java.lang.Math.*;


class StaticImport
{
    public static void main(String args[])
    {
        System.out.println("Hello");
        out.println("Hello");
        out.println(Math.max(5,6));
        out.println(max(5,6));
        out.println(min(5,6));
        out.println(abs(-5));
        out.println(PI);
    }
    static 
    {
        System.out.println("static block");
    }
}