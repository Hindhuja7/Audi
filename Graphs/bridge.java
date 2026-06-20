import java.util.*;
public class bridge {
    int v;
    LinkedList<Integer>[] l;
    int time=0;
    bridge(int v)
    {
        this.v=v;
        l=new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            l[i]=new LinkedList<>();
        }
    }
    public void edge(int u,int v)
    {
        l[u].add(v);
        l[v].add(u);
    }
    public void dfs(int u,boolean[] visited,int[] parent,int[] disc,int[] low)
    {
        visited[u]=true;
        disc[u]=low[u]=++time;
        for(int v:l[u])
        {
            if(!visited[v])
            {
                parent[v]=u;
                dfs(v,visited,parent,disc,low);
                low[u]=Math.min(low[v],low[u]);
                if(low[v]>disc[u])
                {
                    System.out.print("Bridge: "+u+"->"+v);
                }

            }
            else if(v!=parent[u])
            {
                low[u]=Math.min(low[u],disc[v]);
            }
        }
    }
    void find()
    {
        int[] disc=new int[v];
        int[] low=new int[v];
        boolean[] visited=new boolean[v];
        int parent[]=new int[v];
        Arrays.fill(parent,-1);
        for(int i=0;i<v;i++)
        {
            if(!visited[i])
            {
                dfs(i,visited,parent,disc,low);
            }
        }
    }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();
        bridge g=new bridge(V);
        System.out.println("Enter edges:");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.edge(u, v);
        }

        System.out.println("Bridges in the graph:");
        g.find();
    }
}
