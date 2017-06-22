import java.util.*;
class Graph
{
    ArrayList<Vertex> vertex=new ArrayList<>();
    public void add(Vertex v)
    {
        vertex.add(v);
    }//add
    public int numberOfVertex()
    {
        return vertex.size();
    }//numberIfVertex
    public void addEdge(int a,int b)
    {
        vertex.get(a).addNeighbour(b);
        vertex.get(b).addNeighbour(a);
    }
    public Vertex getVertex(int a)
    {
        return vertex.get(a);
    }
}//class
class Vertex
{
    String name;
    int index;
    Node neighbour;
    public Vertex(int index)
    {
        this.index=index;
        neighbour=new Node(index);
    }//Vertex()
    public Vertex(int index,String name)
    {
        this.index=index;
        this.name=name;
        neighbour=new Node(index);
    }//Vertex()
    public void addNeighbour(int index)
    {
        neighbour.insert(index);
    }//addNeighbour()
    public void showNeighbour()
    {
        neighbour.println();
    }//showNeighbour()
    public boolean isNeighbour(int index)
    {
        return neighbour.contains(index);
    }//isNeighbour()
    public String getName()
    {
        return name;
    }
    public int getIndex()
    {
        return index;
    }
}//class