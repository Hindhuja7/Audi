import java.util.*;
public class slide_wind {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[x];
        for(int i=0;i<x;i++)
        {
            arr[i]=sc.nextInt();
        }
        int j=0;
        while(j<x)
        {
            for(int i=j;i<k;i++)
            {
                System.out.print(arr[i]+" ");
            }
            j++;
            k+=j;
        }
    }
}
