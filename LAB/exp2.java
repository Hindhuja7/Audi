import java.util.*;
public class exp2 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int[] arr=new int[x];
        for(int i=0;i<x;i++)
        {
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        int[] p=new int[x+1];
        for(int i=0;i<x;i++)
        {
            p[i+1]=p[i]+arr[i];
        }
        Deque<Integer> d=new LinkedList<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<p.length;i++)
        {
            while(!d.isEmpty() && p[i]<=p[d.getLast()])
            {
                d.removeLast();
            }
            while(!d.isEmpty() && p[i]>=p[d.getFirst()]+k)
            {
                min=Math.min(min,i-d.removeFirst());
            }
            d.addLast(i);
        }
        System.out.print(min!=Integer.MAX_VALUE?min:-1);
    }
}
