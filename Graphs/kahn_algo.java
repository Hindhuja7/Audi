package Graphs;
import java.util.*;
public class kahn_algo {
    // public static void bfs(int[][] arr,int x)
    // {
    //     Queue<Integer> q1=new LinkedList<>();
    //     int[] indegree=new int[x];
    //     for(int i=0;i<x;i++)
    //     {
    //         for(int j=0;j<x;j++)
    //         {
    //             if(arr[i][j]>0)
    //             {
    //                 indegree[j]++;
    //             }
    //         }
    //     }
    //     for(int i=0;i<x;i++)
    //      {
    //         if(indegree[i]==0){
    //             q1.add(i);
    //         }
    //     }
    //     while(!q1.isEmpty())
    //     {
    //         int u=q1.poll();
    //         System.out.print(u+" ");
    //         for(int i=0;i<x;i++)
    //         {
    //             if(arr[u][i]>0)
    //             {
    //                 indegree[i]--;
    //                 if(indegree[i]==0)
    //                 {
    //                     q1.add(i);
    //                 }
    //             }
    //         }
    //     }
    // }
    public static void bfs()
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        // int[][] arr=new int[x][x];
        // for(int i=0;i<x;i++)
        // {
        //     for(int j=0;j<x;j++)
        //     {
        //         arr[i][j]=sc.nextInt();
        //     }
        // }
        for(int i=0;i<x;i++)
        {
            int ed1=sc.nextInt();
            int ed2=sc.nextInt();
        }
        //bfs(arr,x);
    }
}
