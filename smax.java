import java.util.*;
public class smax{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int[] arr=new int[x];
        for(int i=0;i<x;i++)
        {
            arr[i]=sc.nextInt();
        }
        int large=arr[0],smax=Integer.MIN_VALUE;
        for(int i=1;i<x;i++)
        {
            if(arr[i]>large)
            {
                large=arr[i];
            }
        }
        for(int i=1;i<x;i++)
        {
            if(arr[i]>smax && arr[i]<large)
            {
                smax=arr[i];
            }
        }
        System.out.print(smax);
    }
}