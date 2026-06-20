import java.util.*;
public class exp6 {
    public static void edge(List<List<Integer>> l,int u,int v)
    {
        l.get(u).add(v);
    }
    public static void topo(List<List<Integer>> l,int x,boolean visited[],Stack<Integer> s)
    {
        visited[x]=true;
        Iterator<Integer> it=l.get(x).iterator();
        while(it.hasNext())
        {
            int i=it.next();
            if(!visited[i])
            {
                topo(l,i,visited,s);
            }
        }
        s.push(x);
    }
    static void topol(List<List<Integer>> l,int v)
    {
        Stack<Integer> st=new Stack<Integer>();
        boolean[] visited=new boolean[v];
        for(int i=0;i<v;i++)
        {
            visited[i]=false;
        }
        for(int i=0;i<v;i++)
        {
            if(visited[i]==false)
            {
                topo(l,i,visited,st);
            }
        }
        while(!st.empty())
        {
            System.out.print(st.pop()+" ");
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<x;i++)
        {
            l.add(new ArrayList<>());
        }
        for(int i=0;i<x;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            edge(l,u,v);
        }
        topol(l,x);
    }
}
