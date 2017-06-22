import java.util.*;
class Factorial
{
    static long memo[]=new long[1000];
    public static void main()throws Exception
    {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        memo[0]=memo[1]=1;
        for (int i=2;i<memo.length;i++)
            memo[i]=-1;
        long t1,t2;
        float time;
        int a[]=new int[4];
        for (int i=0;i<4;i++)
            a[i]=sc.nextInt();
        
        t1=System.currentTimeMillis();
        for (int i=0;i<4;i++)
        {
            Thread.sleep(1000);
            System.out.println(fact(a[i]));
        }
        System.out.println("Time taken : "+(System.currentTimeMillis()-t1)+" milli - sec");
        
        t1=System.currentTimeMillis();
        for (int i=0;i<4;i++)
        {
            Thread.sleep(1000);
            System.out.println(factRecur(a[i]));
        }
        System.out.println("Time taken : "+(System.currentTimeMillis()-t1)+" milli - sec");
        
        t1=System.currentTimeMillis();
        for (int i=0;i<4;i++)
        {
            Thread.sleep(1000);
            System.out.println(factDyn(a[i]));
        }
        System.out.println("Time taken : "+(System.currentTimeMillis()-t1)+" milli - sec");
    }
    public static long fact(int n)
    {
        long f=1;
        for (int i=1;i<=n;i++)
            f*=i;
        return f;
    }
    public static long factRecur(int n)
    {
        if (n==1||n==0)
            return 1;
        else
            return n*factRecur(n-1);
    }
    public static long factDyn(int n)
    {
        if (memo[n]==-1)
            memo[n]=n*factDyn(n-1);
        return memo[n];
    }
}