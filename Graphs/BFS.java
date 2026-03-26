package Graphs;

import java.util.*;
public class BFS {
    public static void bfs(int[][] graph,int x)
    {
        boolean[] visited=new boolean[x];
        Queue<Integer> q=new LinkedList<>();
        int start=0;
        q.add(start);
        visited[start]=true;
        while(!q.isEmpty())
        {
            int u=q.poll();
            for(int i=0;i<graph[0].length;i++)
            {
                if(graph[u][i]>0 && !visited[i])
                {
                    q.add(i);
                    visited[i]=true;
                }
            }
            System.out.print(u+" ");
        }

    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int[][] graph=new int[x][x];
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<x;j++)
            {
                graph[i][j]=sc.nextInt();
            }
        }
        bfs(graph,x);
    }
}
