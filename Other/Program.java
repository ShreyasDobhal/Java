import java.io.*;
import java.util.*;
import Shreyas.*;
public class Program
{
    /**
     *  Enter the name of your program
     */
    public static void main(String name)throws Exception
    {
        Scanner sc=new Scanner(System.in);
        String code[]=new String[200];
        int i=0;
        Window.open();
        Shreyas.File.write(name,".class", "Êþº¾   3 !<init> ()V Code LineNumberTable LocalVariableTable this    LProgram; main (Ljava/lang/String;)V name Ljava/lang/String; Exceptions  SourceFile Program.java   .txt Hello     Program java/lang/Object java/lang/Exception Shreyas/File write 9(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V !                  /     *· ±      7         *¸ ±    ");
        Shreyas.File.write(name,".ctxt","#BlueJ class context \n comment0.params=name \n comment0.target=void "+"\\"+" main(java.lang.String) \n comment0.text=\r\n"+"\\"+ "\\"+" Enter"+ "\\"+"the"+ "\\"+" name"+ "\\"+" of"+ "\\"+" your"+ "\\"+" program\r\n \n numComments=1");
        FileWriter f = new FileWriter(name+".java");
        BufferedWriter b = new BufferedWriter(f);
        PrintWriter p = new PrintWriter(b);
        while (true)
        {
            String temp=sc.nextLine();
            if (temp.equalsIgnoreCase("end"))
                break;
            else
                code[i++]=temp;
        }//while loop
        for (int j=0;j<i;j++)
        {
            p.println(code[j]);
            
        }//for loop
        p.flush();
        f.close();
    }//main()
}//class