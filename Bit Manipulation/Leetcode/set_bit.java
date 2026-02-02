package Leetcode;
import java.util.*;
public class set_bit {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int k=sc.nextInt();
        
            x|=1<<k;
        
        System.out.print(x);
    }
}
