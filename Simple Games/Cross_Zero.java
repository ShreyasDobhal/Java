import java.io.*;

class Cross_Zero
{
    public static boolean x[]={false,false,false,false,false,false,false,false,false};
    public static boolean o[]={false,false,false,false,false,false,false,false,false};
    public static String p1="";
    public static String p2="";
    public static String w="";
    public static int chance=0;
    private static void board()
    {
        for (int i=0;i<9;i++)
        {
            if (x[i])
            System.out.print("X");
            else if (o[i])
            System.out.print("O");
            else
            System.out.print(i+1);
            System.out.print('\t');
            
            if (i==2 || i==5 ||i==8 )
            System.out.println();
            else
            System.out.print("|");
        }//for loop
    }//board()
    private static boolean win()
    {
        if ((x[0]&&x[1]&&x[2])||(x[3]&&x[4]&&x[5])||(x[6]&&x[7]&&x[8])||(x[0]&&x[3]&&x[6])||(x[1]&&x[4]&&x[7])||(x[2]&&x[5]&&x[8])||(x[0]&&x[4]&&x[8])||(x[2]&&x[4]&&x[6]))
        {
            w=p1;
            return true;
        }
        if ((o[0]&&o[1]&&o[2])||(o[3]&&o[4]&&o[5])||(o[6]&&o[7]&&o[8])||(o[0]&&o[3]&&o[6])||(o[1]&&o[4]&&o[7])||(o[2]&&o[5]&&o[8])||(o[0]&&o[4]&&o[8])||(o[2]&&o[4]&&o[6]))
        {
            w=p2;
            return true;
        }
        return false;
    }//win()
    private static void move1()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(p1+" : ");
        String a=br.readLine();
        if (!(a.length()>0))
        {
            System.out.println("Invalid move!");
            move1();
        }
        char c=a.charAt(0);
        if (Character.isDigit(c))
        {
            int n=((int)c)-49;
            if (!(x[n]||o[n]))
            x[n]=true;
            else
            {
                System.out.println("Invalid move!");
                move1();
            }
        }
        else
        {
            System.out.println("Invalid move!");
            move1();
        }
    }//move1()
    private static void move2()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(p2+" : ");
        String a=br.readLine();
        if (!(a.length()>0))
        {
            System.out.println("Invalid move!");
            move2();
        }
        char c=a.charAt(0);
        if (Character.isDigit(c))
        {
            int n=((int)c)-49;
            if (!(x[n]||o[n]))
            o[n]=true;
            else
            {
                System.out.println("Invalid move!");
                move2();
            }
        }
        else
        {
            System.out.println("Invalid move!");
            move2();
        }
    }//move2()
    public static void main(String args[])throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println(" - Cross and Zero - ");
        System.out.println();
        System.out.println(" Main Menu ");
        System.out.println();
        System.out.println("1) Play ");
        System.out.println("2) Help ");
        System.out.println("3) Info ");
        System.out.println("4) Exit ");
        
        System.out.println();
        System.out.print(" : ");
        String choice=br.readLine();
        char c=choice.charAt(0);
        int n=0;
        if (Character.isDigit(c))
        {
            n=((int)c)-48;
            System.out.print('\f');
        }//if block
        switch (n)
        {
            case 1:
                for (int i=0;i<9;i++)
                {
                    x[i]=false;
                    o[i]=false;
                }//for loop
                System.out.print("Name of Player 1 : ");
                p1=br.readLine();
                System.out.print("Name of Player 2 : ");
                p2=br.readLine();
        
                chance=0;
                w="";
        
                Thread.sleep(500);
                System.out.print('\f');
                while (!win()||chance<9)
                {
                    chance+=1;
                    board();
                    System.out.println();
                    move1();
                    System.out.print('\f');
                    board();
                    if (win())
                    break;
                    System.out.println();
                    move2();
                    System.out.print('\f');
                }//while loop
                System.out.print('\f');
                board();
                System.out.println();
                if (chance==9)
                System.out.println(" Draw ");
                else
                System.out.println(w+" Wins");
                Thread.sleep(3000);
                break;
            case 2:
                System.out.println("Enter the number of the corresponding block");
                System.out.println("to place cross or zero");
                System.out.println("One who comes first in making a sequence wins");
                Thread.sleep(10000);
                break;
            case 3:
                System.err.println("This game was made by Shreyas");
                Thread.sleep(3000);
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Wrong choice");
                Thread.sleep(2000);
                break;
        }//switch block
        System.out.print('\f');
        main(args);
    }//main()
}//class