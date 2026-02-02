package Leetcode;
import java.util.*;
public class odd_occurences {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int[] arr=new int[x];
        for(int i=0;i<x;i++)
        {
            arr[i]=sc.nextInt();
        }
        int mask=0;
        for(int i=0;i<x;i++)
        {
            int bit=1<<arr[i];
            mask^=bit;
        }
        int pos=0;
        while((mask&1)==0)
        {
            mask>>=1;
            pos++;
        }
        System.out.print(pos);
    }
}
