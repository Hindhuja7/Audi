import java.util.*;
public class exp1{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int[] arr=new int[x];
        int k=sc.nextInt();
        for(int i=0;i<x;i++)
        {
            arr[i]=sc.nextInt();
        }
        int count=0;
        for(int i=0;i<x;i++)
        {
            HashSet<Integer> h=new HashSet<>();
            for(int j=i;j<x;j++)
            {
                 h.add(arr[j]);
                if(h.size()==k)
                {
                    count++;
                }
                else if(h.size()>k)
                {
                    break;
                }
            }
        }
        System.out.print(count);
    }
}