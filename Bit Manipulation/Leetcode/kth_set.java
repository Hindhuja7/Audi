package Leetcode;
import java.util.*;
public class kth_set {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int k=sc.nextInt();
        String s=Integer.toBinaryString(x);
        if((s.charAt(k)&1)==1)
        {
            System.out.print("Set");
        }
        else{
            System.out.print("not set");
        }
    }
}
