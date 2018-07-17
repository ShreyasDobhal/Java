class GarbageCollection
{
    public static void main(String args[])
    {
        GarbageCollection a = new GarbageCollection();
        GarbageCollection b = new GarbageCollection();
        System.gc();
        a.show();
    }
    public void finalize()
    {
        System.out.println("Cleaned");
    }
    public void show()
    {
        System.out.println("Hello");
    }
}