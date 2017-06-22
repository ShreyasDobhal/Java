



/**
 *  This is a real world Project that was actually used
 *  to compile the results of Marathon of six different
 *  categories in our School
 */
import java.io.*;
class Marathon
{
    private static int duff,doo,berg,don;   // Variables to store house points
    private static int i=1;                 // Global Rank Variable / Index
    private static int rank[]=new int[101]; // Array of houses at the index position
    private static boolean error=false;
    private static void house(int h,int pt)
    {
        if (h==1)
            doo+=pt;
        if (h==2)
            berg+=pt;
        if (h==3)
            duff+=pt;
        if (h==4)
            don+=pt;
    }//house()
    /*
     * Enter the first name as "" and then proceed further
     */
    public static void main(String args[])throws IOException
    {
        try
        {
            BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
            //1-dooley;2-bergin;3-duffy;4-donovan
            for (;i<=100;i++)
            {
                System.out.print(i+") : ");
                String tmp=br.readLine();
                if (!error)
                {
                    char ch=tmp.charAt(0);
                    if (tmp.length()>0&&tmp.length()==1)
                    {
                        if (Character.isDigit(ch))
                        {
                            int n=ch-'0';
                            if (n<=4&&n>0)
                                rank[i]=n;
                            if (n>4||n<=0)
                            {
                                System.out.println("Type the previous data again !");
                                System.out.println(n+" does not belong to 1 - 4");
                                i--;
                            }//if block
                        }
                        else if (ch=='*')
                        {
                            System.out.println("Returning to previous rank"+(i-1));
                            i-=2;
                        }//else block
                        else
                        {
                            System.out.println("Type the previous data again !");
                            System.out.println(ch+" is wrong data");
                            i--;
                        }//else block
                    }//if block
                    else
                    {
                        System.out.println("Type the previous data again !");
                        System.out.println(ch+" is wrong data");
                        i--;
                    }//else block
                }//if block
            }//for loop
        }//try block
        catch (Exception x)
        {
            System.out.println("Wrong Input Type the data again");
            main(args);
            error=true;
        }//catch block
        if (!error)
        {
            // Point of first four :
            house(rank[1],25);
            house(rank[2],20);
            house(rank[3],15);
            house(rank[4],10);
            // Calculation of Points
            for (int j=5;j<=20;j++)
                house(rank[j],5);
            for (int j=21;j<=50;j++)
                house(rank[j],3);
            for (int j=51;j<=75;j++)
                house(rank[j],2);
            for (int j=76;j<=100;j++)
                house(rank[j],1);
            System.out.print('\f');
            for (int j=1;j<args.length;j++)
            {
                System.out.println(j+") "+args[j]+" : "+(rank[j]==1?"Dooley":rank[j]==2?"Bergin":rank[j]==3?"Duffy":"Donovan"));
            }//for loop
            System.out.println("Dooley : "+doo+"\nBergin : "+berg+"\nDuffy : "+duff+"\nDonovan : "+don);
        }//if block
    }//main()
}//class