import java.util.*;
/**
 *  Dynamic Programming with Memoization
 */
class DynamicFibo
{
    static int max=100; 
    static long memo[]=new long[max+1];
    public static void main()
    {
        Scanner sc=new Scanner(System.in);
        memo[0]=0;
        memo[1]=1;
        for (int i=2;i<memo.length;i++)
            memo[i]=-1;
        System.out.println();
        int t=sc.nextInt();
        while (t>0)
        {
            int n=sc.nextInt();
            System.out.println(F(n));
            t--;
        }//while loop
    }//main()
    public static long F(int n)
    {
        if (memo[n]==-1)
            memo[n]=F(n-1)+F(n-2);
        return memo[n];
    }//F()
}//class