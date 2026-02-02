package Leetcode;
import java.util.*;
public class check_limit {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        int sum=x+y;
        if(x>0 && y>0 && sum<0 || x<0 && y<0 && sum>0)
        {
            System.out.print(-1);
        }
        else{
            System.out.print(sum);
        }
    }
}
