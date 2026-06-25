import java.util.*;
public class max_dist {
    public static int maxi(int[] arr)
    {
        Map<Integer,Integer> m=new HashMap<>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(!m.containsKey(arr[i]))
            {
                m.put(arr[i],i);
            }
            else{
                max=Math.max(max,Math.abs(m.get(arr[i])-i));
            }
        }
        return max;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int[] arr=new int[x];
        for(int i=0;i<x;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.print(maxi(arr));
    }
}
