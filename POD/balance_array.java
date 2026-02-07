

import java.util.*;

public class balance_array {
    public static int minRemoval(int[] nums, int k) {
         List<Integer> l=new ArrayList<>();
        for(int num : nums) {
            l.add(num);
        }
        List<Integer> l1=new ArrayList<>();
       Collections.sort(l);
       int start=0,end=l.size()-1;
       while(start<end)
       {
            while(l.get(end)<=(l.get(start)*k))
            {
                if(l.contains(l.get(start)*k))
                {
                    end--;
                }
                else{
                    start++;
                    end--;
                }
            }
       }
       l1.add(nums[start]);
        l1.add(nums[end]);
        System.out.print(l1);
       return Math.abs(l1.size()-l.size());
    }

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int x=sc.nextInt();
       int[] arr=new int[x];
       for(int i=0;i<x;i++)
       {
           arr[i]=sc.nextInt();
       }
       int k=sc.nextInt();
       System.out.print(minRemoval(arr,k));
    }
}