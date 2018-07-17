
import java.util.*;

/**
 *  Team ID      -  eyrc#509
 *  Author List  -  Ch. Kalyan Prusty
 *                  Shreyas Dobhal
 *                  Prakhar Srivastava
 *                  Shubham Tripathi
 * File Name     -  AStar.java
 * Theme         -  Harvester Bot
 * Functions     -  main
 *                  align
 *                  generatePath
 *                  setTargetOrder
 *                  allOrder
 *                  permute
 *                  calcPath
 *                  heuristics
 *                  initGrid
 *                  resetGrid
 * Inner Classes -  pathCommand
 *                  TreeType
 *                  treeLocation
 *                  Tree
 *                  Node
 * Global Var    -  m of integer type
 */

class AStarPathFinding
{
    public static final int m=7;
    /**
     * Input - String args[]
     * Output - void
     * Description - 
     * 
     * Main method for printing the path for traversal
     */
    public static void main(String args[])throws Exception
    {
        pathCommand obj=generatePath(args);
        Queue<Integer> path=obj.path;
        String treeSeq=obj.treeSeq;
        Node grid[][]=obj.grid;
        HashMap<Integer,Integer> map=obj.map;
        HashMap<Integer,treeLocation> treeMap = obj.treeMap;
        
        String commands="";
        String tree[]=treeSeq.split(" ");
        int treeIndex=0;
        int curr=Integer.valueOf(tree[treeIndex]);
        Set<Integer> fruits = new HashSet<>();
        int i=curr/m;
        int j=curr%m;
        
        treeLocation tmpTre = treeMap.get(curr);
        HashMap<Integer,String> fruitInfo = new HashMap<>();
        if (i>0&&!grid[i-1][j].isTree&&tmpTre.req[2])
        {
            fruits.add(grid[i-1][j].pos);
            fruitInfo.put(grid[i-1][j].pos,tmpTre.fruitInfo[2]);
        }
        if (i<m-1&&!grid[i+1][j].isTree&&tmpTre.req[0])
        {
            fruits.add(grid[i+1][j].pos);
            fruitInfo.put(grid[i+1][j].pos,tmpTre.fruitInfo[0]);
        }
        if (j>0&&!grid[i][j-1].isTree&&tmpTre.req[3])
        {
            fruits.add(grid[i][j-1].pos);
            fruitInfo.put(grid[i][j-1].pos,tmpTre.fruitInfo[3]);
        }
        if (j<m-1&&!grid[i][j+1].isTree&&tmpTre.req[1])
        {
            fruits.add(grid[i][j+1].pos);
            fruitInfo.put(grid[i][j+1].pos,tmpTre.fruitInfo[1]);
        }
        
        int prev=0;
        int next=0;
        int dir=0;
        int move=-1;
        while (!path.isEmpty())
        {
            next=path.remove();
            boolean cut=false;
            if (fruits.contains(next))
            {
                cut=true;
                fruits.remove(next);
            }
            if (next-prev==1) // move right
                move=1;
            else if (next-prev==-1) // move left
                move=3;
            else if (next-prev==m) // move up
                move=0;
            else if (next-prev==-m) // move down
                move=2;
            else // stay
                move=-1;
            if (move==-1)
                continue;
            commands=commands+align(dir,move)+"F";
            dir=move;
            prev=next;
            if (cut) // cut
            {
                move=curr-prev;
                if (move==1) // move right
                    move=1;
                else if (move==-1) // move left
                    move=3;
                else if (move==m) // move up
                    move=0;
                else if (move==-m) // move down
                    move=2;
                else // stay
                    move=-1;
                commands=commands+align(dir,move)+"X"+fruitInfo.get(next);
                dir=move;
            }
            if (fruits.size()==0)
            {
                if (map.get(curr)==next)
                {
                    treeIndex++;
                    if (treeIndex>=tree.length)
                        continue;
                    else
                        curr=Integer.valueOf(tree[treeIndex]);
                    fruits = new HashSet<>();
                    fruitInfo = new HashMap<>();
                    i=curr/m;
                    j=curr%m;
                    
                    treeLocation tmpTree = treeMap.get(curr);
                    if (i>0&&!grid[i-1][j].isTree&&tmpTree.req[2])
                    {
                        fruits.add(grid[i-1][j].pos);
                        fruitInfo.put(grid[i-1][j].pos,tmpTree.fruitInfo[2]);
                    }
                    if (i<m-1&&!grid[i+1][j].isTree&&tmpTree.req[0])
                    {
                        fruits.add(grid[i+1][j].pos);
                        fruitInfo.put(grid[i+1][j].pos,tmpTree.fruitInfo[0]);
                    }
                    if (j>0&&!grid[i][j-1].isTree&&tmpTree.req[3])
                    {
                        fruits.add(grid[i][j-1].pos);
                        fruitInfo.put(grid[i][j-1].pos,tmpTree.fruitInfo[3]);
                    }
                    if (j<m-1&&!grid[i][j+1].isTree&&tmpTree.req[1])
                    {
                        fruits.add(grid[i][j+1].pos);
                        fruitInfo.put(grid[i][j+1].pos,tmpTree.fruitInfo[1]);
                    }
                    commands=commands+align(dir,move)+"O";
                }
            }
        }
        System.out.println(commands+"OT");
    }
    /**
     * Input - int dir, int move
     * Output - String
     * Description - 
     * 
     * Aligns the bot at given dir to new direction
     * Input has two int values, the current direction and the required dir
     * Output is a string of single character,
     * the required motion command
     */
    private static String align(int dir,int move)
    {
        String com[]={"","R","U","L"};
        return com[(move-dir+com.length)%com.length];
    }
    /**
     * Inner class for Encapsulation (binding data)
     * for returning several values
     */
    static class pathCommand
    {
        Queue<Integer> path;
        String treeSeq;
        Node grid[][];
        HashMap<Integer,Integer> map;
        HashMap<Integer,treeLocation> treeMap;
        public pathCommand(Queue<Integer> path,String treeSeq,Node grid[][],HashMap<Integer,Integer> map,HashMap<Integer,treeLocation> treeMap)
        {
            this.path=path;
            this.treeSeq=treeSeq;
            this.grid=grid;
            this.map=map;
            this.treeMap=treeMap;
        }
    }
    /**
     * Inner class for storing information of a type of tree
     * eg. Apple , Blueberry or Orange
     */
    static class TreeType
    {
        int num;
        int pos[];
        String fruitSize[][];
        boolean reqFruit[][];
        int depo;
        int req[];
        public void setNum(int num)
        {
            this.num=num;
            pos=new int[num];
            fruitSize=new String[num][4];
            reqFruit=new boolean[num][4];
            req=new int[3];
        }
    }
    /**
     * Inner class for storing location and other information of each tree
     */
    public static class treeLocation
    {
        int pos;
        boolean req[];
        String fruitInfo[];
        public treeLocation(int pos)
        {
            this.pos=pos;
            req=new boolean[4];
            fruitInfo=new String[4];
        }
    }
    /**
     * Generates the path for required tree and fruit position
     * and sends the path to main  
     */
    public static pathCommand generatePath(String args[])throws Exception
    {
        int argIndex=0;
        TreeType treeType[]=new TreeType[3];
        HashMap<Integer,treeLocation> treeMap = new HashMap<>();
        
        // Tree Table
        for (int i=0;i<3;i++)
        {
            int n=Integer.valueOf(args[argIndex++]);
            treeType[i]=new TreeType();
            treeType[i].setNum(n);
            for (int j=0;j<n;j++)
            {
                treeType[i].pos[j]=Integer.valueOf(args[argIndex++]);
                treeMap.put(treeType[i].pos[j],new treeLocation(treeType[i].pos[j]));
            }
        }
        
        // Fruit Table
        for (int i=0;i<3;i++)
            for (int j=0;j<treeType[i].num;j++)
                for (int k=0;k<4;k++)
                {
                    String info=args[argIndex++];
                    treeType[i].fruitSize[j][k]=info;
                }
        
        // Deposition Zone Table
        for (int i=0;i<3;i++)
            treeType[i].depo=Integer.valueOf(args[argIndex++]);
        
        // Required Fruit Table
        for (int i=0;i<3;i++)
        {
            char key[]={'0','1','2'};
            for (int j=0;j<3;j++)
            {
                treeType[i].req[j]=Integer.valueOf(args[argIndex++]);
                int required=treeType[i].req[j];
                for (int k=0;k<treeType[i].num;k++)
                {
                    treeLocation tmpTree = treeMap.get(treeType[i].pos[k]);
                    for (int l=0;l<4;l++)
                    {
                        String fruitSize=treeType[i].fruitSize[k][l];
                        if (required==0)
                            break;
                        if (fruitSize.charAt(0)==key[j])
                        {
                            required-=1;
                            treeType[i].reqFruit[k][l]=true;
                            tmpTree.req[l]=true;
                            tmpTree.fruitInfo[l]=i+fruitSize;
                        }
                    }
                }
            }
        }
        
        int n=0;
        for (int i=0;i<3;i++)
            n+=treeType[i].num;
        
        Tree tree[]=new Tree[n];
        Queue<Integer> path = new LinkedList<>();
        Queue<Integer> treeOrder = new LinkedList<>();
        Queue<Integer> zoneOrder = new LinkedList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        Node grid[][]=new Node[m][m];
        int treePos[]=new int[n];
        for (int i=0;i<m;i++)
            for (int j=0;j<m;j++)
                grid[i][j]=new Node(i,j);
        
        int zone[]=new int[n];
        
        for (int i=0,k=0;i<3;i++)
        {
            for (int j=0;j<treeType[i].num;j++,k++)
            {
                int pos=treeType[i].pos[j];
                tree[k]=new Tree(pos);
                treePos[k]=pos;
                int a=tree[k].y;
                int b=tree[k].x;
                grid[a][b].isTree=true;
                treeOrder.add(pos);
                pos=treeType[i].depo;
                zone[k]=pos;
                zoneOrder.add(pos);
                map.put(treePos[k],zone[k]);
            }
        }
        
        initGrid(grid);
        
        Queue<String> treeCom = new LinkedList<>();
        treeCom=allOrder(treePos);
        
        boolean firstPath=true;
        String bestTreeSeq="";
        while (!treeCom.isEmpty()) // for every combination possible 
        {
            String currOrder = treeCom.remove();
            Queue<Integer> currPath =new LinkedList<>();
            Node start=grid[0][0];
            Node end=grid[m-1][m-1];
            treeOrder=setTargetOrder(treeOrder,zoneOrder,currOrder);
            
            while (!treeOrder.isEmpty()) // for each tree in current order
            {
                int posTree=treeOrder.remove();
                ArrayList<Integer> targetNodes = new ArrayList<>();
                int i=posTree/m;
                int j=posTree%m;
                
                treeLocation tmpTree = treeMap.get(posTree);
                if (i>0&&!grid[i-1][j].isTree&&tmpTree.req[2])
                    targetNodes.add(grid[i-1][j].pos);
                if (i<m-1&&!grid[i+1][j].isTree&&tmpTree.req[0])
                    targetNodes.add(grid[i+1][j].pos);
                if (j>0&&!grid[i][j-1].isTree&&tmpTree.req[3])
                    targetNodes.add(grid[i][j-1].pos);
                if (j<m-1&&!grid[i][j+1].isTree&&tmpTree.req[1])
                    targetNodes.add(grid[i][j+1].pos);
                
                while (!targetNodes.isEmpty()) // for each fruits in current tree
                {
                    int pos=targetNodes.remove(0);
                    end=grid[pos/m][pos%m];
                    Queue<Integer> tmpPath = new LinkedList<>();
                    tmpPath=calcPath(start,end,grid);
                    for (int num:tmpPath)
                    {
                        currPath.add(num);
                        for (int ind=0;ind<targetNodes.size();ind++)
                        {
                            if (num==targetNodes.get(ind))
                            {
                                targetNodes.remove(ind);
                                break;
                            }
                        }
                    }
                    resetGrid(grid);
                    start=end;
                }
                int zonePos=map.get(posTree);
                end=grid[zonePos/m][zonePos%m];
                Queue<Integer> tmpPath = new LinkedList<>();
                tmpPath=calcPath(start,end,grid);
                for (int num:tmpPath)
                    currPath.add(num);
                resetGrid(grid);
                start=end;
            }
            if (firstPath)
            {
                firstPath=false;
                for (int num:currPath)
                    path.add(num);
                bestTreeSeq=currOrder;
            }
            else
            {
                if (currPath.size()<path.size())
                {
                    path=new LinkedList<>();
                    for (int num:currPath)
                        path.add(num);
                    bestTreeSeq=currOrder;
                }
            }
        }
        pathCommand obj = new pathCommand(path,bestTreeSeq,grid,map,treeMap);
        return obj;
    }
    /**
     * Generates the next permutation of tree / fruit ordering
     */
    public static Queue<Integer> setTargetOrder(Queue<Integer> treeOrder,Queue<Integer> zoneOrder,String currOrder)
    {
        String str[]=currOrder.split(" ");
        treeOrder=new LinkedList<>();
        for (String s:str)
            treeOrder.add(Integer.valueOf(s));
        return treeOrder; 
    }
    /**
     * Returns a list of all possible combinations of tree ordering
     */
    public static Queue<String> allOrder(int arr[])
    {
        Queue<String> com = new LinkedList<>();
        permute(arr,0,arr.length-1,com);
        return com;
    }
    /**
     * Reorders the input array
     */
    public static void permute(int arr[],int l,int r,Queue<String> com)
    {
        int i;
        if (l==r)
        {
            String str="";
            for (int num:arr)
                str=str+num+" ";
            com.add(str);
        }
        else
        {
            for (i=l;i<=r;i++)
            {
                int tmp=arr[l];
                arr[l]=arr[i];
                arr[i]=tmp;
                
                permute(arr,l+1,r,com);
                
                tmp=arr[l];
                arr[l]=arr[i];
                arr[i]=tmp;
            }
        }
    }
    /**
     * Calculates the shortest path from the start node to end node in the given grid
     * using A* algorithm
     */
    public static Queue<Integer> calcPath(Node start,Node end,Node grid[][])throws Exception
    {
        Set<Integer> openSet = new HashSet<>();
        Set<Integer> closedSet = new HashSet<>();
        openSet.add(start.pos);
        boolean finished=false;
        Queue<Integer> path = new LinkedList<>();
        Stack<Integer> backTrack = new Stack<>();
        while (!openSet.isEmpty())
        {
            int winner=-1;
            for (int i:openSet)
            {
                if (winner==-1)
                    winner=i;
                if (grid[i/m][i%m].f<grid[winner/m][winner%m].f)
                    winner=i;
            }
            Node curr=grid[winner/m][winner%m];
            if (curr==end||winner==end.pos)
            {
                Node str=curr;
                while (str!=null)
                {
                    backTrack.push(str.pos);
                    str=str.previous;
                }
                finished=true;
                break;
            }
            openSet.remove(curr.pos);
            closedSet.add(curr.pos);
            
            Queue<Node> neighbors = curr.neighbors;
            for (Node neighbor:neighbors)
            {
                if (!closedSet.contains(neighbor.pos)&&!neighbor.isTree)
                {
                    int tempG=curr.g+1;
                    if (openSet.contains(neighbor.pos))
                    {
                        if (tempG<neighbor.g)
                            neighbor.g=tempG;
                    }
                    else
                    {
                        neighbor.g=tempG;
                        openSet.add(neighbor.pos);
                    }
                    neighbor.h=heuristic(neighbor,end);
                    neighbor.f=neighbor.g+neighbor.h;
                    neighbor.previous=curr;
                }
            }
        }
        if (!finished)
            path=null;
        else
            while (!backTrack.isEmpty())
                path.add(backTrack.pop());
        return path;
    }
    /**
     * Heuristic function for Algorithm
     * 
     * it determines the efficiency of the A* algorithm
     * 
     * it gives the approx net distance between two nodes
     * assuming there are no obstacles on the way
     * 
     * can be replaced by Euclidean Distance formula (if moving diagonally was allowed)
     */
    public static int heuristic(Node a,Node b)
    {
        int d = Math.abs(a.i-b.i)+Math.abs(a.j-b.j);
        return d;
    }
    /**
     * Initializes the grid by forming connections and neighbors
     * Forms a graph with nodes and edges for using shortest path algorithm
     */
    public static void initGrid(Node grid[][])
    {
        for (int i=0;i<m;i++)
        {
            for (int j=0;j<m;j++)
            {
                if(i>0&&!grid[i-1][j].isTree)
                    grid[i][j].addNeighbor(grid[i-1][j]);
                if(i<m-1&&!grid[i+1][j].isTree)
                    grid[i][j].addNeighbor(grid[i+1][j]);
                if(j>0&&!grid[i][j-1].isTree)
                    grid[i][j].addNeighbor(grid[i][j-1]);
                if(j<m-1&&!grid[i][j+1].isTree)
                    grid[i][j].addNeighbor(grid[i][j+1]);
            }
        }
    }
    /**
     * Resets the grid by removing all connections
     */
    public static void resetGrid(Node grid[][])
    {
        for (int i=0;i<m;i++)
            for (int j=0;j<m;j++)
                grid[i][j].reset();
    }
    static class Tree
    {
        int x,y;
        public Tree(int loc)
        {
            x=loc%m;
            y=loc/m;
        }
    }
    /**
     * Inner class for Vertex of graph network
     */
    static class Node
    {
        int i,j,pos;
        int f,g,h;
        Queue<Node> neighbors;
        Node previous;
        boolean isTree;
        public Node(int i,int j)
        {
            this.i=i;
            this.j=j;
            this.pos=i*m+j;
            neighbors=new LinkedList<>();
        }
        public void addNeighbor(Node other)
        {
            this.neighbors.add(other);
        }
        public void reset()
        {
            f=0;
            g=0;
            h=0;
            previous=null;
        }
    }
}