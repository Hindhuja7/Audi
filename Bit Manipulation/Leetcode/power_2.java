package Leetcode;
import java.util.*;
public class power_2 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int pos=0;
        while(x>0)
        {
            if((x&1)==1)
            {
                pos++;
            }
            x>>=1;
        }
        if(pos==1)
            System.out.print(true);
        else{
            System.out.print(false);
        }
    }
}
