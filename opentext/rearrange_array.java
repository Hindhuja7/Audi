import java.util.*;
public class rearrange_array {
    public static int[] rearrange(int[] arr)
    {
        int prev=0;
        int[] arr1=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]%2==0)
            {
               arr1[prev++]=arr[i];
            }
        }
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]%2!=0)
            {
                arr1[prev++]=arr[i];
            }
        }
        return arr1;
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
        System.out.print(Arrays.toString(rearrange(arr)));
    }
}
