import java.util.*;
public class ount_subarrays {
    // public static long countSubarrays(int[] nums, long k) {
    //     long max=Integer.MIN_VALUE,min=Integer.MAX_VALUE,count=0;
    //     int left=0;
    //     for(int right=0;right<nums.length;right++)
    //     {
    //         for(int i=left;i<=right;i++)
    //         {
    //             max=Math.max(nums[i],max);
    //             min=Math.min(nums[i],min);
    //         }
    //         while((max-min)*(right-left+1)>k)
    //         {
    //             left++;
    //         }
    //         count++;
    //     }
    //     return count;
    // }
    public static int dominantIndices(int[] nums) {
        int avg=0,count=0,sum=0,max=0;
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            {
                max=Math.max(max,nums[i]);
            }
        for(int i=1;i<nums.length;i++)
            {
                if(max>=2*nums[i])
                {
                    count++;
                }
            }
        return count;
    }

    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
       int x=sc.nextInt();
       int[] arr=new int[x];
       for(int i=0;i<x;i++)
       {
           arr[i]=sc.nextInt();
       }
       //int k=sc.nextInt();
       System.out.print(dominantIndices(arr));
    }

}
