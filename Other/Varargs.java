class Varargs
{
    public static void main(String args[])
    {
        print(1,2,3,4,5,6);
    }
    public static void print(int ... a)
    {
        for (int n:a)
            System.out.println(n);
    }
}