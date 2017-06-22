import java.util.*;
class GraphTheory
{
    ArrayList<Vertex> vertex;
    public GraphTheory()
    {
        vertex = new ArrayList<>();
    }//GraphTheory
    public void addVertex(int a)
    {
        vertex.add(new Vertex(a));
    }//setNeighbours
    public void addLink(int a,int b)
    {
        vertex.get(a).addNeighbour(b);
        vertex.get(b).addNeighbour(a);
    }//addLink
    public boolean isLinked(int a,int b)
    {
        return vertex.get(a).isNeighbour(b);
    }//isLinked
    public int size()
    {
        return vertex.size();
    }//size()
    public int neighbour(int a,int b)
    {
        // return index of given vertex at given position
        return vertex.get(a).getNeighbour(b);
    }//neighbour()
}//class
class Vertex
{
    ArrayList<Integer> neighbour = new ArrayList<>();
    int index;
    public Vertex(int index)
    {
        this.index=index;
    }//Vertex()
    public void addNeighbour(int index)
    {
        neighbour.add(index);
    }//addNeighbour
    public int getNeighbour(int a)
    {
        return neighbour.get(a);
    }//getNeighbour
    public boolean isNeighbour(int a)
    {
        for (int i=0;i<neighbour.size();i++)
        {
            if (a==neighbour.get(i))
                return true;
        }//for loop
        return false;
    }//isNeighbour()
}//class