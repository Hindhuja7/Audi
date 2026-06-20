import java.util.*;
public class exp5 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int[] arr=new int[x];
        for(int i=0;i<x;i++)
        {
            arr[i]=sc.nextInt();
        }
        int count=0;
        for(int i=0;i<x;i++)
        {
            for(int j=i+1;j<x;j++)
            {
                if(arr[i]>2*arr[j])
                {
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}
