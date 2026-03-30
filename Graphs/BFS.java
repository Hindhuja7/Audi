package Graphs;

import java.util.*;
public class BFS {
    public static boolean bfs(int[][] graph,int x,int s,int t,int[] parent)
    {
        boolean[] visited=new boolean[x];
        Queue<Integer> q=new LinkedList<>();
        int start=s;
        q.add(start);
        visited[start]=true;
        parent[s]=-1;
        while(!q.isEmpty())
        {
            int u=q.poll();
            for(int i=0;i<graph[0].length;i++)
            {
                if(graph[u][i]>0 && !visited[i])
                {
                    q.add(i);
                    visited[i]=true;
                    parent[i]=u;
                    if(i==t) return true;
                }
            }
        }
        return false;
    }
    
    public static int maxFlow(int[][] graph,int x,int s,int t,int[] parent)
    {
        int maxflow=0;
        while(bfs(graph,x,s,t,parent)){
            int v=t;
            int flow=Integer.MAX_VALUE;
            while(v!=s)
            {
                int u=parent[v];
                flow=Math.min(flow,graph[u][v]);
                v=u;
            }
            v=t;
            while(v!=s)
            {
                int u=parent[v];
                graph[u][v]-=flow;
                graph[v][u]+=flow;
                v=u;
            }
            maxflow+=flow;
        }
        return maxflow;
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
        int[] parent=new int[x];
        int s=sc.nextInt();
        int t=sc.nextInt();
        System.out.println(maxFlow(graph,x,s,t,parent));
    }
}
