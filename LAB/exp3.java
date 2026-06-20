import java.util.*;
public class exp3{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int[] arr=new int[x];
        for(int i=0;i<x;i++)
        {
            arr[i]=sc.nextInt();
        }
        int y=sc.nextInt();
        int z=sc.nextInt();
        int sum=0;
        for(int i=y;i<=z;i++)
        {
            sum+=arr[i];
        }
        System.out.print(sum);
    }
}