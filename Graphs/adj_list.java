// Write a program to implement a Graph using an Adjacency List.

// The graph contains a fixed number of vertices. The program should support the 
// following operations:

// Add a vertex to the graph.
// Add an edge between two vertices.
// Remove an edge between two vertices.
// Remove a vertex from the graph.
// Display the adjacency list representation of the graph.

// The graph is directed, meaning if there is an edge from vertex u to vertex v, 
// it does not automatically create an edge from v to u.

// Input:
// =========
//
// Edge removed:
// 0 1
// Vertex removed:
// 2
// Output:
// =========
// Graph:
// 0 -> 1 2
// 1 -> 2
// 2 ->

// After removing edge (0,1):
// 0 -> 2
// 1 -> 2
// 2 ->

// After removing vertex 2:
// 0 ->
// 1 ->


package Graphs;
import java.util.*;
public class adj_list {
    public static void edge(List<List<Integer>> l,int u,int v)
    {
        l.get(u).add(v);
    }
    public static void addvertex(List<List<Integer>> l)
    {
        l.add(new ArrayList<>());
    }
    public static void removeedge(List<List<Integer>> l,int u,int v)
    {
        l.get(u).remove(Integer.valueOf(v));
    }
    public static void removever(List<List<Integer>> l,int u)
    {
        for(int i=0;i<l.size();i++)
        {
            l.get(i).remove(Integer.valueOf(u));
        }
        l.remove(u);
        for(int i=0;i<l.size();i++)
        {
            for(int j=0;j<l.get(i).size();j++)
            {
                if(l.get(i).get(j)>u)
                {
                    l.get(i).set(j,l.get(i).get(j)-1);
                }
            }
        }
    }
    public static void display(List<List<Integer>> l)
    {
        for(int i = 0; i < l.size(); i++)
        {
            System.out.print(i + " -> ");
            for(int v : l.get(i))
            {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int p=sc.nextInt();
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<x;i++)
        {
           l.add(new ArrayList<>());
        }
        for(int i=0;i<p;i++)
        {
            int u=sc.nextInt();
           int v=sc.nextInt();
           edge(l,u,v);
        }
        for(int i=0;i<x;i++)
        {
            for(int v:l.get(i))
            {
                System.out.print(v+" ");
            }
            System.out.println();
        }
        int y=sc.nextInt();
        while(y != -1)
        {
            if(y == 1) // remove edge
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                removeedge(l, u, v);

                System.out.println("After removing edge (" + u + "," + v + "):");
                display(l);
            }
            else if(y == 2) // remove vertex
            {
                int u = sc.nextInt();
                removever(l, u);

                System.out.println("After removing vertex " + u + ":");
                display(l);
            }
            else if(y == 3) // add vertex
            {
                addvertex(l);

                System.out.println("After adding vertex:");
                display(l);
            }

            y = sc.nextInt(); // IMPORTANT (update choice)
        }
    }
}
