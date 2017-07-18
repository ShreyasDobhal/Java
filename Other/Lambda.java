class Lambda
{
    public static void main()
    {
        //Generate random = (int max) -> (int)(Math.random()*max);
        Interface obj1 = new Interface(){
            @Override
            public void show() {
                System.out.println("Non Lambda Expression");
            }
        };
        obj1.show();
        Interface obj2 = () -> {System.out.println("Lambda Expression")};
        obj2.show();
        Calc pow = (a,b) -> (int)Math.pow(a,b);
        Calc hcf = (a,b) -> {
            int r=a%b;
            while (r!=0)
            {
                a=b;
                b=r;
                r=a%b;
            }
            return b;
        };
        Calc lcm = (a,b) -> {
            int pro=a*b;
            int r=a%b;
            while (r!=0)
            {
                a=b;
                b=r;
                r=a%b;
            }
            return pro/b;
        };
        System.out.println(pow.operate(2,3));
        System.out.println(hcf.operate(9,12));
        System.out.println(lcm.operate(9,12));
    }
    interface Interface
    {
        public void show();
    }
    interface Calc
    {
        public int operate(int a,int b);
    }
}