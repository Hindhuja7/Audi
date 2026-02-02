package Leetcode;
import java.util.*;
public class only_set {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int pos=1,count=0;
        while(x>0)
        {
            if((x&1)==1)
            {
                count++;
                pos++;
            }
            x>>=1;
        }
        if(count>1)
        {
            System.out.print("-1");
        }
        else{
            System.out.print(pos);
        }
    }
}
