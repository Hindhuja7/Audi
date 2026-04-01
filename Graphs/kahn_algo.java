package Graphs;
import java.util.*;
public class kahn_algo {
    public static void edge(List<List<Integer>> l, int u,int v)
    {
        l.get(u).add(v);
    }
    public static void topo(List<List<Integer>> l,int x)
    {
        int[] indegree=new int[x];
        for(int i=0;i<x;i++)
        {
            for(int j:l.get(i))
            {
                indegree[j]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<x;i++)
        {
            
                if(indegree[i]==0)
                {
                    q.add(i);
                }
        }
        while(!q.isEmpty())
        {
            int k=q.poll();
            System.out.print(k+" ");
            for(int j=0;j<l.get(k).size();j++)
            {
                int o=l.get(k).get(j);
                indegree[o]--;
                if(indegree[o]==0)
                {
                    q.add(o);
                }
            }
        }
    }
   public static void main(String[] args)
   {
    Scanner sc=new Scanner(System.in);
    int x=sc.nextInt();
    List<List<Integer>> l=new ArrayList<>();
    for(int i=0;i<x;i++)
    {
        l.add(new ArrayList());
    }
    for(int i=0;i<x;i++)
    {
        int u=sc.nextInt();
        int v=sc.nextInt();
        edge(l,u,v);
    }
    topo(l,x);
   }
}
