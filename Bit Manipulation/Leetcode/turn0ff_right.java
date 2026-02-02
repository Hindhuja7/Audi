package Leetcode;
import java.util.*;
public class turn0ff_right {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        x=x&(x-1);
        System.out.print(x);
    }
}
