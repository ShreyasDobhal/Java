import java.io.*;

class Coin_Collector_Game
{
    //global variables
    int x,y;//coordinates in the x and y axis
    int room_width,room_height;//limit of x and y axis
    int score=0,point=5;
    char sprite;
    String up,down,left,right;//direction of motion
    String end;//Key to end the Coin_Collector_Game
    String key;//Key enterred by the user
    
    public Coin_Collector_Game()
    {
        //setting the limits of the room
        room_width=100;
        room_height=15;
        //setting the control keys
        up="w";
        down="s";
        left="a";
        right="d";
        //setting the ending key
        end="esc";
    }//Coin_Collector_Game()
    public void border()
    {
        for (int i=1;i<=room_width;i++)
        System.out.print('-');//drawing border
        System.out.println();//leaving line
    }//border
    public void draw(Coin_Collector_Game a,Coin_Collector_Game b)
    {
        if (a.y>b.y)
        {
            for (int i=0;i<b.y;i++)
            System.out.println();
            for (int i=0;i<b.x;i++)
            System.out.print(' ');
            
            System.out.print(b.sprite);
            
            for (int i=0;i<(a.y-b.y);i++)
            System.out.println();
            for (int i=0;i<a.x;i++)
            System.out.print(' ');
            
            System.out.print(a.sprite);
            
            for (int i=a.y;i<=room_height;i++)
            System.out.println();
        }//if block
        else if (a.y<b.y)
        {
            for (int i=0;i<a.y;i++)
            System.out.println();
            for (int i=0;i<a.x;i++)
            System.out.print(' ');
            
            System.out.print(a.sprite);
            
            for (int i=0;i<(b.y-a.y);i++)
            System.out.println();
            for (int i=0;i<b.x;i++)
            System.out.print(' ');
            
            System.out.print(b.sprite);
            
            for (int i=b.y;i<=room_height;i++)
            System.out.println();
        }//else if block
        else
        {
            for (int i=0;i<a.y;i++)
            System.out.println();
            
            if (a.x>b.x)
            {
                for (int i=0;i<b.x;i++)
                System.out.print(' ');
                
                System.out.print(b.sprite);
                
                for (int i=b.x;i<a.x-1;i++)
                System.out.print(' ');
                
                System.out.print(a.sprite);
                
                for (int i=a.y;i<=room_height;i++)
                System.out.println();
            }//if block
            else if (a.x<b.x)
            {
                for (int i=0;i<a.x;i++)
                System.out.print(' ');
                
                System.out.print(a.sprite);
                
                for (int i=a.x;i<b.x-1;i++)
                System.out.print(' ');
                
                System.out.print(b.sprite);
                
                for (int i=a.y;i<=room_height;i++)
                System.out.println();
            }//else if block
            else
            {
                for (int i=0;i<a.x;i++)
                System.out.print(' ');
                
                System.out.print(a.sprite);
                
                for (int i=a.y;i<=room_height;i++)
                System.out.println();
                
                score+=point;
                
                b.x=random(room_width-1);//setting x coordinate to random
                b.y=random(room_height-1);//setting y coordinate to random
                clear();
                border();
                draw(a,b);
            }//else block
        }//else block
    }//draw()
    public Coin_Collector_Game update(Coin_Collector_Game a)
    {
        if (a.key.equalsIgnoreCase(up)&&a.y>0)
        a.y-=1;
        if (a.key.equalsIgnoreCase(down)&&a.y<room_height)
        a.y+=1;
        if (a.key.equalsIgnoreCase(left)&&a.x>0)
        a.x-=1;
        if (a.key.equalsIgnoreCase(right)&&a.x<room_width)
        a.x+=1;
        return a;
    }//update()
    public void delay(int x)
    {
        System.out.print("Loading ");
        for (int i=0;i<=x;i++)
        {
            for (int j=0;j<=1000000000;j++)
            {
                //empty nested loop
            }//j loop
            System.out.print('.');
        }//i loop
        System.out.println();
    }//delay()
    public void clear()
    {
        System.out.println('\f');
    }//clear()
    public void credits()
    {
        System.err.println("This program was made by : ");
        System.err.println("Shreyas Dobhal ");
        System.err.println("Thank You");
    }//credits()
    public int random(int a)
    {
        int b=(int)(Math.random()*a)+2;
        return b;
    }//random()
    public void main()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Coin_Collector_Game obj_player = new Coin_Collector_Game();//declaring object player
        Coin_Collector_Game obj_coin = new Coin_Collector_Game();//declaring object coin
        
        obj_player.key="";//nulling the key
        obj_player.x=room_width/2;//setting x coordinate to centre
        obj_player.y=room_height/2;//setting y coordinate to centre
        obj_player.sprite='☻';//setting sprite of the player
        
        obj_coin.x=random(room_width-1);//setting x coordinate to random
        obj_coin.y=random(room_height-1);//setting y coordinate to random
        obj_coin.sprite='☼';//setting sprite of the coin
        
        //Messages
        System.out.println("Controls : -");
        System.out.println("w, a, s, d ");
        System.out.println("Enter 'esc' to exit ");
        System.out.println();
        System.out.println("To play, type in the desired control key");
        System.out.println("and then press Enter");
        System.out.println("Move towards the coin to collect it.");
        delay(10);
        clear();
        
        //Coin_Collector_Game
        while (!obj_player.key.equalsIgnoreCase(end))
        {
            border();//drawing upper border
            draw(obj_player,obj_coin);//drawing position of player and coin
            border();//drawing lower border
            System.out.println(" Score : "+score+'\n');//displaying score
            System.out.print(" Controls : ");//message for inputting control
            obj_player.key=br.readLine();//inputting control
            if (obj_player.key.length()>=1&&(!obj_player.key.equalsIgnoreCase(end)))
            {
                char cha=obj_player.key.charAt(0);//extracting the first character
                obj_player.key="";//nulling the String
                obj_player.key+=cha;//concatenating the char
            }//if block
            update(obj_player);//updating position of the player
            clear();//clearing the screen for next slide
        }//while loop
        credits();//showing credits
    }//main()
}//class