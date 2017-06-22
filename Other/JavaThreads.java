class JavaThreads
{
    public static void main(String args[])
    {
        Thread thread1 = new Threads();
        thread1.start();
        Thread thread2 = new Thread(new Run());
        thread2.start();
        Thread thread3=new Thread(new Run(),"3rd Thread");
        System.out.println(thread3.getName());
    }
    public static class Threads extends Thread
    {
        @Override
        public void run()
        {
            System.out.println("Thread created by class");
        }
    }
    public static class Run implements Runnable
    {
        @Override
        public void run()
        {
            System.out.println("Thread created by interface");
        }
    }
}