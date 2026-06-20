import java.util.*;
public class segment_tree{
   public static void seg(int[] tree,int[] arr,int node,int low,int high)
   {
        if(low==high)
        {
            tree[node]=arr[low];
            return;
        }
        int mid=(low+high)/2;
        seg(tree,arr,2*node+1,low,mid);
        seg(tree,arr,2*node+2,mid+1,high);
        tree[node]=tree[2*node+1]+tree[2*node+2];
   }
   public static int sum(int[] tree,int node,int l,int r,int low,int high)
   {
    if(r<low || high<l)
    {
        return 0;
    }
    if(l<=low && high<=r)
    {
        return tree[node];
    }
    int mid=(low+high)/2;
    int left=sum(tree,2*node+1,l,r,low,mid);
    int  right=sum(tree,2*node+2,l,r,mid+1,high);
    return left+right;
   }
   public static void update(int[] tree,int node,int low,int high,int i,int val)
   {
    if(low==high && low==i)
    {
        tree[node]=val;
        return;
    }
    int mid=(low+high)/2;
    if(i<=mid)
    {
        update(tree,2*node+1,low,mid,i,val);
    }
    else{
         update(tree,2*node+2,mid+1,high,i,val);
    }
    tree[node]=tree[2*node+1]+tree[2*node+2];
   }
   public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int q=sc.nextInt();
        int[] arr=new int[x];
        for(int i=0;i<x;i++)
        {
            arr[i]=sc.nextInt();
        }
        int tree[]=new int[4*x];
        seg(tree, arr, 0, 0, x - 1);
        for(int i=0;i<q;i++)
        {
            int option=sc.nextInt();
            int l=sc.nextInt();
            int r=sc.nextInt();
            if(option==1)
            {
                 System.out.println(sum(tree, 0, l, r, 0, x - 1));
            }
            else{
                update(tree, 0, 0, x - 1, l, r);
            }
        }
    }
}