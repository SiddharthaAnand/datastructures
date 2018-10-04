//This is a java program to represent graph as a adjacency list
package problem_solving;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
 
public class Graph 
{
    private Map<Integer, List<Integer>> adjacencyList;
 
    public Graph(int v) 
    {
        adjacencyList = new HashMap<Integer, List<Integer>>();
        for (int i = 1; i <= v; i++)
            adjacencyList.put(i, new LinkedList<Integer>());
    }
 
    public void setEdge(int to, int from) 
    {
        if (to > adjacencyList.size() || from > adjacencyList.size())
            System.out.println("The vertices does not exists");
        if (to < from) {
            List<Integer> sls = adjacencyList.get(to);
            sls.add(from);
        }
        else {
            List<Integer> dls = adjacencyList.get(from);
            dls.add(to);
        }
    }
 
    public List<Integer> getEdge(int to) 
    {
        if (to > adjacencyList.size()) 
        {
            System.out.println("The vertices does not exists");
            return null;
        }
        return adjacencyList.get(to);
    }
 
    public static void main(String args[]) 
    {
        int v, e, count = 1, to, from;
        Scanner sc = new Scanner(System.in);
        Graph glist;
        try 
        {
            System.out.println("Enter the number of vertices: ");
            v = sc.nextInt();
            System.out.println("Enter the number of edges: ");
            e = sc.nextInt();
 
            glist = new Graph(v);
 
            System.out.println("Enter the edges in the graph : <to> <from>");
            while (count <= e) 
            {
                to = sc.nextInt();
                from = sc.nextInt();
 
                glist.setEdge(to, from);
                count++;
            }
 
            System.out.println("The Adjacency List Representation of the graph is: ");
 
            for (int i = 1; i <= v; i++) 
            {
                System.out.print(i + "->");
                List<Integer> edgeList = glist.getEdge(i);
                for (int j = 1;; j++) 
                {
                    if (j != edgeList.size())
                        System.out.print(edgeList.get(j - 1) + " -> ");
                    else 
                    {
                        System.out.print(edgeList.get(j - 1));
                        break;
                    }
                }
                System.out.println();
            }
        } 
        catch (Exception E) 
        {
            System.out.println("Something went wrong");
        }
        sc.close();
    }
}
