
import java.util.*;

class Message
{
    static String msg = "Hello World";
    static int msgLen = msg.length();
    static double mutation = 0.01;
    static int populationSize = 100;
    
    public static void main()
    {
        // Creating population of specified individuals
        Population p = new Population(populationSize,msgLen);
        p.createPopulation();
        int gen=1;
        while (true)
        {
            // Fittest individual of the population
            int fittest = p.calcFitness(msg);
            // Printing the fittest String
            System.out.println(p.org[fittest].data+" : "+p.score[fittest]);
            // Checking for optimal solution
            if (p.score[fittest]==msgLen)
                break;
            // Preparing new generation
            p.createMatingPool();
            p.createNewPopulation(mutation);
            gen++;
        }//while loop
        System.out.println("Task Completed !");
        System.out.println("Population number : "+populationSize);
        System.out.println("Generation number : "+gen);
        System.out.println("Mutation level : "+(mutation*100)+"%");
    }//main()
}//class
class Population
{
    Individual org[];
    int score[];
    double fitnessRatio[];
    ArrayList<Individual> pool = new ArrayList<>();
    public Population(int n,int l)
    {
        // creating n organism in the population
        org = new Individual[n];
        for (int i=0;i<n;i++)
            org[i] = new Individual(l);
        score = new int[n];
        fitnessRatio = new double[n];
    }//Population()
    public void createPopulation()
    {
        // giving characteristic traits to individual organisms
        for (int i=0;i<org.length;i++)
            org[i].randomize();
    }//createPopulation()
    public int calcFitness(String msg)
    {
        int index=0;
        int maxScore=0;
        for (int i=0;i<org.length;i++)
        {
            score[i]=org[i].calcFitness(msg);
            if (score[i]>maxScore)
            {
                maxScore=score[i];
                index=i;
            }
        }//for loop
        // returning index of fitest individual
        return index;
    }//calcFitness()
    public void fitnessRatio()
    {
        double sum=0;
        for (int i=0;i<org.length;i++)
            sum+=Math.pow(score[i],1);
        for (int i=0;i<org.length;i++)
            fitnessRatio[i] = Math.pow(score[i],1)/sum;
    }//fitnessRatio()
    public void createMatingPool()
    {
        pool = new ArrayList<>();
        fitnessRatio();
        for (int i=0;i<org.length;i++)
        {
            for (int j=0;j<fitnessRatio[i]*100;j++)
                pool.add(org[i]);
        }//for loop
    }//createMatingPool()
    public void createNewPopulation(double mutation)
    {
        int l=org.length;
        Individual tmp[]=new Individual[l];
        for (int i=0;i<l;i++)
        {
            Individual parentA = pool.get((int)(Math.random()*pool.size()));
            Individual parentB = pool.get((int)(Math.random()*pool.size()));
            Individual newChild = parentA.crossOver(parentB);
            tmp[i] = newChild.mutate(mutation);
        }
        for (int i=0;i<l;i++)
            org[i]=tmp[i];
    }//createNewPopulation()
}//class
class Individual
{
    String data;
    int len;
    public Individual(int l)
    {
        data="";
        len = l;
    }//Individual()
    public Individual(String msg)
    {
        data=msg;
        len=data.length();
    }
    public void randomize()
    {
        for (int i=0;i<len;i++)
        {
            int tmp=(((int)(Math.random()*('z'-'A'+1)))+'A');
            if (tmp==91)
                tmp = 44;
            else if (tmp==92)
                tmp = 46;
            else if (tmp==93)
                tmp = 32;
            data = data + (char)tmp;
        }
    }
    public int calcFitness(String msg)
    {
        int fitness=0;
        for (int i=0;i<len;i++)
        {
            if (data.charAt(i)==msg.charAt(i))
                fitness++;    
        }
        return fitness;
    }//calcFitness()
    public Individual crossOver(Individual other)
    {
        int mid=len/2;
        // crossing over from the middle
        String newData = this.data.substring(0,mid)+other.data.substring(mid);
        // returning new child (individual)
        return new Individual(newData);
    }//crossOver()
    public Individual mutate(double m)
    {
        String newData="";
        for (int i=0;i<len;i++)
        {
            if (Math.random()<=m)
            {
                //mutate the char
                int tmp=(((int)(Math.random()*('z'-'A'+1)))+'A');
                if (tmp==91)
                    tmp = 44;
                else if (tmp==92)
                    tmp = 46;
                else if (tmp==93)
                    tmp = 32;
                newData=newData+(char)tmp;
            }//if block
            else
                newData=newData+data.charAt(i);
        }//for loop
        // returning new mutated individual
        return new Individual(newData);
    }//mutate()
}//class
