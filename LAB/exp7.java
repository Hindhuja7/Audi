import java.util.*;
public class exp7 {
    public static void edge(List<List<Integer>> l,int u,int v)
    {
        l.get(u).add(v);
        l.get(v).add(u);
    }
    public static void dfs(List<List<Integer>> l,boolean[] visited,int u,int removed)
    {
        visited[u]=true;
        for(int j:l.get(u))
        {
            if(j==removed)
            {
                continue;
            }
            if(!visited[j])
            {
                dfs(l,visited,j,removed);
            }
        }
    }
    public static int count(List<List<Integer>> l,int v,int removed)
    {
        boolean[] visited=new boolean[v];
        int count=0;
        for(int i=0;i<v;i++)
        {
            if(i==removed) continue;
            if(!visited[i])
            {
                dfs(l,visited,i,removed);
                count++;
            }
        }
        return count;
    }
    public static void find(List<List<Integer>> l,int v)
    {
        int org=count(l,v,-1);
        for(int i=0;i<v;i++)
        {
            int x=count(l,v,i);
            if(x>org)
            {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        edge(adj, 1, 0);
        edge(adj, 0, 2);
        edge(adj, 2, 1);
        edge(adj, 0, 3);
        edge(adj, 3, 4);
        find(adj,V);
    }
}
