import java.util.*;

class HashTable
{
    String theArray[];
    int arraySize;
    int itemsinArray=0;
    public HashTable(int size)
    {
        arraySize=size;
        theArray = new String[size];
        Arrays.fill(theArray,"-1");
    }
    public static void main()
    {
        HashTable theFunc=new HashTable(30);
        //String[] elementsToAdd={"1","5","17","21","26"};
        //theFunc.hashFunction1(elementsToAdd,theFunc.theArray);
        String[] elementsToAdd={"100","510","170","214","268","398","235","802","900","723","699","1","16","999","890","725","998","978","988","990","989","984","320","321","400","415","450","50","660","624"};
        theFunc.hashFunction2(elementsToAdd,theFunc.theArray);
        theFunc.display();
        theFunc.findKey("2");
    }
    public void hashFunction1(String[] stringsForArray,String[] theArray)
    {
        for (int i=0;i<stringsForArray.length;i++)
        {
            String newElementVal = stringsForArray[i];
            theArray[Integer.valueOf(newElementVal)]=newElementVal;
        }
    }
    public void hashFunction2(String[] stringsForArray,String[] theArray)
    {
        for (int i=0;i<stringsForArray.length;i++)
        {
            String newElementVal = stringsForArray[i];
            int arrayIndex=Integer.valueOf(newElementVal)%(arraySize-1);
            while (theArray[arrayIndex]!="-1")
            {
                ++arrayIndex;
                arrayIndex%=arraySize;
            }
            theArray[arrayIndex]=newElementVal;
        }
    }
    public String findKey(String key)
    {
        int arrayIndexHash=Integer.parseInt(key)%(arraySize-1);
        while (theArray[arrayIndexHash]!="-1")
        {
            if (theArray[arrayIndexHash]==key)
            {
                System.out.println(key+" was found in index "+arrayIndexHash);
                return theArray[arrayIndexHash];
            }
            ++arrayIndexHash;
            arrayIndexHash%=arraySize;
        }
        return null;
    }
    public void display()
    {
        for (int i=0;i<arraySize;i++)
            System.out.print(theArray[i]+" ");
        System.out.println();
    }
}