package Leetcode;
import java.util.*;
public class modulud_2 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        int mask=1<<y;
        System.out.print((x&~(mask)));
    }
}
