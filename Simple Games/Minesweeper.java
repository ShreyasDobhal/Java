/*
 * This is a classic minesweeper game
 * works just the same
 */
import java.io.*;
class Minesweeper
{
    public static Node arr[][];
    public static String name="Shreyas";
    private static boolean win=false,lose=false;
    private static int nb=0;
    private void initialize()
    {
        arr=new Node[9][9];
        win=lose=false;
        for (int i=0;i<9;i++)
        {
            for (int j=0;j<9;j++)
                arr[i][j]=new Node();
        }//for loop
    }//initialize
    private void set()
    {
        for (int i=0;i<10;i++)
        {
            int a=(int)(Math.random()*7)+1;
            int b=(int)(Math.random()*7)+1;
            if (!arr[a][b].bomb)
            arr[a][b].activateBomb();
            else
            {
                i--;
                continue;
            }//else block
        }//for loop
    }//set()
    private void display()
    {
        for (int i=0;i<9;i++)
        {
            for (int j=0;j<9;j++)
            {
                if (arr[i][j].mark)
                System.out.print("X\t");
                else if (!arr[i][j].visible)
                System.out.print("-\t");
                else
                {
                     if (!arr[i][j].mark)
                    {
                        if (!arr[i][j].bomb)
                        System.out.print(arr[i][j].n+"\t");
                        else
                        System.out.print("*\t");
                    }//if block
                }//else block
            }//for loop
            System.out.println();
        }//for loop
    }//display()
    private void fill()
    {
        int x=0,k=0,l=0;
        for (int i=0;i<9;i++)
        {
            mid:for (int j=0;j<9;j++,k=i-1,l=j-1)
            {
                if (arr[i][j].bomb)
                try
                {
                    arr[i-1][j-1].n++;
                    arr[i][j-1].n++;
                    arr[i+1][j-1].n++;
                    arr[i-1][j].n++;
                    arr[i+1][j].n++;
                    arr[i-1][j+1].n++;
                    arr[i][j+1].n++;
                    arr[i+1][j+1].n++;
                }//try block
                catch(Exception e)
                {
                    j--;
                    continue;
                }//catch block
            }//for loop
        }//for loop
    }//fill()
    private void input()throws Exception
    {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        System.out.print(name+" : ");
        String s=br.readLine();
        boolean m=false;
        try
        {
            if (s.length()==3)
            {
                if (s.charAt(2)=='x'||s.charAt(2)=='X')
                {
                    s=s.substring(0,2);
                    m=true;
                }//if block
            }//if block
            if (s.length()==2)
            {
                int a=(s.charAt(0)-'0')-1;
                int b=(s.charAt(1)-'0')-1;
                if (m&&(!arr[a][b].visible))
                {
                    arr[a][b].mark=true;
                    nb++;
                }//if block
                else if (!m)//&&(arr[a][b].mark))
                {
                    arr[a][b].mark=false;
                    arr[a][b].visible=true;
                    if (arr[a][b].bomb)
                    {
                        win=false;
                        lose=true;
                    }//if block
                }//else if block
            }//if block
        }//try block
        catch(Exception e)
        {
        }//catch block
    }//input()
    private void check()
    {
        int c=0;
        for (int i=0;i<9;i++)
        {
            for (int j=0;j<9;j++)
            {
                if (arr[i][j].visible)
                c++;
            }
        }
        if (c>=71)
        win=true;
    }
    /**
     *  Enter your name in double quotes
     */
    public static void play(String NAME)throws Exception
    {
        Minesweeper obj = new Minesweeper();
        obj.initialize();
        obj.name=NAME;
        obj.set();
        obj.fill();
        while(true)
        {
            obj.display();
            obj.input();
            System.out.print('\f');
            if (lose)
            {
                for (int i=0;i<9;i++)
                {
                    for (int j=0;j<9;j++)
                    {
                        arr[i][j].visible=true;
                    }
                }
                obj.display();
                System.out.println("You Lose !");
                break;
            }//if block
            obj.check();
            if (win)
            {
                obj.display();
                System.out.println("You Win !");
                break;
            }
        }//while loop
    }//play()
}//class
class Node
{
    int n;
    boolean visible=false,bomb=false,mark=false;
    public void activateBomb()
    {
        this.bomb=true;
    }//activateBomb
}//Node