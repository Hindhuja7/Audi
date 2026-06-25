import java.util.*;
public class first_non_repeating{
    public static int firstUniqChar(int[] arr) {
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            m.put(arr[i],m.getOrDefault(arr[i],0)+1);
        }
        for(int i=0;i<arr.length;i++)
        {
            if(m.get(arr[i])>1)
            {
                return arr[i];
            }
        }
        return -1;
    }
     public static int firstdup(int[] arr)
     {
        Set<Integer> s=new HashSet<>();
        for(int i=0;i<arr.length;i++)
        {
            if(!s.contains(arr[i]))
            {
                s.add(arr[i]);
            }
            else{
                return arr[i];
            }
        }
        return -1;
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
        System.out.print(firstdup(arr));
    }
}