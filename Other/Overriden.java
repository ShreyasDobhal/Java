import java.util.*;
class Overriden
{
    public static void main()
    {
        System.out.println("Considering Points");
        Point pnt[]=new Point[10];
        for (int i=0;i<pnt.length;i++)
            pnt[i]=new Point((int)(Math.random()*21-10),(int)(Math.random()*21-10));
        for (Point p:pnt)
            System.out.println(p);
        System.out.println("Sorting on the basis of distance from origin");
        Arrays.sort(pnt,new Comparator<Point>(){
            @Override
            public int compare(Point a,Point b) {
                double dist1=Math.sqrt(a.x*a.x+a.y*a.y);
                double dist2=Math.sqrt(b.x*b.x+b.y*b.y);
                if (dist1>dist2)
                    return 1;
                else if (dist1<dist2)
                    return -1;
                else
                    return 0;
            }
        });
        for (Point p:pnt)
            System.out.println(p);
        System.out.println("Considering Strings");
        String str[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
        for (String s:str)
            System.out.println(s);
        System.out.println("Sorting alphabetically");
        Arrays.sort(str);
        for (String s:str)
            System.out.println(s);
        System.out.println("Sorting length wise");
        Arrays.sort(str,new Comparator<String>(){
            @Override
            public int compare(String a,String b){
                int l1=a.length();
                int l2=b.length();
                if (l1>l2)
                    return 1;
                else if(l1<l2)
                    return -1;
                else
                    return a.compareTo(b);
            }
        });
        for (String s:str)
            System.out.println(s);
    }
}
class Point
{
    int x,y;
    public Point(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    @Override
    public String toString()
    {
        return "("+x+","+y+")";
    }
}