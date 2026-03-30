package Graphs;
import java.util.*;
public class dfs {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Stack<Integer> s=new Stack<>();
        int x=sc.nextInt();
        int[][] arr=new int[x][x];
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<x;j++)
            {
                 arr[i][j]=sc.nextInt();
            }
        }
        boolean[] visited=new boolean[x];
        s.push(0);
        visited[0]=true;
        while(!s.isEmpty())
        {
            int u=s.pop();
            System.out.print(u+" ");
            for(int i=0;i<x;i++)
            {
                if(arr[u][i]>0 && !visited[i])
                {
                    s.push(i);
                    visited[i]=true;
                }
            }
        }
    }
}
