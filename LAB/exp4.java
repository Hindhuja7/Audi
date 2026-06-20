import java.util.*;
public class exp4{
    public static void main(String[] args)
{
    Scanner sc=new Scanner(System.in);
    Set<Integer> s=new HashSet<>();
    int x=sc.nextInt();
    int[][] arr=new int[x][2];
    for(int i=0;i<x;i++)
    {
        for(int j=0;j<2;j++)
        {
            arr[i][j]=sc.nextInt();
        }
    }
   
Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));

    for(int i=0;i<x;i++)
    {
        for(int j=arr[i][0];j<=arr[i][1];j++)
        {
            if(!s.contains(j))
            {
                s.add(j);
                break;
            }
        }
    }
    System.out.print(s.size());
}
}