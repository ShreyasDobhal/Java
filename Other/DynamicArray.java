import java.util.*;
class DynamicArray
{
    public static void main(String args[])
    {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i=0;i<10;i++)
            arr.add(i);
        for (int i=0;i<arr.size();i++)
            System.out.println(arr.get(i));
    }//main()
}//class