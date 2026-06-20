
// There are N cities, and M routes[], each route is a path between two cities.
// routes[i] = [city1, city2], there is a travel route between city1 and city2.
// Each city is numbered from 0 to N-1.
 
// There are one or more Regions formed among N cities. 
// A Region is formed in such way that you can travel between any two cities 
// in the region that are connected directly and indirectly.
 
// Your task is to findout the number of regions formed between N cities. 
 
// Input Format:
// -------------
// Line-1: Two space separated integers N and M, number of cities and routes
// Next M lines: Two space separated integers city1, city2.
 
// Output Format:
// --------------
// Print an integer, number of regions formed.
 
 
// Sample Input-1:
// ---------------
// 5 4
// 0 1
// 0 2
// 1 2
// 3 4
 
// Sample Output-1:
// ----------------
// 2
 
 
// Sample Input-2:
// ---------------
// 5 6
// 0 1
// 0 2
// 2 3
// 1 2
// 1 4
// 2 4
 
// Sample Output-2:
// ----------------
// 1
 


import java.util.*;
public class connected_compo {
    int v;
    List<List<Integer>> l;
    connected_compo(int v)
    {
        this.v=v;
        l=new ArrayList<>();
        for(int i=0;i<v;i++)
        {
            l.add(new ArrayList<>());
        }
    }
    public void edge(int u,int v)
    {
        l.get(u).add(v);
        l.get(v).add(u);
    }
    public void dfs( int v,boolean[] visited)
    {
        visited[v]=true;
        System.out.print(v + " ");
        for(int neigh:l.get(v))
        {
            if(!visited[neigh])
            {
                dfs(neigh,visited);
            }
        }
    }
    public void conn()
    {
        boolean[] visited=new boolean[v];
        int count=0;
        for(int i=0;i<v;i++)
        {
            if(!visited[i])
            {
                System.out.print("componenets: "+(count+1)+":");
                dfs(i,visited);
                System.out.println();
                count++;
            }
        }
        System.out.println("Total components: "+count);
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int e=sc.nextInt();
        connected_compo g = new connected_compo(x);
        for(int i=0;i<e;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            g.edge(u,v);
        }
        System.out.println("connected componenets: ");
        g.conn();
    }
}
