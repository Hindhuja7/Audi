
import java.util.*;
public class fenwick_tree {
    static int x;
    static int[] trees;
    public static void update(int i,int val)
    {
        while(i<=x)
        {
            trees[i]+=val;
            i+=(i&-i);
        }
    }
    public static int sum(int i)
    {
        int sum=0;
        while(i>0)
        {
           sum+=trees[i];
            i-=(i&-i);
        }
        return sum;
    }
    public static int sumr(int l,int r)
    {
        return sum(r)-sum(l-1);
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        x=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[x];
        for(int i=0;i<x;i++)
        {
            arr[i]=sc.nextInt();
        }
        trees=new int[x+1];
        for(int i=0;i<x;i++)
        {
            update(i+1,arr[i]);
        }
        while(k-->0)
        {
            int z=sc.nextInt();
            if(z==1)
            {
                int l=sc.nextInt();
                int m=sc.nextInt();
                update(l+1,m);
            }
            else{
                int l=sc.nextInt();
                int m=sc.nextInt();
                System.out.print(sumr(l+1,m+1));
            }
        }
    }
}
