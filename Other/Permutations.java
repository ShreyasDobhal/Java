import java.util.*;

class Permutations
{
    public static void main(String args[])
    {
        int arr[]={1,2,3};
        Set<String> com = new HashSet<>();
        com=allOrder(arr);
        for (String str:com)
        {
            String a[]=str.split(" ");
            int num[]=new int[a.length];
            for (int i=0;i<num.length;++i)
                num[i]=Integer.valueOf(a[i]);
            System.out.println(Arrays.toString(num));
        }
    }
    public static Set<String> allOrder(int arr[])
    {
        Set<String> com = new HashSet<>();
        permute(arr,0,arr.length-1,com);
        return com;
    }
    public static void permute(int arr[],int l,int r,Set<String> com)
    {
        int i;
        if (l==r)
        {
            //System.out.println(Arrays.toString(arr));
            String str="";
            for (int num:arr)
                str=str+num+" ";
            com.add(str);
        }
        else
        {
            for (i=l;i<=r;i++)
            {
                int tmp=arr[l];
                arr[l]=arr[i];
                arr[i]=tmp;
                
                permute(arr,l+1,r,com);
                
                tmp=arr[l];
                arr[l]=arr[i];
                arr[i]=tmp;
            }
        }
    }
}