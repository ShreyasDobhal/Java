class MultiThreads
{
    public static void main(String args[])
    {
        Thread thread1=new Threads();
        Thread thread2=new Threads();
        thread1.start();
        thread2.start();
    }
    public static class Threads extends Thread
    {
        @Override
        public void run()
        {
            Thread t=Thread.currentThread();
            for (int i=0;i<10;i++)
                System.out.println(i+") "+t.getName());
        }
    }
}