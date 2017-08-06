import java.util.*;

class FenwickTree
{
    public static void main()
    {
        int a[]={3,2,-1,6,5,4,-3,3,7,2,3};
        
        int n=a.length;
        int tree[]=new int[n+1];
        fillTree(tree,a);
        System.out.println(Arrays.toString(tree));
        update(tree,a,3,3);
        System.out.println(Arrays.toString(tree));
        update(tree,a,4,1);
        System.out.println(Arrays.toString(tree));
        System.out.println(Arrays.toString(a));
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            int i=sc.nextInt();
            int j=sc.nextInt();
            System.out.println(sum(tree,i,j));
        }
    }
    public static void fillTree(int tree[],int a[])
    {
        int n=a.length;
        for (int i=0;i<n;i++)
        {
            int num=a[i];
            for (int j=i+1;j<=n;)
            {
                tree[j]+=num;
                j=getNext(j);   // adding AND of index and its 2's complement to get next index
            }
        }
    }
    public static void update(int tree[],int a[],int i,int num)
    {
        int n=a.length;
        a[i]+=num;
        for (int j=i+1;j<=n;)
        {
            tree[j]+=num;
            j=getNext(j);
        }
    }
    public static int sum(int tree[],int i,int j)
    {
        int sum=0;
        for (int k=j+1;k>0;)
        {
            sum+=tree[k];
            k=getParent(k);
        }
        for (int k=i;k>0;)
        {
            sum-=tree[k];
            k=getParent(k);
        }
        return sum;
    }
    public static int getNext(int i)
    {
        return i+(i&((~i)+1));
    }
    public static int getParent(int i)
    {
        return i-(i&((~i)+1));
    }
}