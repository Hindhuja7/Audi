package AP_program;
import java.util.*;
public class subsequence {
    public static int sub(int[] arr,int n)
    {
        int zeros=0,count=0;
        for(int j=0;j<32;j++)
        {
            int ones=0;
            for(int i=0;i<n;i++)
            {
                int bit=1<<j;
                if((arr[i]&bit)!=0)
                {
                    ones++;
                }
            }
            zeros=n-ones;
            count+=ones*zeros;
        }
        return count;
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
        System.out.print(sub(arr,x));
        // int mask=0,count=0;
        // for(int i=0;i<x;i++)
        // {
        //     for(int j=i+1;j<x;j++)
        //     {
        //         int bit=arr[i]^arr[j];
        //         while(bit>0){
        //             if((bit&1)==1)
        //             {
        //                 count++;
        //             }
        //             bit>>=1;
        //         } 
        //     }
        // }
        // System.out.print(count);
    }
}
