// package trees;
// import java.util.*;
// public class fenwick_tree {
//      static int x;
//      static int[] trees;
//     public static void update(int i,int arr)
//     {
//         while(i<=x)
//         {
//             trees[i]+=arr;
//             i+=(i&-i);
//         }
//     }
//     public static int query(int i)
//     {
//         int sum=0;
//         while(i>0)
//         {
//             sum+=trees[i];
//             i-=(i&-i);
//         }
//         return sum;
//     }
//     public static void main(String[] args)
//     {
//         Scanner sc=new Scanner(System.in);
//         x=sc.nextInt();
//         int[] arr=new int[x];
//         for(int i=0;i<x;i++)
//         {
//             arr[i]=sc.nextInt();
//         }
//         trees=new int[x+1];
//         for(int i=0;i<x;i++)
//         {
//             update(i+1,arr[i]);
//         }
//         System.out.print(query(3));
//     }
// }
