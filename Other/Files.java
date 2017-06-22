import java.io.*;
class Files
{
    public static void main()
    {
        try
        {
            FileWriter fw = new FileWriter("data.dat");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter p = new PrintWriter(bw);
            p.println("");
            p.flush();
            fw.close();
        }
        catch (Exception e)
        {
            System.out.println("Writing error");
        } 
        try
        {
            FileReader fr = new FileReader("learn.dat");
            BufferedReader br = new BufferedReader(fr);
            String s="";
            while ((s=br.readLine())!=null)
            {
                System.out.println(s);
            }
        }
        catch (Exception e)
        {
            System.out.println("Reading error");
        }
    }
}