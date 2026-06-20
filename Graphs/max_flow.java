import java.util.*;
public class max_flow {
    int v;
    max_flow(int v)
    {
        this.v=v;
    }
    public boolean dfs(int s,int t,int[][] graph,int[] parent)
    {
        boolean[] visited=new boolean[v];
        Stack<Integer> st=new Stack<>();
        st.push(s);
        visited[s]=true;
        parent[s]=-1;
        while(!st.isEmpty())
        {
            int k=st.pop();
            for(int i=0;i<v;i++)
            {
                if(!visited[i] && graph[k][i]>0)
                {
                    parent[i]=k;
                    visited[i]=true;
                    st.push(i);
                    if(i==t) return true;
                }
            }
        }
        return false;
    }
    public int maxi(int[][] graph,int s,int t)
    {
        int[][] rgraph=new int[v][v];
        for(int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                rgraph[i][j]=graph[i][j];
            }
        }
        int[] parent=new int[v];
        int max=0;
        while(dfs(s,t,rgraph,parent))
        {
            int path=Integer.MAX_VALUE;
            for(int i=t;i!=s;i=parent[i])
            {
                int u=parent[i];
                path=Math.min(path,rgraph[u][i]);
            }
            for (int i = t; i != s; i = parent[i]) {
                int u = parent[i];
                rgraph[u][i] -= path;
                rgraph[i][u] += path;
            }
            max+=path;
        }
        return max;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int[][] graph=new int[v][v];
        for(int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                graph[i][j]=sc.nextInt();
            }
        }
         System.out.print("Enter source and sink: ");
        int s = sc.nextInt();
        int t = sc.nextInt();
        max_flow m=new max_flow(v);
        System.out.println(m.maxi(graph,s,t));
    }
}
