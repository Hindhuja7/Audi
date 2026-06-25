import java.util.*;
public class frequnecy_sort{
    public static int[] frequencySort(int[] nums) {
        Map<Integer,Integer> m=new HashMap<>();
        Map<Integer,Integer> m1=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            m.put(nums[i],m.getOrDefault(nums[i],0)+1);
        }
        for(int i=0;i<nums.length;i++)
        {
            if(!m1.containsKey(nums[i])){
                 m1.put(nums[i],i);
            }
        }
        List<Integer> l=new ArrayList<>();
        for(int i:m.keySet())
        {
            l.add(i);
        }
        Collections.sort(l,(a,b)->{
            if(m.get(a)!=m.get(b))
            {
                return m.get(b)-m.get(a);
            }
            return m1.get(a)-m1.get(b);
        });
        int n=0;
        int[] arr=new int[nums.length];
        for(int i:l)
        {
            int k=m.get(i);
            while(k-->0)
            {
                arr[n++]=i;
            }
        }
        return arr;
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
        System.out.print(Arrays.toString(frequencySort(arr)));
    }
}