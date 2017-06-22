import java.io.*;

public class Towers_of_Hanoi
{
    private void TOH(int d,char t1,char t2,char t3)
    {
        if (d==1)
        {
            System.out.println("Shift top disk from tower "+t1+" to tower "+t2);
            return;
        }//if block
        TOH(d-1,t1,t3,t2);
        System.out.println("Shift top disk from tower "+t1+" to tower "+t2);
        TOH(d-1,t3,t2,t1);
    }//TOH()
    public static void main()throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        System.out.print("Enter the number of disks : ");
        int disk = Integer.valueOf(br.readLine());
        if (disk<1)
            System.out.println("There are no disks to shift !");
        else
            (new Towers_of_Hanoi()).TOH(disk,'1','2','3');
    }//main()
}//class