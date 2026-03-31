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
    public static void edge(int x,int u,int v)
    {
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<x;i++)
        {
            l.add(new ArrayList());
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        for(int i=0;i<x;i++)
        {
           int u=sc.nextInt();
           int v=sc.nextInt();
        }
    }
}
