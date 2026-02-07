import java.util.*;
public class maxlen_subarray {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
       int x=sc.nextInt();
       int[] arr=new int[x];
       for(int i=0;i<x;i++)
       {
           arr[i]=sc.nextInt();
       }
       int k=sc.nextInt();
       int left=0,sum=0,maxlen=0;
       for(int right=0;right<x;right++)
       {
            sum+=arr[right];
            while(sum<k)
            {
                sum-=arr[left];
                left++;
            }
            maxlen=Math.min(maxlen,right-left+1);
       }
       System.out.print(maxlen);
    }
}
