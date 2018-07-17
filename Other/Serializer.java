import java.io.*;
import java.util.*;

public class Serializer
{
    public static void main(String args[])throws IOException
    {
        ABC obj = new ABC();
        obj.a=5;
        System.out.println(Arrays.toString(serialize(obj)));
    }
    public static byte[] serialize(Object obj) throws IOException 
    {
        try(ByteArrayOutputStream b = new ByteArrayOutputStream())
        {
            try(ObjectOutputStream o = new ObjectOutputStream(b))
            {
                o.writeObject(obj);
            }
            return b.toByteArray();
        }
    }
    public static Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException 
    {
        try(ByteArrayInputStream b = new ByteArrayInputStream(bytes))
        {
            try(ObjectInputStream o = new ObjectInputStream(b))
            {
                return o.readObject();
            }
        }
    }
}
class ABC implements Serializable
{
    int a;
}