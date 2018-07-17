import java.io.*;
class TryResources
{
    public static void main(String args[])throws IOException
    {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            String s=br.readLine();
            System.out.println(s);
        }
    }
}