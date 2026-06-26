import java.util.*;
public class longest_subarray_distinct{
    public static int sub(int[] arr)
    {
        List<Integer> l=new ArrayList<>();
        int left=0,max=Integer.MIN_VALUE;
        for(int right=0;right<arr.length;right++)
        {
            while(l.contains(arr[right]))
            {
                l.remove(Integer.valueOf(arr[left]));
                left++;
            }
            l.add(arr[right]);
            max=Math.max(max,right-left+1);
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
        System.out.print(sub(arr));
    }
}