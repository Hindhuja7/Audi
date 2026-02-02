package Leetcode;
import java.util.*;
public class XOR {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        String s1=Integer.toBinaryString(x);
        String s2=Integer.toBinaryString(y);
        int i=s1.length()-1,j=s2.length()-1;
        StringBuilder s=new StringBuilder();
        while(i>=0 || j>=0)
        {
            char b1=(i>=0) ? s1.charAt(i) : '0';
            char b2=(j>=0) ? s2.charAt(j) : '0';
            if(b1==b2)
            {
                s.append("0");
            }
            else{
                s.append("1");
            }
            i--;
            j--;
        }
        System.out.print(s.reverse().toString());
    }
}
