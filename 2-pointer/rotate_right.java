import java.util.*;
public class rotate_right
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x= sc.nextInt();
        int[] arr=new int[x];
        for(int i=0;i<x;i++)
        {
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        k%=x;
        while(k!=0){
            int l=arr[x-1];
            for(int i=x-1;i>0;i--)
            {
                arr[i]=arr[i-1];
            }
            arr[0]=l;
            k--;
        }
        for(int i=0;i<x;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}