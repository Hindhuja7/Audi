import java.util.*;
public class segment_tree{
    public static void seg(int[] arr,int[] tree,int node,int low,int high)
    {
        if (low==high)
        {
            tree[node]=arr[low];
            return;
        }
        int mid=(low+high)/2;
        seg(arr,tree,2*node+1,low,mid);
        seg(arr,tree,2*node+2,mid+1,high);
        tree[node]=tree[2*node+1]+tree[2*node+2];
    }
    public static int query(int[] tree,int node,int low,int high,int l,int r)
    {
        if(r<low || high<l )
        {
            return 0;
        }
        if(l<=low && high<=r)
        {
            return tree[node];
        }
        int mid=(low+high)/2;
        int left=query(tree,2*node+1,low,mid,l,r);
        int right=query(tree,2*node+2,mid+1,high,l,r);
        return left+right;
    }
    public static void update(int[] tree,int node,int low,int high,int index,int val)
    {
        if(low==high && low==index)
        {
            tree[node]=val;
            return;
        }
        int mid=(low+high)/2;
        if(index<=mid)
            update(tree,2*node+1,low,mid,index,val);
        else
            update(tree,2*node+2,mid+1,high,index,val);
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
        seg(arr,tree,0,0,x-1);
        for(int i=0;i<q;i++)
        {
            int option=sc.nextInt();
            int l=sc.nextInt();
            int r=sc.nextInt();
            if(option==1)
            {
                 System.out.println(query(tree,0,0,x-1,l,r));
            }
            else{
                update(tree,0,0,x-1,l,r);
            }
        }
    }
}