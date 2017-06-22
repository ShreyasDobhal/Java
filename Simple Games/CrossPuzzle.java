/**
*   Use W, A, S, D followed by enter key to move the numbered blocks around the method call window
*   The program is assumed to run on a method window which supports the \f carriage return
*   that is meant to clear the screen on every frame. Some compliers do not supprot that.
*   BlueJ IDE is an example which does support the clear screen \f
*
*   The 0 represents the null block or void space which can be used to move other blocks around
*   Arrange the blocks such that the sequence is correct that is 1,2,3..
*/

import java.io.*;

class CrossPuzzle
{
    private int arr[][];
    private String name="";
    private int x,y;
    public CrossPuzzle(String Name)
    {
        arr=new int[4][4];
        name=Name;
        x=y=0;
    }//CrossPuzzle()
    public void set()
    {
        // Function to fill in random numbers
        boolean ck[]=new boolean[17];
        int N[]=new int[17];
        int n[]=new int[17];
        for (int i=1;i<17;i++)
        {
            ck[i]=false;
            N[i]=i;
        }//for loop
        for (int i=1;i<=16;i++)
        {
            int a=(int)(Math.random()*16)+1;
            while (ck[a])
            a=(int)(Math.random()*16)+1;
            {
                n[i]=N[a];
                ck[a]=true;
            }//if block
        }//for loop
        for (int i=0,k=1;i<4;i++)
        {
            for (int j=0;j<4;j++,k++)
            {
                if (n[k]!=16)
                arr[i][j]=n[k];
            }//for loop
        }//for loop
        findPos();
    }//set()
    private void show() // Function to display the Grid
    {
        for (int i=0;i<4;i++)
        {
            for (int j=0;j<4;j++)
            {
                System.out.print(arr[i][j]+"\t");
            }//for loop
            System.out.println();
        }//for loop
    }//show()
    private void findPos() // Function to Find Position of 0
    {
        outer : for (int i=0;i<4;i++)
        {
            inner : for (int j=0;j<4;j++)
            {
                if (arr[i][j]==0)
                {
                    x=i;
                    y=j;
                    break outer;
                }//if block
            }//inner for 
        }//outer for
        //System.out.println("x : "+x+" y : "+y);
    }//findPos()
    public boolean check()// Check whether the player has won
    {
        int brr[]=new int[16];
        for (int i=0,k=0;i<4;i++)
            for (int j=0;j<4;j++,k++)
                brr[k]=arr[i][j];
        int i;
        for (i=0;i<15&&brr[i]==i+1;i++)
        ;
        if (i==15)
        return true;
        else
        return false;
    }//check()
    private void moveUp()
    {
        try
        {
            int t = arr[x][y];
            arr[x][y]=arr[x+1][y];
            arr[x+1][y]=t;
        }//try block
        catch(ArrayIndexOutOfBoundsException e)
        {
            ;
        }//catch block
        finally
        {
            System.out.print("\f");
            show();
        }//finally block
    }//moveUp()
    private void moveLeft()
    {
        try
        {
            int t = arr[x][y];
            arr[x][y]=arr[x][y+1];
            arr[x][y+1]=t;
        }//try block
        catch(ArrayIndexOutOfBoundsException e)
        {
            ;
        }//catch block
        finally
        {
            System.out.print("\f");
            show();
        }//finally block
    }//moveLeft()
    private void moveRight()
    {
        try
        {
            int t = arr[x][y];
            arr[x][y]=arr[x][y-1];
            arr[x][y-1]=t;
        }//try block
        catch(ArrayIndexOutOfBoundsException e)
        {
            ;
        }//catch block
        finally
        {
            System.out.print("\f");
            show();
        }//finally block
    }//moveRight()
    private void moveDown()
    {
        try
        {
            int t = arr[x][y];
            arr[x][y]=arr[x-1][y];
            arr[x-1][y]=t;
        }//try block
        catch(ArrayIndexOutOfBoundsException e)
        {
            ;
        }//catch block
        finally
        {
            System.out.print("\f");
            show();
        }//finally block
    }//moveDown()
    private void end()
    {
        System.exit(0);
    }//end()
    public void input()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(name+" : ");
        char c='0';
        try
        {
            c = (br.readLine()).charAt(0);
        }//try block
        catch(Exception e)
        {
            ;
        }//catch block
        switch (c)
        {
            case 'w':
            moveUp();
            break;
            case 'a':
            moveLeft();
            break;
            case 's':
            moveDown();
            break;
            case 'd':
            moveRight();
            break;
            case '*':
            end();
            break;
        }//switch block
    }//input()
    public static void Scores()throws IOException
    {
        try
        {
            FileInputStream fo = new FileInputStream("high.bin");
            DataInputStream d = new DataInputStream(fo);
            int i=0;
            while (true)
            {
                System.out.println((++i)+") "+d.readUTF()+" : "+d.readInt());
            }//while loop
        }//try block
        catch(FileNotFoundException e)
        {
            System.out.println("\fNo List Found");
        }//catch block
        catch(EOFException e)
        {
            ;
        }//catch block
    }//Scores()
    private void dataFeed(int i)throws IOException
    {
        FileOutputStream fo = new FileOutputStream("high.bin",true);
        DataOutputStream d = new DataOutputStream(fo);
        d.writeUTF(name);
        d.writeInt(i);
    }//dataFeed()
    public static void play()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your name : ");
        CrossPuzzle obj = new CrossPuzzle(br.readLine());
        obj.set();
        obj.show();
        int i=0;
        do
        {
            i++;
            obj.input();
            obj.findPos();
        }//while loop
        while (!obj.check());
        System.out.println("\f Won !");
        obj.dataFeed(i);
    }
}//class
