class FunctionPassing
{
    public static void main(String args[])
    {
        implement(new function(){public double run(double a,double b){return a*b;}},10,2);
        implement(new function(){public double run(double a,double b){return a+b;}},10,2);
        implement(new function(){public double run(double a,double b){return a-b;}},10,2);
        implement(new function(){public double run(double a,double b){return a/b;}},10,2);
    }
    public static void implement(function func,double a,double b)
    {
        System.out.println(func.run(a,b));
    }
    interface function
    {
        public double run(double a,double b);
    }
}