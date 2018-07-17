import java.io.*;
class Serialize
{
    public static void main(String args[]) throws Exception
    {
        load();
        save((int)(Math.random()*10),(int)(Math.random()*10));
        load();
    }
    public static void load()throws Exception
    {
        File f = new File("saveObj.txt");
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Save obj = (Save)ois.readObject();
        System.out.println("Loaded");
        System.out.println(obj);
    }
    public static void save(int x,int y)throws Exception
    {
        Save obj = new Save();
        obj.x=x;
        obj.y=y;
        File f = new File("saveObj.txt");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        System.out.println("Saved");
        System.out.println(obj);
    }
}
class Save implements Serializable
{
    int x,y;
    @Override
    public String toString()
    {
        return "( "+x+" ," +y+" )";
    }
    public void set(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
}