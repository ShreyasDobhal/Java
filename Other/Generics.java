class Generics
{
    public static void main()
    {
        Number<Integer> num1 = new Number<Integer>(5);
        Number<Integer> num2 = new Number<Integer>(7);
        num1.show();
        num2.show();
    }
}
class Number<T>
{
    private T t;
    public Number(T t)
    {
        this.t=t;
    }
    public void show()
    {
        System.out.println(t);
    }
}